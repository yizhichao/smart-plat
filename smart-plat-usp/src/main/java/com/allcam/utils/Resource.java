package com.allcam.utils;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.MissingResourceException;

import com.allcam.utils.xml.XmlCfg;



/**
 * <p>
 * Title: Resource
 * </p>
 * <p>
 * Description: 资源文件读取类，该类内部实际使用Cfg类来实现，最大的区别是增加了格式化方法和 修改为只读方法
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * </p>
 * 
 * @author 易志超
 * @version 1.0
 */
public class Resource
{
    
    /** 使用的资源包。实际是用配置类来实现的，资源文件只读。 */
    private XmlCfg resource = null;
    
    /** 是否覆盖文件标识。 */
    private boolean isRewrite = true;
    
    /**
     * 根据URL获取资源对象。该方法可从jar文件或classpath中获得资源。
     * 
     * @param url
     *            资源位置URL，不包含语言后缀和.xml
     * @throws IOException IO异常
     */
    public Resource(String url)
        throws IOException
    {
        init(url);
    }
    
    /**
     * 构造器
     * @param url
     *            资源位置URL，不包含语言后缀和.xml
     * @param isRewrite
     *            是否覆盖文件标识
     * @throws IOException IO异常
     */
    public Resource(String url, boolean isRewrite)
        throws IOException
    {
        this.isRewrite = isRewrite;
        init(url);
    }
    
    /**
     * 相对一个类的位置来读取资源。
     * 
     * @param c
     *            URL取相对该类的位置。
     * @param url
     *            相对URL。
     * @throws IOException IO异常
     */
    public Resource(Class c, String url)
        throws IOException
    {
        
        String className = c.getName();
        
        int i = className.lastIndexOf('.');
        if (i > 0)
        {
            className = className.substring(i + 1);
        }
        URL u = new URL(c.getResource(className + ".class"), url);
        init(u.toString());
    }
    
    /**
     * 初始化
     * 
     * @param url 路径
     * @throws IOException IO异常
     */
    public void init(String url)
        throws IOException
    {
//        String str = url + '_' + Locale.getDefault();
        String str = url;
        int i;
        for (;;)
        {
            try
            {
                resource = new XmlCfg(str + ".xml", false);
                return;
            }
            catch (IOException ex)
            {
                // ex.printStackTrace();
                i = str.lastIndexOf('_');
                if (i < 0)
                {
                    throw new MissingResourceException("Can't find resource url:" + url + ".xml", getClass().getName(),
                        null);
                }
                str = str.substring(0, i);
                continue;
            }
        }
    }
    
    /**
     * Add by z37691 此方法用于当配置文件的配置项为组形式（即：有多个相同name的配置项）时,返回组.
     * 
     * @param pKey
     *            配置项的名称.
     * @return String[]
     */
    public String[] getChildrenNames(String pKey)
    {
        return resource.childrenNames(pKey);
    }
    
    /**
     * Add by w38314 此方法用于当配置文件的配置项为组形式（即：有多个相同name的配置项）时,返回组.
     * 
     * @param pKey
     *            配置项的名称.
     * @return Args
     */
    public final Args getArgs(String pKey)
    {
        return resource.getArgs(pKey);
    }
    
    /**
     * 从资源文件中获取字符串，该方法利用配置模块的功能，和读取配置的方法类似。
     * 
     * @param key
     *            资源中的键名。
     * @return 和该键名对应的资源字符串。若找不到key对应的资源则返回key本身。
     */
    public String get(String key)
    {
        return resource.get(key, key);
    }
    
    /**
     * 从资源文件中获取字符串，该方法利用配置模块的功能，和读取配置的方法类似。
     * 
     * @param key 资源中的键名。
     * @param bl 默认值
     * @return 和该键名对应的资源字符串。若找不到key对应的资源则返回key本身。
     */
    public boolean getBoolean(String key, boolean bl)
    {
        return resource.getBoolean(key, bl);
    }
    
    /**
     * 增加一个带默认值参数的方法
     * 
     * @param key 键
     * @param def 默认值
     * @return String
     */
    public String getString(String key, String def)
    {
        return resource.get(key, def);
    }
    
    /**
     * 查找某节点下的所有子节点的名字。
     * 
     * @param key
     *            被查节点的名字。
     * @return String[] 子节点名字的字符串数组，如果不存在key对应的子节点， 则返回长度为0的空数组。
     */
    public String[] childrenNames(String key)
    {
        return resource.childrenNames(key);
    }
    
    /**
     * 取得资源字符串并且用给定的参数进行格式化。参数个数最多10个：{0}到{9}。 若取资源失败或者格式化失败则返回key。
     * 例如：在资源文件中有如下一行：<br>
     * connectionFail=连接失败，地址{0}，端口号{1}。
     * 则Resource.getString("connectionFail",new String[]{"10.108.12.34","8080"})
     * 返回的字符串为：<br>
     * 连接失败，地址10.108.12.34，端口号8080。<br>
     * 详细格式化规则请参见MessageFormat.format()。
     * 
     * @param key
     *            资源中的键名。
     * @param params
     *            用于格式化资源字符串的参数。
     * @return 和该键名对应的资源字符串。 若找不到key对应的资源或者格式化失败，则返回key本身。
     */
    public String get(String key, Object[] params)
    {
        String value = resource.get(key, key); // 得到资源字符串
        try
        {
            return MessageFormat.format(value, params); // 根据参数格式化
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return key;
        }
    }
    
    /**
     * 取得资源字符串并且用给定的参数进行格式化。参数个数最多10个：{0}到{9}。 若取资源失败或者格式化失败则返回key。
     * 例如：在资源文件中有如下一行：<br>
     * connectionFail=连接失败，地址{0}，端口号{1}。
     * 则Resource.getString("connectionFail",new String[]{"10.108.12.34","8080"})
     * 返回的字符串为：<br>
     * 连接失败，地址10.108.12.34，端口号8080。<br>
     * 详细格式化规则请参见MessageFormat.format()。
     * 
     * @param key
     *            资源中的键名。
     * @param params
     *            用于格式化资源字符串的参数。
     * @return 和该键名对应的资源字符串。 若找不到key对应的资源或者格式化失败，则返回key本身。
     */
    public String get(String key, String[] params)
    {
        for (int i = 0; i < params.length; i++)
        {
            params[i] = parseBody(params[i]);
        }
        String value = resource.get(key, key); // 得到资源字符串
        try
        {
            return MessageFormat.format(value, (Object[])params); // 根据参数格式化
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return key;
        }
    }
    
    /**
     * 取得资源字符串并用一个参数对其进行格式化。
     * 
     * @param key 键
     * @param param  插入字符串中的参数
     * @return 格式化后的字符串。
     */
    public String get(String key, Object param)
    {
        return get(key, new Object[] {param});
    }
    
    /**
     * 增加一个方法如果没有取到资源，返回缺省值
     * 
     * @param key 键
     * @param def 值
     * @return 格式化后的字符串。
     */
    public String getValue(String key, String def)
    {
        return resource.get(key, def);
    }
    
    /**
     * 写资源文件
     * 
     * @param key 键
     * @param value 值
     */
    public void put(String key, String value)
    {
        resource.put(key, value);
        try
        {
            // begin mod by wangqiang kf8639 20071119 问题单:A22D19719
            if (isRewrite)
            {
                resource.flush();
            }
            // end mod by wangqiang kf8639 20071119 问题单:A22D19719
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 字符串中是否含有"''"，如果有则进行转换
     * 
     * @param s
     * @return 转换后的字符串，将"'"转换成"''"
     */
    private static String parseBody(String s)
    {
        String needChange = "'";
        String changeTo = "''";
        if (s == null)
        {
            return "";
        }
        int length = needChange.length();
        int position = 0;
        StringBuffer result = new StringBuffer();
        while (position >= 0)
        {
            int newPosition = s.indexOf(needChange, position);
            if (newPosition < 0)
            {
                result.append(s.substring(position, s.length()));
                break;
            }
            else
            {
                result.append(s.substring(position, newPosition));
                result.append(changeTo);
                position = newPosition + length;
            }
        }
        return result.toString();
    }
}
