package com.pengesoft.crmsystem.service;

import com.pengesoft.crmsystem.component.Result;
import pengesoft.data.*;
import pengesoft.service.IApplication;
import pengesoft.service.PublishMethod;
import pengesoft.service.PublishName;
//import com.pengesoft.response.Result;
import java.math.*;
import java.util.*;

@PublishName("WechatAuthorizeSvr")
public interface IWechatAuthorizeSvr extends IApplication{
    @PublishMethod
    Result login(String code);

    /**

     * 微信用户绑定  .
     *
     */
    @PublishMethod
    Result bind(String mobile, String phcode,String code);

    /**

     * 发送opt短信
     * @param telephone
     * @return
     */
    @PublishMethod
    Result getOtp(String telephone);
}
