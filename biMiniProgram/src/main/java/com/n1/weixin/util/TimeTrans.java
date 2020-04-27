package com.n1.weixin.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by admin on 2020/4/20.
 * 时间转换，将时间转换为美国芝加哥时区
 */

public class TimeTrans {
    /**
     *
     * @return 获取当日时间最小单位为天 格式为yyyy-MM-dd
     */
    public static String getEndTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @return 获取30天前时间最小单位为天 格式为yyyy-MM-dd
     */
    public static String getStartTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        return simpleDateFormat.format(now.getTime());
    }

    /**
     *
     * @return 获取当月时间 格式为yyyy-MM
     */

    public static String getEndMonth(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @return 获取12月前时间 格式为yyyy-MM
     */
    public static String getStartMonth(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -12);
        return simpleDateFormat.format(now.getTime());
    }

    /**
     *
     * @return 获取当前小时，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String getEndDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @return 获取当前小时，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String getBjTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        return simpleDateFormat.format(date);
    }



    /**
     *
     * @return 获取23小时之前，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String getStartDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR_OF_DAY, -23);
        return simpleDateFormat.format(now.getTime());
    }

    /**
     *
     * @param date 需要增加的初始时间
     * @return 获取增加的时间 格式为yyyy-MM-dd HH:mm:ss
     */
    public static String addDate(String date){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate =null;
        try{
            Date d = new Date(f.parse(date).getTime()+24*3600*1000);
            newDate = f.format(d);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  newDate;
    }

    /**
     * 获取两个日期相差天数
     * @param date1 开始天数
     * @param date2 结束天数
     * @return 两天间隔天数
     */
    public static long getDateDev(String date1, String date2) {

        long dev =0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            dev = (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  dev;
    }

    /**
     * 日期加上天数
     * @param dev 需要加上的天数
     * @param date1 初始日期
     * @return 加上天数后的日期
     */
    public static String addDate(int dev,String date1){
        String date =null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(date1);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d1);
            calendar.add(Calendar.DAY_OF_MONTH, dev);
            date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  date;
    }

}

