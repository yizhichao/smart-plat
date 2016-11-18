package com.allcam.utils.chinesetopinyin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转换为拼音工具类
 * 
 * @author  marui
 * @version  [版本号, Aug 21, 2015]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SpellHelper
{
    /**
     * 将中文转换为拼音
     * @param name 中文
     * 
     * @return String 拼音
     */
    public static String getEname(String name)
    {
        try
        {
            HanyuPinyinOutputFormat pyFormat = new HanyuPinyinOutputFormat();
            pyFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE); //设置样式
            pyFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            pyFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
            
            return PinyinHelper.toHanyuPinyinString(name, pyFormat, "");
        }
        catch (BadHanyuPinyinOutputFormatCombination e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * 姓、名 英文第一个字母大写
     * @param name 汉语名称
     * 
     * @return String 转换后的拼音
     */
    public static String getUpEname(String name)
    {
        char[] strs = name.toCharArray();
        String newname = null;
        
        if (strs.length == 2)
        { //如果姓名只有两个字
            newname = toUpCase(getEname("" + strs[0])) + " "
                    + toUpCase(getEname("" + strs[1]));
        }
        else if (strs.length == 3)
        { //如果姓名有三个字
            newname = toUpCase(getEname("" + strs[0])) + " "
                    + toUpCase(getEname("" + strs[1] + strs[2]));
        }
        else if (strs.length == 4)
        { //如果姓名有四个字
            newname = toUpCase(getEname("" + strs[0] + strs[1])) + " "
                    + toUpCase(getEname("" + strs[2] + strs[3]));
        }
        else
        {
            newname = toUpCase(getEname(name));
        }
        
        return newname;
    }
    
    /**
     * 首字母大写
     * @param str 拼音
     * 
     * @return String 首字母处理后的拼音
     */
    private static String toUpCase(String str)
    {
        StringBuffer newstr = new StringBuffer();
        newstr.append((str.substring(0, 1)).toUpperCase())
                .append(str.substring(1, str.length()));
        
        return newstr.toString();
    }
    
    public static void main(String[] args)
    {
        System.out.println(getUpEname("袁仕勇"));
    }
    
}
