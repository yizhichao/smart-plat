package com.allcam.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtil
{
    public static final String DATE_5 = "HH:mm";
    
    public static final String DATE_6 = "yyyyMM";
    
    public static final String DATE_7 = "yyyy-MM";
    
    public static final String DATE_8 = "yyyyMMdd";
    
    public static final String DATE_10 = "yyyy-MM-dd";
    
    public static final String DATE_14 = "yyyyMMddHHmmss";
    
    public static final String DATE_17 = "yyyyMMddHHmmssSSS";
    
    public static final String DATE_19 = "yyyy-MM-dd HH:mm:ss";
    
    public static String formatTime(Date date, String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
    
    /**
     * 将字符串转换成日期长整形 参数：time，String，日期字符串 pattern, String, 解析的格式 返回：long，日期长整形
     * 
     * @param time 时间
     * @param pattern 政则表达式
     * @return long
     */
    public static long timeStr2Long(String time, String pattern)
    {
        return timeStr2Date(time, pattern).getTime();
    }
    
    /**
     * 将字符串转换成日期形 参数：time，String，日期字符串 pattern, String, 解析的格式 返回：Date，日期形
     * 
     * @param time 时间
     * @param pattern 政则表达式
     * @return Date
     */
    public static Date timeStr2Date(String time, String pattern)
    {
        if (time == null)
        {
            throw new IllegalArgumentException("time parameter can not be null");
        }
        if (pattern == null)
        {
            throw new IllegalArgumentException("pattern parameter can not be null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try
        {
            return sdf.parse(time);
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("using [" + pattern + "] parse [" + time + "] failed");
        }
    }
    
    public static String getCurrentDate(String pattern)
    {
        if (pattern == null)
        {
            throw new IllegalArgumentException("input string parameter is null");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date now = new Date();
        return sdf.format(now);
    }
    
    public static String str2strDate(String dateStr, String basePatten, String convertPatten)
    {
        if (StringUtils.isBlank(dateStr))
        {
            return "";
        }
        else
        {
            return formatTime(timeStr2Date(dateStr, basePatten), convertPatten);
        }
    }
    
    /**
     * @Description: long类型转换成日期
     * 
     * @param lo 毫秒数
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String longToDate(long lo)
    {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
    
    /**
     * @Description: long类型生成没有符号的日期格式
     * 
     * @param lo 日期毫秒数
     * @return String yyyyMMddHHmmss
     */
    public static String getLongToDate(long lo)
    {
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
        return sd.format(date);
    }
    
    /**
     * 根据日期字符串判断周几
     * 
     * @param dateTime
     * @param format
     * @return
     * @throws Exception
     */
    public static int getWeekday(String dateTime, String format)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK)-1;
        return weekday;
    }
    
    public static void main(String[] args)
    {
        System.out.println(longToDate(1438675947359l));
        System.out.println(getLongToDate(1438675947359l));
    }
}
