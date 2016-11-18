package com.allcam.utils;

import java.util.Locale;

/**
 * StringUtil 工具类
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StringUtil
{

    /** 表示整数2 */
    public static final int INT_2 = 2;

    /** 表示整数3 */
    public static final int INT_3 = 3;

    /** 表示整数4 */
    public static final int INT_4 = 4;

    /** 表示整数5 */
    public static final int INT_5 = 5;

    /** 表示整数6 */
    public static final int INT_6 = 6;

    /** 表示整数9 */
    public static final int INT_9 = 9;

    /** 表示整数8 */
    public static final int INT_8 = 8;

    /** 表示整数16 */
    public static final int INT_16 = 16;

    /** 表示整数24 */
    public static final int INT_24 = 24;

    /** 表示整数10 */
    public static final int INT_10 = 10;

    /** 表示整数32 */
    public static final int INT_32 = 32;

    /** 表示整数34 */
    public static final int INT_34 = 34;

    /** 表示整数38 */
    public static final int INT_38 = 38;

    /** 表示整数39 */
    public static final int INT_39 = 39;

    /** 表示整数44 */
    public static final int INT_44 = 44;

    /** 表示整数48 */
    public static final int INT_46 = 46;

    /** 表示整数58 */
    public static final int INT_58 = 58;

    /** 表示整数48 */
    public static final int INT_59 = 59;

    /** 表示整数60 */
    public static final int INT_60 = 60;

    /** 表示整数62 */
    public static final int INT_62 = 62;

    /** 表示整数48 */
    public static final int INT_63 = 63;

    /** 字符‘0’的整数表示 */
    public static final int INT_48 = 48;

    /** 字符‘A'的整数表示 */
    public static final int INT_65 = 65;

    /** 整数表示255 */
    public static final int INT_255 = 255;

    /** 表示整数256 */
    private static final int INT_256 = 256;

    /**
     * oracle数据库的like语句中 % _ 转义处理
     * 
     * @param keyword
     *            String 查询的关键字
     * @param sql
     *            String
     * @return String 转义后的字符串 单引号用两个单引号替换
     *         如果查询的关键字中包含了'%'或'_'，如关键字为："x_"则转义后形如：'%x/_%' escape '/'
     *         如果查询的关键字中没有包含了'%'或'_'，如关键字为："xx"则转义后形如：'%xx%'
     */
    public static String getDBQueryKey(String keyword, String sql)
    {
        return getDBQueryKeys(new String[]{keyword}, sql)[0].toString();
    }

    /**
     * oracle数据库的like语句中 % _ 转义处理
     * 
     * @param args
     *            Object[]
     * @param sql
     *            String
     * @return Object[]
     */
    public static Object[] getDBQueryKeys(Object[] args, String sql)
    {
        if (args == null || args.length == 0)
        {
            return args;
        }

        Object[] newArgs = new Object[args.length];
        System.arraycopy(args, 0, newArgs, 0, args.length);

        String strs[] = StringUtil.toLowerCase(sql).split("[?]");
        for (int i = 0; i < args.length; i++)
        {
            if (!(strs[i].trim().indexOf("like") > -1))
            {
                continue;
            }

            if (args[i] == null || !(args[i] instanceof String))
            {
                continue;
            }

            if (-1 != args[i].toString().indexOf("%") || -1 != args[i].toString().indexOf("/")
                    || -1 != args[i].toString().indexOf("_"))
            {
                newArgs[i] = args[i].toString().replaceAll("/", "//").replaceAll("%", "/%")
                        .replaceAll("_", "/_");
            }
            else if (-1 != args[i].toString().indexOf("％") || -1 != args[i].toString().indexOf("/")
                    || -1 != args[i].toString().indexOf("＿"))
            {
                newArgs[i] = args[i].toString().replaceAll("/", "//").replaceAll("％", "/%")
                        .replaceAll("＿", "/_");
            }
        }
        return newArgs;
    }

    /**
     * toLowerCase
     * 
     * @param str
     *            String
     * @return String
     */
    public static String toLowerCase(String str)
    {
        if (null == str)
        {
            return str;
        }
        return str.toLowerCase(Locale.getDefault());
    }

    public static String toUpperCase(String str)
    {
        if (null == str)
        {
            return str;
        }
        return str.toUpperCase(Locale.getDefault());
    }

    /**
     * 检查字符串是否为空，字符串为null，或者长度为0都认为为空
     * 
     * @param str
     *            字符串
     * @return boolean
     */
    public static boolean isNull(String str)
    {
        if (null == str)
        {
            return true;
        }

        if (0 == str.trim().length())
        {
            return true;
        }

        return false;
    }

    /**
     * 给字符串去掉空格
     * 
     * @param arg
     *            字符串
     * @return String
     */
    public static String trim(String arg)
    {
        if (null == arg)
        {
            return null;
        }
        else
        {
            return arg.trim();
        }
    }

    /**
     * 写数据库时对' 进行转换
     * 
     * @param text
     *            String
     * @return string
     * @author haozhang3
     */
    public static String toDB(String text)
    {
        if (null == text || "".equals(text.trim()))
        {
            return text;
        }

        int l = text.length();
        StringBuffer strb = new StringBuffer();
        for (int i = 0; i < l; i++)
        {
            char c = text.charAt(i);
            switch (c)
            {
                case '\'':
                    strb.append('\'').append('\'');
                    break;
                default:
                    strb.append(c);
                    break;
            }
        }
        return strb.toString();
    }

    /**
     * ascii码大于255的字符长度按3位计算
     * 
     * @param value
     *            String
     * @return int
     */
    public static int getStrLen(String value)
    {
        int i;
        int len;
        if (value == null)
        {
            return 0;
        }
        len = 0;
        for (i = 0; i < value.length(); i++)
        {
            if (value.charAt(i) > INT_255)
            {
                len += INT_3;
            }
            else
            {
                len++;
            }
        }
        return len;
    }

    public static String getPlayerJs()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<div id='plv__4'></div ><script >");
        buffer.append("var player = polyvObject('#plv__4').videoPlayer({");
        buffer.append("'width': '600',");
        buffer.append("'height': '490',");
        buffer.append("'vid': '_4'");
        buffer.append("});</script>");
        return buffer.toString();
    }

    public static String getHtml(String fashUrl)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<OBJECT classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" width=\"600\" height=\"400\" id=\"player366f443b0fb46e80d0381f8157da8062_3\">");
        buffer.append("<PARAM NAME=\"movie\" VALUE='" + fashUrl + "'/>");
        buffer.append("<param name=\"allowscriptaccess\" value=\"always\"/>");
        buffer.append("<param name=\"wmode\" value=\"Transparent\"/>");
        buffer.append("<param name=\"flashvars\" value=\"vid=366f443b0fb46e80d0381f8157da8062_3\"/>");
        buffer.append("<param name=\"allowFullScreen\" value=\"true\"/>");
        buffer.append("<EMBED src='"
                + fashUrl
                + "' width=\"600\" height=\"400\" TYPE=\"application/x-shockwave-flash\" allowscriptaccess=\"always\"");
        buffer.append("wmode=\"Transparent\" name=\"player366f443b0fb46e80d0381f8157da8062_3\" allowFullScreen=\"true\" flashvars=\"vid=366f443b0fb46e80d0381f8157da8062_3\"/>");
        buffer.append("</OBJECT>");
        return buffer.toString();
    }
}
