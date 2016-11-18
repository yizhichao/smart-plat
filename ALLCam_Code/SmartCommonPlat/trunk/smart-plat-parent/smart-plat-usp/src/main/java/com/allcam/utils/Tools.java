package com.allcam.utils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * 工具类
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Tools
{
    /**
     * 对象数组toString
     * 
     * @param objs Object[] 对象数组
     * @return String 对象数组的字符串表达
     */
    public static String arrayToString(Object[] objs)
    {
        if (null != objs)
        {
            StringBuffer objsBuffer = new StringBuffer();
            objsBuffer.append("{");
            for (int i = 0; i < objs.length; i++)
            {
                objsBuffer.append((null == objs[i]) ? "null" : objs[i]);
                if (i < objs.length - 1)
                {
                    objsBuffer.append(",");
                }
            }
            objsBuffer.append("}");
            return objsBuffer.toString();
        }
        return "{null}";
    }
    
    /**
     * 通用toString方法
     * 
     * @param bean Object
     * @return String
     */
    public static String beanToString(Object bean)
    {
        StringBuffer buffer = new StringBuffer();
        if (null == bean)
        {
            return buffer.toString();
        }
        
        Class c = bean.getClass();
        Field[] fields = c.getDeclaredFields();
        
        buffer.append(c.getName().substring(c.getName().lastIndexOf(".") + 1) + '[');
        try
        {
            AccessibleObject.setAccessible(fields, true);
            
            for (int i = 0; i < fields.length; i++)
            {
                Field f = fields[i];
                buffer.append(f.getName());
                buffer.append('=');
                Object field = f.get(bean);
                if (field instanceof Object[])
                {
                    Object[] obj = (Object[])field;
                    buffer.append(Tools.arrayToString(obj));
                }
                else
                {
                    if ("password".equals(StringUtil.toLowerCase(f.getName()))
                        || "pwd".equals(StringUtil.toLowerCase(f.getName()))
                        || "newpswd".equals(StringUtil.toLowerCase(f.getName()))
                        || "oldpswd".equals(StringUtil.toLowerCase(f.getName()))
                        || "loginPwd".equals(StringUtil.toLowerCase(f.getName())))
                    {
                        buffer.append("******");
                    }
                    else
                    {
                        buffer.append(field);
                    }
                }
                if (i + 1 < fields.length)
                {
                    buffer.append(',');
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        buffer.append(']');
        return buffer.toString();
    }
}
