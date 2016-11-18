package com.allcam.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.allcam.common.ServiceContants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 华
 * @version [版本号, 2015-01-18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JsonParseUtil
{
    public static final Log LOG = LogFactory.getLog(JsonParseUtil.class);
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    static
    {
        // 允许整数前导为0,eg:"01"形式
        mapper.configure(Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        mapper.configure(Feature.ALLOW_COMMENTS, true);
        mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }
    
    /**
     * 
     * @param object
     * @return
     */
    public static String obj2Json(Object object)
    {
        try
        {
            return mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e)
        {
            LOG.error("Object Convert Json String Error...", e);
        }
        return "";
    }
    
    /**
     * 可将json字符串转成任何复杂对象即对象里可含各种复杂类型:List、Map、Set、Object、Object[]
     * 
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T json2Obj(String json, Class<T> clazz)
    {
        try
        {
            return mapper.readValue(json, clazz);
        }
        catch (JsonParseException e)
        {
            LOG.error("Json Convert Object Error...", e);
        }
        catch (JsonMappingException e)
        {
            LOG.error("Json Convert Object Error...", e);
        }
        catch (IOException e)
        {
            LOG.error("Json Convert Object Error...", e);
        }
        return null;
    }
    
    /**
     * 把map转换成实体对象
     * 
     * @param map
     * @param clazz
     * @return
     */
    public static <T> T map2Obj(Map<String, Object> map, Class<T> clazz)
    {
        return mapper.convertValue(map, clazz);
    }
    
    /**
     * 将json字符串转成复制类型即对象里面含有对象或者List<T>情形
     * 
     * @return 复制类型
     */
    public static <T> T json2ComplexObj(String json, Class<T> clazz)
    {
        T t = null;
        try
        {
            /**
             * 转换成复杂类型用TypeReference
             */
            t = mapper.readValue(json, new TypeReference<T>()
            {
            });
        }
        catch (JsonParseException e)
        {
            LOG.error("Json Convert Complex Object Error...", e);
        }
        catch (JsonMappingException e)
        {
            LOG.error("Json Convert Complex Object Error...", e);
        }
        catch (IOException e)
        {
            LOG.error("Json Convert Complex Object Error...", e);
        }
        return t;
    }
    
    /**
     * 此方法适合复杂类型的json字符串 ,eg:{"id":0,"userId":null} 若形如["11","22"]的简单数组可直接转成List
     * 
     * @param jsonArr json数组
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> jsonArr2List(String jsonArr, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>();
        try
        {
            List<Map<String, Object>> map = mapper.readValue(jsonArr, List.class);
            for (Map<String, Object> entry : map)
            {
                T t = map2Obj(entry, clazz);
                list.add(t);
            }
        }
        catch (JsonParseException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        catch (JsonMappingException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        catch (IOException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        return list;
    }
    
    /**
     * 适合简单json数组转List eg:List<String>,List<Integer>
     * 
     * @param jsonArr ["111","222"],[1, 2]
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> simpleJson2List(String jsonArr, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>();
        try
        {
            list = mapper.readValue(jsonArr, List.class);
        }
        catch (JsonParseException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        catch (JsonMappingException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        catch (IOException e)
        {
            LOG.error("Json Convert List Collection Error...", e);
        }
        return list;
    }
    
    /**
     * 将json字符串转换成Map
     * 
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> json2Map(String json)
    {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try
        {
            map = mapper.readValue(json, Map.class);
        }
        catch (JsonParseException e)
        {
            LOG.error("Json Convert Map Error...", e);
        }
        catch (JsonMappingException e)
        {
            LOG.error("Json Convert Map Error...", e);
        }
        catch (IOException e)
        {
            LOG.error("Json Convert Map Error...", e);
        }
        return map;
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object parseJsonToBean(Map map, String classType)
        throws Exception
    {
        Object objClass = null;
        try
        {
            
            ObjectMapper mapper = new ObjectMapper();
            Class<?> clazz = Class.forName(classType);
            objClass = clazz.newInstance();
            Class<?> fatherClazz = clazz.getSuperclass();
            Field field[] = clazz.getDeclaredFields();
            Field fatherField[] = fatherClazz.getDeclaredFields();
            field = (Field[])ArrayUtils.addAll(field, fatherField);
            Map<String, String> headMap = new LinkedHashMap<String, String>();
            headMap =
                mapper.readValue(mapper.writeValueAsString(map.get(ServiceContants.JSON_MSG_HEAD_KEY)),
                    LinkedHashMap.class);
            Map<String, String> bodyMap = new LinkedHashMap<String, String>();
            bodyMap =
                mapper.readValue(mapper.writeValueAsString(map.get(ServiceContants.JSON_MSG_BODY_KEY)),
                    LinkedHashMap.class);
            int length = field.length;
            for (int i = 0; i < length; i++)
            {
                Field f = field[i];
                String fieldName = f.getName();
                if (headMap.containsKey(fieldName))
                {
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method setMethod = clazz.getMethod(setMethodName, new Class[] {f.getType()});
                    setMethod.invoke(objClass,
                        new Object[] {null == headMap.get(fieldName) ? null : String.valueOf(headMap.get(fieldName))});
                }
                else if (bodyMap.containsKey(fieldName))
                {
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method setMethod = clazz.getMethod(setMethodName, new Class[] {f.getType()});
                    setMethod.invoke(objClass,
                        new Object[] {null == bodyMap.get(fieldName) ? null : String.valueOf(bodyMap.get(fieldName))});
                }
            }
        }
        catch (Exception e)
        {
            throw new Exception("parseJsonToBean() Error!");
        }
        return objClass;
    }
    
}
