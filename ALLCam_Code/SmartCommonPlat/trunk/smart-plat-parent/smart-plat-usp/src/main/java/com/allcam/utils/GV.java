package com.allcam.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局变量 
 */
public final class GV
{
    // 不分页默认数字
    public static final int notPage = -1;
    
    /**
     * 权限严格检测，必须从内存中检测当前用户方位的菜单ID是否有权限
     * */
    public static final boolean MENUCHECK = true;
    
    /**
     * 默认皮肤风格
     * */
    public static final String APP_DEFAULT_THEME = "default";
    
    /**
     * 默认皮肤风格
     * */
    private static final Map<String, String> APP_THEMES = new HashMap<String, String>();
    
    /**
     * 公告包含文件的跟目录
     * */
    public static final String INC = "/inc/";
    
    /**
     * 生成静态公共文件的Base目录
     * */
    public static final String genFileBasePath = "/../../htmlfiles/";
    
    /**
     * 视图
     * */
    public static final String HOME = "/home/";
    
    /**
     * 视图
     * */
    public static final String VIEWS = "/WEB-INF/view/";
    
    /**
     * 视图
     * */
    public static final String MOBILES = "/WEB-INF/view/mobile/";
    
    /**
     * 内网的视图目录
     * */
    public static final String INSIDE = VIEWS.concat("");
    
    /**
     * 内网系统管理的视图目录
     * */
    public static final String SYSTEM = VIEWS.concat("system/");
    
    /**
     * 内网的门户视图目录
     * */
    public static final String INSIDEPORTAL = INSIDE.concat("portal/");
    
    /**
     * 外网的视图目录
     * */
    public static final String OUTSIDE = VIEWS.concat("outside/");
    
    public static final String VV(String CONTROLLER, String ViewName)
    {
        return CONTROLLER.concat(ViewName);
    }
    
    /**
     * 启动的时候添加项目的风格
     * 
     * @param key
     * @param value
     */
    public static final void addTheme(String key, String value)
    {
        APP_THEMES.put(key, value);
    }
    
}
