package com.allcam.utils;

import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysCodeBuilderUtil
{
    public static final Log LOG = LogFactory.getLog(SysCodeBuilderUtil.class);
    
    /**
     * 产生随机字符串
     */
    private static Random randGen = null;
    
    private static char[] numbersAndLetters = null;
    
    public static int randomInt()
    {
        java.util.Random r = new java.util.Random(10);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(r.nextInt());
        }
        return 0;
    }
    
    // 调用此方法randomString(int),int是字符串的长度，即可产生指定长度的随机字符串。
    private static final String randomStringa(int length)
    {
        if (length < 1)
        {
            return null;
        }
        if (randGen == null)
        {
            randGen = new Random();
            numbersAndLetters =
                ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789abcdefghijklmnopqrstuvwxyz").toCharArray();
            // numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++)
        {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
            // randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];
        }
        return new String(randBuffer);
    }
    
    public static String getOrderId()
    {
        String key = DateUtil.formatTime(new Date(), DateUtil.DATE_17);
        key = key + SysCodeBuilderUtil.randomStringa(15);
        return key;
    }
    
    private static String findAreaCode(String sysId)
    {
        // 作为分发、存储服务时前8位保证唯一标示业务节点，同一业务节点内服务一致
        String result = sysId.substring(0, 6);
        if (!isNum(result))
        {
            result = "320100"; // 默认江苏南京市
        }
        return result;
    }
    
    /**
     * 区域验证
     * 
     * @return 验证通过返回true
     */
    public static boolean isNum(String str)
    {
        if (StringUtil.isNull(str))
        {
            return false;
        }
        Pattern p = Pattern.compile("^[0-9]$"); // 验证数字
        Matcher m = p.matcher(str);
        return m.matches();
    }
    
    // 组织+用户相关
    // Root / 全零000 全球 国家 省市区 001
    // ..
    // 学校 010
    // 年级 011
    // 班级 012
    // 用户（家长，老师）020
    // 学生 021
    // …
    // 历史ID 默认 还是字母
    //
    // 资源相关
    // 100 开始 目前默认 101 102 103 999
    // 历史ID 默认 还是字母
    
    // 资源编码：320100201511271135003000yhjhkg
    // 用户编码：320100201511271135003001vgjmpd
    /**
     * 生成系统ID的方法
     * 
     * @param sysId 上层的Id 学校ID-->班级ID-->年级ID-->用户ID-->学生ID
     * @param codeType 编码类别 3位
     * @return 系统ID
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String codeBuilder(String sysId, String codeType)
        throws Exception
    {
        if (StringUtil.isNull(sysId))
        {
            // LOG.error("sysId is null.");
            throw new Exception("sysId is null.");
        }
        if (sysId.length() != 32)
        {
            // LOG.error("sysId is not 32 length.");
            throw new Exception("sysId is not 32 length.");
        }
        StringBuffer result = new StringBuffer(0);
        // 作为分发、存储服务时前8位保证唯一标示业务节点，同一业务节点内服务一致
        result.append(StringUtil.toLowerCase(findAreaCode(sysId)));
        String key = DateUtil.formatTime(new Date(), DateUtil.DATE_17);
        result.append(key);
        result.append(codeType);
        result.append(randomStringa(6));
        return result.toString();
    }
    
    /**
     * 生成设备ID的方法
     * 
     * @param sysId 区域编码6位
     * @param codeType 类别编码 2位
     * @param code 具体编码 20位
     * @param vcuId 厂商编码32位
     * @return 设备ID
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String devCodeBuilder(String sysId, String codeType,String code,String vcuId)
        throws Exception
    {
        if (StringUtil.isNull(sysId))
        {
            // LOG.error("sysId is null.");
            throw new Exception("sysId is null.");
        }
        if (sysId.length() != 32)
        {
            // LOG.error("sysId is not 32 length.");
            throw new Exception("sysId is not 10 length.");
        }
        StringBuffer result = new StringBuffer(0);
        // 作为分发、存储服务时前8位保证唯一标示业务节点，同一业务节点内服务一致
        result.append(StringUtil.toLowerCase(findAreaCode(sysId))+"0000");
        result.append(codeType);
        result.append(code);
        result.append(vcuId);
        return result.toString();
    }
}
