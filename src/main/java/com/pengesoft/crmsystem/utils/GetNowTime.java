package com.pengesoft.crmsystem.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author st
 * @date 2020-03-15 19:45
 */
public class GetNowTime {

    /**
     * 获取自定义格式当前时间
     * @return
     */
    public static Date getNowTime(){
        //获取当前时间作为修改时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatTime = dateFormat.format(new Date());
        Date date = null;
        try {
            date = dateFormat.parse(formatTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取现在时间加amount月
     * @return
     */
    public static Date getWatiVisitTime(int amount)  {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatTime = dateFormat.format(new Date());

        Date date = null;
        try {
            date = dateFormat.parse(formatTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, amount);
        Date addDate = rightNow.getTime();
        return addDate;
    }

    /**
     * 将字符串时间转换成自定义格式类型
     * @param time
     * @return
     */
    public static Date parseTime(String time){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date newTime = null;
        try {
            newTime = formater.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newTime;
    }

}
