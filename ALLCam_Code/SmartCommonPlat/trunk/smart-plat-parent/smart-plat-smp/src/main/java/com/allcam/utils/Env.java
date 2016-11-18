package com.allcam.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * Env 实例化
 * 
 * @author yiZhichao
 * 
 */

public final class Env extends Properties
{
    
    /**
     * 序列号
     */
    private static final long serialVersionUID = -1302155653305379326L;
    
    private static Env instance;
    
    private static String dbConfigPath = null;
    
    private static String webPath = null;
    
    private static AboutInfo aboutInfo;
    
    /** 系统管理参数配置文件 */
    private static Resource webCommon;
    
    public static Env getInstance(String path)
    {
        if (instance != null)
        {
            return instance;
        }
        else
        {
            makeInstance(path);
            return instance;
        }
    }
    
    private static synchronized void makeInstance(String path)
    {
        if (instance == null)
        {
            instance = new Env(path);
        }
    }
    
    private Env(String path)
    {
        
        try
        {
            InputStream iStream = new FileInputStream(path);
            load(iStream);
        }
        catch (Exception e)
        {
            System.out.println("fail.");
        }
    }
    
    public static String getDbConfigPath()
    {
        return dbConfigPath;
    }
    
    public static void setDbConfigPath(String dbConfigPath)
    {
        Env.dbConfigPath = dbConfigPath;
    }
    
    public static String getWebPath()
    {
        return webPath;
    }
    
    public static void setWebPath(String webPath)
    {
        Env.webPath = webPath;
    }
    
    public static Resource getWebCommon()
    {
        return webCommon;
    }
    
    public static void setWebCommon(Resource resource)
    {
        Env.webCommon = resource;
    }
    
    public static AboutInfo getAboutInfo()
    {
        return aboutInfo;
    }
    
    public static void setAboutInfo(AboutInfo aboutInfo)
    {
        Env.aboutInfo = aboutInfo;
    }
}
