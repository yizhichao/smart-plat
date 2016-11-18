package com.allcam.utils.excel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateAS
{
    static Logger logger = Logger.getLogger(DateAS.class.getName());
    
    public static String getCurrentTime()
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dataFormat.format(new Date());
    }
    
    public static String getDateString(Date date)
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dataFormat.format(date);
    }
    
    public static Date getDayFromString(String dateStr)
    {
        Date date = null;
        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd");
            date = simpleDateFormat.parse(dateStr);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage() + "\r\n");
            ex.printStackTrace();
        }
        return date;
    }
    
    public static Date getDateFromString(String dateStr)
    {
        Date date = null;
        try
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            date = simpleDateFormat.parse(dateStr);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage() + "\r\n");
            ex.printStackTrace();
        }
        return date;
    }
    
    public static String getYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return String.valueOf(cal.get(Calendar.YEAR));
    }
    
    public static String getMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        if (month < 10)
        {
            return "0" + month;
        }
        return String.valueOf(month);
    }
    
    public static String getDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }
    
    public static int getDays(int year, int month)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        return cal.getActualMaximum(Calendar.DATE);
    }
    
    public static int getWeekOfDay(int year, int month, int day)
    {
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day - 1);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    public static boolean isSameDay(Date date1, Date date2)
    {
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String date1Str = sdf.format(date1);
        String date2Str = sdf.format(date2);
        return date1Str.equals(date2Str);
    }
    
    public static boolean isSameDay(String date1, String date2)
    {
        String date1Str = date1.substring(0, 10);
        String date2Str = date2.substring(0, 10);
        return date1Str.equalsIgnoreCase(date2Str);
    }
    
    public static double getTime(Date begin, Date end)
    {
        long between = (end.getTime() - begin.getTime()) / 1000L;
        double betweenHour = between / 3600.0D;
        return betweenHour;
    }
}