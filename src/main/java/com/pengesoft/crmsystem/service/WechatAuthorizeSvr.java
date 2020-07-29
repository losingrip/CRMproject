package com.pengesoft.crmsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.pengesoft.crmsystem.component.Result;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import pengesoft.account.*;
import pengesoft.client.HttpClientProxy;
import pengesoft.common.IPSFNetException;
import pengesoft.core.PsCoreRuntimeException;
import pengesoft.service.ApplicationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pengesoft.service.INotifyMsgService;
import pengesoft.service.NotifyMsgService;
import pengesoft.service.SmsStates;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Service
@Transactional
public class WechatAuthorizeSvr extends ApplicationBase implements IWechatAuthorizeSvr{
    @Autowired
    private IAccountManager accountManager;

    @Autowired
    private IPersonManager personManager;

    private String session_key;

    private String openid;

    private LoginResult loginResult;
    Map<String,String> map = new HashMap<>();

    @Autowired
    private ISessionManager sessionManager;

    @Value("${py.weixUrl}")
    private String weixUrl;

    @Value("${py.weixAppid}")
    private String weixAppid;

    @Value("${py.weixScret}")
    private String weixScret;

    /**

     * 构造方法
     */
    @Autowired
    public WechatAuthorizeSvr(){
        //TODO: 通过构造方法参数设置依赖注入.
    }

    /**

     * 微信用户认证  .
     *
     * @param code 登录凭证code.
     */
    @Override
    public Result login(String code) {
        Result result = new Result();
        Map map = getOpenId(code);
        session_key = map.get("session_key")+"";
        openid = map.get("openid")+"";
        //根据openid获取用户信息
        Person person = null;
        try {
            person = personManager.GetByIds("","",openid);
        } catch (IPSFNetException e) {
            throw new PsCoreRuntimeException("获取用户信息失败！");
        }
        //微信号已与账户绑定，获取token
        if(person!=null){
            try {
                UserInfo info = new UserInfo();
                info.assignFrom(person);
                loginResult = sessionManager.Login("","",person.getUniqID(),person.getName(),person.getNickName(),"","",0,info);
                if(loginResult.getCode()!=1){
                    result.setCode(0);
                    result.setSuccess(true);
                    result.setResult(loginResult);
                }
            } catch (Exception e) {
                throw new PsCoreRuntimeException("获取登录凭证失败！");
            }
        }else {
            //未绑定，返回获取账户手机号验证码进行绑定
            result.setCode(-1);
            result.setSuccess(false);
        }
        return result;
    }

    public Map getOpenId(String code){
        //String url ="https://api.weixin.qq.com/sns/jscode2session?appid=wx6b63de5d913d83a4&secret=94a2e5440b731e52b30a7634199d5ba7&js_code="+code+"&grant_type=authorization_code";
        String url = weixUrl+"appid="+weixAppid+"&secret="+weixScret+"&js_code="+code+"&grant_type=authorization_code";
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);

            try {
                response = httpclient.execute(httpGet);
                if(response.getStatusLine().getStatusCode() == 200){
                    resultString = EntityUtils.toString(response.getEntity(),"UTF-8");
                }
            } catch (IOException e) {
                throw new PsCoreRuntimeException("获取微信接口服务失败！");
            }

        } catch (URISyntaxException e) {
            throw new PsCoreRuntimeException("微信接口地址错误！");
        }
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        Map map = new HashMap();
        map.put("session_key",jsonObject.get("session_key"));
        map.put("openid",jsonObject.get("openid"));
        return map;

    }

    /**

     * 微信用户绑定  .
     *
     */
    @Override
    public Result bind(String mobile, String phcode,String code) {
        Result result = new Result();
        String otpCodeTime = map.get(mobile);
        if(StringUtils.isEmpty(otpCodeTime)){
            throw new PsCoreRuntimeException("没有验证码！");
        }
        String[] str = otpCodeTime.split(",");
        String otpCode = str[0];
        long time = Long.valueOf(str[1]);
        long nowTime = System.currentTimeMillis();
        if(Long.valueOf(nowTime-time)>5*60*1000){
            throw new PsCoreRuntimeException("验证码已失效！");
        }
        if(otpCode.equals(phcode)){
            //验证成功 根据手机号查询用户
            Person person = null;
            try {
                person = personManager.GetByIds("",mobile,"");
            } catch (IPSFNetException e) {
                throw new PsCoreRuntimeException("获取用户信息异常！");
            }
            if(person!=null){
                Map map = getOpenId(code);
                String openId = (String) map.get("openid");
                String keyId = (String) map.get("session_key");
                if(StringUtils.isEmpty(openId)){
                    throw new PsCoreRuntimeException("获取openId失败！");
                }
                person.setWeiChat(openId);
                try {
                    personManager.Update(person.getUniqID(),person,0);
                } catch (IPSFNetException e) {
                    throw new PsCoreRuntimeException("绑定失败");
                }
                try {
                    UserInfo info = new UserInfo();
                    info.assignFrom(person);
                    loginResult = sessionManager.Login("","",person.getUniqID(),person.getName(),person.getNickName(),"","",0,info);
                    if(loginResult.getCode()!=1){
                        result.setCode(0);
                        result.setSuccess(true);
                        result.setResult(loginResult);
                    }
                } catch (Exception e) {
                    throw new PsCoreRuntimeException("获取登录凭证失败！");
                }
            }else {
                result.setCode(-1);
//                result.setResult("1213");
            }
        }
        return result;
    }

    //用户获取otp短信接口
    public Result getOtp(String telephone) {
        Result result = new Result();
        //按照规则生成otp验证码
        Random random = new Random();
        int randomint = random.nextInt(99999);//获取0-99999之间的随机数
        randomint +=10000;
        String otpCode = String.valueOf(randomint);
        //将验证码通过榛子云接口发送至手机
        String msg = "欢迎使用智慧工地运维平台，您的验证码为："+otpCode+",有效期5分钟!";
        INotifyMsgService notifyMsgService = HttpClientProxy.createHttpClient(INotifyMsgService.class,"http://oa.p9i.cn/Service/MsgNotifySMSJson.assx",0,"utf-8","Json");
        SmsStates smsStates =  notifyMsgService.SendMsgToMobs("Sys_Login","",telephone,"{code:\"{1111}\"}");
        if(smsStates.getSuccess()){
            //将验证码与手机号关联  看当前手机号的验证码是多少
            map.put(telephone,otpCode+","+System.currentTimeMillis());
            //将验证码通过短信通道发送到用户手机
            System.out.printf("telephone="+telephone+"&otp="+otpCode);
            result.setCode(0);
            result.setSuccess(true);
        }else {
            result.setCode(-1);
            result.setSuccess(false);
        }
        return result;
    }
}
