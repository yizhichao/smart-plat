package com.allcam.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanTools
{
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanTools.class);
    
    private BeanTools()
    {
    }

    /**
     * 通用toString方法
     * 
     * @param bean
     *            Object
     * @return String
     */
    public static String beanToString(Object bean)
    {

        Class<?> c = bean.getClass();
        Field[] fields = c.getDeclaredFields();

        StringBuilder buffer = new StringBuilder();
        buffer.append(c.getName().substring(c.getName().lastIndexOf(".") + 1) + '[');
        try
        {
            AccessibleObject.setAccessible(fields, true);

            for (int i = 0; i < fields.length; i++)
            {
                Field f = fields[i];
                buffer.append(f.getName());
                buffer.append('=');
                Object value = f.get(bean);
                if (value instanceof Object[])
                {
                    Object[] obj = (Object[]) value;
                    buffer.append(arrayToString(obj));
                }
                else
                {
                    buffer.append(fieldHandler(f,value));
                }
                if (i + 1 < fields.length)
                {
                    buffer.append(',');
                }
            }
        }
        catch (Exception e)
        {
            // 异常不往外仍，记录debug级别，不影响业务
            LOGGER.debug("WARN:", e);
        }
        buffer.append(']');
        return buffer.toString();
    }

    /**
     * 对象数组toString
     * 
     * @param objs
     *            Object[] 对象数组
     * @return String 对象数组的字符串表达
     */
    public static String arrayToString(Object[] objs)
    {
        if (null != objs)
        {
            StringBuilder objsBuffer = new StringBuilder();
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
     * oracle数据库的like语句中 % _ 转义处理
     * 
     * @param keyword
     *            String 查询的关键字
     * @return String 转义后的字符串 单引号用两个单引号替换
     *         如果查询的关键字中包含了'%'或'_'，如关键字为："x_"则转义后形如：'%x/_%' escape '/'
     *         如果查询的关键字中没有包含了'%'或'_'，如关键字为："xx"则转义后形如：'%xx%'
     */
    public static String getDBQueryKey(String keyword, String sql)
    {
        return getDBQueryKeys(new String[] { keyword }, sql)[0].toString();
    }

    /**
     * oracle数据库的like语句中 % _ 转义处理
     * 
     * @param keyword
     *            String 查询的关键字
     * @return String 转义后的字符串 单引号用两个单引号替换
     *         如果查询的关键字中包含了'%'或'_'，如关键字为："x_"则转义后形如：'%x/_%' escape '/'
     *         如果查询的关键字中没有包含了'%'或'_'，如关键字为："xx"则转义后形如：'%xx%'
     */
    public static Object[] getDBQueryKeys(Object[] args, String sql)
    {
        if (args == null || args.length == 0)
        {
            return args;
        }

        Object[] newArgs = new Object[args.length];
        System.arraycopy(args, 0, newArgs, 0, args.length);

        String []strs = StringUtils.lowerCase(sql).split("[?]");
        for (int i = 0; i < args.length; i++)
        {
            if (!(args[i] instanceof String) || !(strs[i].trim().indexOf("like") > -1))
            {
                continue;
            }
            getDBQueryKey(args, newArgs, i);
        }
        return newArgs;
    }

    private static void getDBQueryKey(Object[] args, Object[] newArgs, int i)
    {
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

    /**
     * 
     * @Title: transBean2Map
     * @Description: 将实体javabean类转Map<String,Object>类
     * 
     * @param obj
     * @return
     * @return: Map<String,Object>
     * @Author: 
     * @date: 2015年4月21日 下午8:02:13
     */
    public static Map<String, Object> transBean2Map(Object obj, boolean filterNullFlag)
    {

        if (obj == null)
        {
            return new HashMap<String, Object>(10);
        }
        Map<String, Object> model = new HashMap<String, Object>(10);
        try
        {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors)
            {
                String key = property.getName();

                // 过滤class属性
                if (!"class".equals(key))
                {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    transBean2Map(filterNullFlag, model, key, value);
                }
            }
        }
        catch (Exception e)
        {
            // 异常不往外仍，记录debug级别，不影响业务
            LOGGER.debug("WARN:", e);
        }
        return model;
    }

    private static void transBean2Map(boolean filterNullFlag, Map<String, Object> model,
            String key, Object value)
    {
        if (filterNullFlag)
        {
            if (isNotBlank(value))
            {
                model.put(key, value);
            }
        }
        else
        {
            model.put(key, value);
        }
    }

    /**
     * 
     * @Title: copyProperty
     * @Description: 对象转换（对象属性拷贝）
     * 
     * @param oldObj
     *            转换后的返回对象
     * @param newObj
     *            需要转换的对象
     * @throws Exception
     * @return: void
     * @Author: 
     * @date: 2015年8月3日 下午6:01:40
     */
    @SuppressWarnings("rawtypes")
    public static void copyProperty(Object oldObj, Object newObj) throws Exception
    {
        // 新的class
        Class newClass = newObj.getClass();
        // 老的class
        Class oldClass = oldObj.getClass();
        // 该类所有的属性
        Field[] newFields = newClass.getDeclaredFields();
        // 新的属性
        Field newField = null;
        // 老的属性
        Field oldField = null;
        for (Field f : newFields)
        {
            // 类中的属性名称
            String fieldName = f.getName();
            if (!"serialVersionUID".equals(fieldName))
            {
                // 通过属性名称获取属性
                newField = newClass.getDeclaredField(fieldName);
                // 获取属性的值时需要设置为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
                // 值为 false 则指示反射的对象应该实施 Java 语言访问检查。
                newField.setAccessible(true);
                // 根据属性获取对象上的值
                Object newObject = newField.get(newObj);
                // 过滤空的属性或者一些默认值
                if (!isContinue(newObject))
                {
                    oldField = oldClass.getDeclaredField(fieldName);
                    oldField.setAccessible(true);
                    oldField.set(oldObj, newObject);
                }

            }
        }
    }

    /**
     * @Title: getAttributeValue
     * @Description: 获取类中属性的值
     * 
     * @param model
     *            实体
     * @param attribute
     *            属性值
     * @return
     * @throws Exception
     * @return: String
     * @Author: 
     * @date: 2015年11月2日 下午3:54:17
     */
    public static String getAttributeValue(Object model, String attribute) throws Exception
    {
        String result = "";
        Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++)
        { // 遍历所有属性
            String name = field[j].getName(); // 获取属性的名字
            if (name.equals(attribute))
            {
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                String type = field[j].getGenericType().toString(); // 获取属性的类型
                Method m = model.getClass().getMethod("get" + name);
                result = getSimpleTypeValue(type, model, m);
            }
        }
        return result;
    }

    public static String printHtml(Object model, String html) throws Exception
    {
        String regex = "\\{.*?\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        String result = html;
        while (matcher.find())
        {
            String attr = matcher.group().replaceAll("\\{|\\}", "");
            String newAttr = BeanTools.getAttributeValue(model, attr);
            result = result.replaceAll("\\{" + attr + "\\}", newAttr);
        }
        return result;
    }

    /**
     * 是否跳出本次循环
     * 
     * @author 2014-11-6 上午11:37:22
     * @param object
     * @return true 是 有null或者默认值 false 否 有默认值
     */
    private static boolean isContinue(Object object)
    {
        if (object == null || "".equals(object))
        {
            return true;
        }
        String valueStr = object.toString();
        if ("0".equals(valueStr) || "0.0".equals(valueStr))
        {
            return true;
        }
        return false;
    }

    /**
     * 
     * @Title: fieldHandler
     * @Description: 安全特殊属性值过滤
     *
     * @param field
     * @param value
     * @return
     * @return: Object
     * @Author: 
     * @date: 2015年12月10日 下午3:51:58
     */
    private static Object fieldHandler(Field field,Object value)
    {
        if ("password".equals(StringUtils.lowerCase(field.getName()))
                || "pwd".equals(StringUtils.lowerCase(field.getName()))
                || "newpswd".equals(StringUtils.lowerCase(field.getName()))
                || "oldpswd".equals(StringUtils.lowerCase(field.getName())))
        {
            return "******";
        }
        else
        {
            return value;
        }
    }

    /**
     * 
     * @Title: isNotBlank
     * @Description: object是否为null或者空字符串
     * 
     * @param obj
     * @return
     * @return: boolean
     * @Author: 
     * @date: 2015年11月5日 下午4:49:51
     */
    private static boolean isNotBlank(Object obj)
    {
        if (null == obj)
        {
            return false;
        }
        if (obj instanceof String)
        {
            return StringUtils.isNotBlank(obj.toString());
        }
        return true;
    }

    /**
     * 
     * @Title: getSimpleTypeValue
     * @Description: 获取简单数据类型的值
     *
     * @param type
     * @param model
     * @param m
     * @return
     * @throws Exception
     * @return: String
     * @Author: 
     * @date: 2015年11月5日 下午5:45:53
     */
    private static String getSimpleTypeValue(String type, Object model, Method m) throws Exception
    {
        String result = "";
        Object obj = m.invoke(model);
        if (null != obj)
        {
            switch (type.hashCode())
            {
            case 673016845:// "class java.lang.String".hashCode()
            case -1066470206:// "class java.lang.Integer".hashCode():
            case 104431:// "int".hashCode():
            case 575539456:// "class java.lang.Short".hashCode():
            case 239044557:// "class java.lang.Double".hashCode():
            case 1335156652:// "class java.lang.Boolean".hashCode():
            case -1228813654:// "class java.util.Date".hashCode():
                result = obj.toString();
                break;
            default:
                break;
            }
        }
        return result;
    }

}
