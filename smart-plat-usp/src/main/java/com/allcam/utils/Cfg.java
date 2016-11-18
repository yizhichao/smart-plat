/**
 * <p>
 * FileName: Cfg.java
 * </p>
 * <p>
 * Author:yizhichao Version :1.0 Date:2014
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Version: 1.0
 * </p>
 * <p>
 * Function List:
 * </p>
 */
package com.allcam.utils;

import java.util.Map;



/**
 * <p>
 * Title: Cfg
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * 
 * @version 1.0
 */
public interface Cfg
{
    /**
     * 取名字为key的节点的值。如果该节点存在，但无内容则返回空字符串：""
     *
     * @param key
     *            和该关键字关联的配置项的值将被返回。
     * @param def
     *            若key对应的配置项不存在，则返回该值。
     * @return 返回节点值
     */
    public abstract String get(String key, String def);
    
    /**
     * 取得某节点的一组子节点值。
     *
     * @param key
     *            父节点的路径。
     *@return 某节点的一组子节点值。
     */
    public abstract Args getArgs(String key);
    
    /**
     * 取得某节点的一组子节点值的Map。
     *
     * @param key
     *            父节点的路径。
     *@return 某节点的一组子节点值的Map。
     */
    public abstract Map getArgsMap(String key);
    
    /**
     * 设名字为key的节点的值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *            所设的值。
     *                传入的key或value为null。
     */
    public abstract void put(String key, String value);
    
    /**
     * 取名字为key的节点的整型值。
     *
     * @param key
     *            取值节点对象的名字。
     * @param def
     *            若没有取到，则返回该值。
     * @return 取名字为key的节点的整型值。
     */
    public abstract int getInt(String key, int def);
    
    /**
     * 设名字为key的节点的整型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *            所设的值。
     */
    public abstract void putInt(String key, int value);
    
    /**
     * 判断某个节点是否存在。
     *
     * @param key
     *            被查节点的全名。
     * @return true 节点存在。 false 节点不存在。
     */
    public abstract boolean nodeExist(String key);
    
    /**
     * 把配置写进配置文件。
     * @throws Exception 异常
     */
    public abstract void flush()
        throws Exception;
    
    /**
     * 取名字为key的节点的浮点类型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param def
     *           若没有取到，则返回该值。
     * @return 名字为key的节点的浮点类型值。
     */
    public float getFloat(String key, float def);
    
    /**
     * 取名字为key的节点的双精度类型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param def
     *           若没有取到，则返回该值。
     * @return 名字为key的节点的双精度类型值。
     */
    public double getDouble(String key, double def);
    
    /**
     * 取名字为key的节点的长整型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param def
     *           若没有取到，则返回该值。
     * @return 名字为key的节点的长整型值。
     */
    public long getLong(String key, long def);
    
    /**
     * 取名字为key的节点的字节数组。
     *
     * @param key
     *            设值节点对象的名字。
     * @param def
     *           若没有取到，则返回该值。
     * @return 名字为key的节点的字节数组。
     */
    public byte[] getByteArray(String key, byte[] def);
    
    /**
     * 设名字为key的节点的浮点类型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *           所设的值。
     */
    public void putFloat(String key, float value);
    
    /**
     * 设名字为key的节点的双精度类型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *           所设的值。
     */
    public void putDouble(String key, double value);
    
    /**
     * 设名字为key的节点的长整型值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *           所设的值。
     */
    public void putLong(String key, long value);
    
    /**
     * 设名字为key的节点的字节数组。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *           所设的值。
     */
    public void putByteArray(String key, byte[] value);
    
    /**
     * 取名字为key的节点的布尔值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param def
     *           若没有取到，则返回该值。
     * @return 名字为key的节点的布尔值。
     */
    public boolean getBoolean(String key, boolean def);
    
    /**
     * 设名字为key的节点的布尔值。
     *
     * @param key
     *            设值节点对象的名字。
     * @param value
     *           所设的值。
     */
    public void putBoolean(String key, boolean value);
    
}