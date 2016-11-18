package com.allcam.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.raising.framework.utils.MD5;

/**
 * 系统工具类
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public abstract class SystemUtil
{
    /**
     * 接收http请求
     * @param request
     * @return 返回请求的数据
     * 
     * @return String [返回类型说明]
     */
    public static String receivePost(HttpServletRequest request)
            throws IOException, UnsupportedEncodingException
    {
        // 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(
                request.getInputStream(), "UTF-8"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null)
        {
            sb.append(line);
        }
        
        // 将资料解码
        String reqBody = sb.toString();
        return URLDecoder.decode(reqBody, "UTF-8");
    }
    
    /**
     * 获取系统的WebPortalKey(已经过MD5加密处理)
     * 
     * @return String 系统的WebPortalKey
     */
    public static String getWebPortalKey()
    {
        MD5 md5 = new MD5();
        
        String webPortalKey = md5.getmd5ofStr("ALLCAM"
                + ConfigHelper.getValueByKey("webPortalKey"));
        return webPortalKey;
        
    }
    
    /**
    * 获取系统的BDGWKey(已经过MD5加密处理)
    * 
    * @return String 系统的BDGWKey
    */
    public static String getBDGWKey()
    {
        MD5 md5 = new MD5();
        
        String bdgwKey = md5.getmd5ofStr("ALLCAM"
                + ConfigHelper.getValueByKey("bdgwKey"));
        return bdgwKey;
        
    }
    
    /**
     * 获取当前的系统语言种类
     * 
     * @return String Zh：中文  En：英文
     */
    public static String getUserLan()
    {
        return "Zh";
    }
    
    /**
     * 获取服务器地址
     *
     * @return 返回服务器地址
     */
    public static String getServiceAddress(HttpServletRequest request)
    {
        // 将完整的路径拼接给出去
        String serverContextPath = request.getContextPath();
        
        String serverRequestURL = request.getRequestURL().toString();
        
        String serverRequestURI = request.getRequestURI();
        
        String path = serverRequestURL.substring(0,
                serverRequestURL.indexOf(serverRequestURI));
        
        path += serverContextPath;
        
        return path;
    }
    
    /**
     * 统计功能的开始时间
     * @param beginTime 查询条件开始时间，如果没有则取当前时间往前推一年的时间
     * 
     * @return String 开始时间
     */
    public static String getBeginTime(String beginTime)
    {
        Calendar thisDay = Calendar.getInstance();
        
        if (StringUtils.isNotBlank(beginTime))
        {
            beginTime = DateUtil.str2strDate(beginTime,
                    DateUtil.DATE_19,
                    DateUtil.DATE_14);
        }
        else
        {
            thisDay.set(Calendar.YEAR, thisDay.get(Calendar.YEAR) - 1);
            // thisDay.set(Calendar.MONTH, thisDay.get(Calendar.MONTH));// 月份,从0开始
            thisDay.set(Calendar.DAY_OF_MONTH, 1);
            thisDay.set(Calendar.HOUR, 0);
            thisDay.set(Calendar.MINUTE, 0);
            thisDay.set(Calendar.SECOND, 0);
            beginTime = DateUtil.formatTime(thisDay.getTime(), DateUtil.DATE_14);
        }
        
        return beginTime;
    }
    
    /**
     * 统计功能的结束时间
     * @param endTime 查询条件结束时间，如果没有则取当前时间
     * 
     * @return String 结束时间
     */
    public static String getEndTime(String endTime)
    {
        Calendar thisDay = Calendar.getInstance();
        
        if (StringUtils.isNotBlank(endTime))
        {
            endTime = DateUtil.str2strDate(endTime,
                    DateUtil.DATE_19,
                    DateUtil.DATE_14);
        }
        else
        {
            thisDay.set(Calendar.YEAR, thisDay.get(Calendar.YEAR));
            thisDay.set(Calendar.MONTH, thisDay.get(Calendar.MONTH));// 月份,从0开始
            thisDay.set(Calendar.DAY_OF_MONTH,
                    thisDay.getActualMaximum(Calendar.DAY_OF_MONTH));
            thisDay.set(Calendar.HOUR, 0);
            thisDay.set(Calendar.MINUTE, 0);
            thisDay.set(Calendar.SECOND, 0);
            
            endTime = DateUtil.formatTime(thisDay.getTime(), DateUtil.DATE_14);
        }
        return endTime;
    }
    
    /**
     * 判断日期是否正确
     * @param date
     * 
     * @return boolean true表示正确,反之不正确
     */
    public static boolean isDate(String date)
    {
        /**
         * 判断日期格式和范围
         */
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[-]?((((0?[13578])|(1[02]))[-]+((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[-]+((0?[1-9])|([1-2][0-9])|(30)))|(0?2[-]+((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[-]+((((0?[13578])|(1[02]))[-]+((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[-]+((0?[1-9])|([1-2][0-9])|(30)))|(0?2[-]+((0?[1-9])|(1[0-9])|(2[0-8]))))))";
         
        Pattern pat = Pattern.compile(rexp);  
         
        Matcher mat = pat.matcher(date);  
         
        boolean dateType = mat.matches();

        return dateType;
    }
    
    /**
     * @Title : main
     * @Type : DateType
     * @date : 2014年3月8日 下午10:54:50
     * @Description : 
     * @param args
     */
    public static void main(String[] args) 
    {
        /**
         * 日期格式正确
         */
        String date1 = "2014-01-03";
        /**
         * 日期范围不正确---平年二月没有29号
         */
        String date2 = "2014-02-29";
        /**
         * 日期月份范围不正确---月份没有13月
         */
        String date3 = "2014-13-03";
        /**
         * 日期范围不正确---六月没有31号
         */
        String date4 = "2014-06-31";
        /**
         * 日期范围不正确 ----1月超过31天
         */
        String date5 = "2014-01-32";
        /**
         * 这个测试年份
         */
        String date6 = "2014-01-3";
         
         
        /**
         * 打印正确日期格式
         */
        System.out.println(isDate(date1));
        /**
         * 打印date1
         */
        System.out.println(isDate(date2));
        /**
         * 打印date3
         */
        System.out.println(isDate(date3));
        /**
         * 打印date4
         */
        System.out.println(isDate(date4));
        /**
         * 打印date5
         */
        System.out.println(isDate(date5));
        /**
         * 打印date6
         */
        System.out.println(isDate(date6));
    }
}
