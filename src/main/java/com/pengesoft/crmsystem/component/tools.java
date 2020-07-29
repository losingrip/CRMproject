package com.pengesoft.crmsystem.component;

import org.springframework.beans.factory.annotation.Autowired;
import pengesoft.account.ISessionManager;
import pengesoft.account.LoginUser;
import pengesoft.common.IPSFNetException;
import pengesoft.utils.SpringUtil;
import pengesoft.utils.SysUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class tools {

    //一个时间与另一个时间间隔的天数
    public static int getDayTime(Date startTime,Date endTime){
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd");
        Date date1=endTime;
        Date date = startTime;
        Long l = 0L;
        long ts = date.getTime();
        long ts1 = date1.getTime();
        l = (ts - ts1) / (1000 * 60 * 60 * 24);
        return l.intValue();
    }

    //时间与现在时间是否在同一月
    public static boolean samemonth(Date date){
        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM");
        Date Nowdate = new Date();
        String now = formatter.format(Nowdate);
        String thismouth = formatter.format(date);
        if (now.equals(thismouth)){
            return true;
        }
        return false;
    }

    //时间与现在时间是否在同一年
    public  static boolean sameyear(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy");
        Date Nowdate = new Date();
        String now = formatter.format(Nowdate);
        String thisyear = formatter.format(date);
        if (now.equals(thisyear)){
            return true;
        }
        return false;
    }

    //一个时间减去上一年
    public  static  Date addyear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        Date date1 = calendar.getTime();
        return date1;
    }

    //token里取userid
    public static String getUserId(String token) throws IPSFNetException {
        ISessionManager sessionManager = SpringUtil.getBean(ISessionManager.class);
        LoginUser user = sessionManager.GetUserInfo(token);
        if (user==null){
            System.out.println("-------------");
            throw new IPSFNetException("用户未登录"+token,-3);
        }else {
            return user.getUserId();
        }
    }



    //把String变为int数组
    public static int[] StringToint(String Str){
        String[] list = Str.split(",");
        int[] array = Arrays.stream(list).mapToInt(Integer::parseInt).toArray();
        return array;
    }
    //密码生成器
    public static void main(String[] args) {
        System.out.println( SysUtils.GetPasswordHash("lyh123456"));
    }




//    public static void main(String[] args) throws ParseException {
//        String da ="2020-3-2";
//        SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd");
//        Date date2 = formatter.parse(da);
//        Date date = new Date();
//        System.out.println( getDayTime(date,date2));
//    }
}
