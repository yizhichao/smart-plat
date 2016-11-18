package com.allcam.modules.bean;

import java.util.Properties;

import com.allcam.utils.ConfigHelper;
import com.allcam.utils.SystemUtil;

/**
 * 消息体的body信息
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class MsgBody
{
    /**
     * 语言环境 Zh : 中文 En : 英文
     */
    protected String userLan = SystemUtil.getUserLan();
    
    /**
     * 客户端类型 IOS Android PC WEBPORTAL
     */
    protected String cuType = ConfigHelper.getValueByKey("interface.msgBody.cuType");
    
    /**
     * 客户端程序版本 1.0.1
     */
    protected String cuVersion = ConfigHelper.getValueByKey("interface.msgBody.cuVersion");;
    
    /**
     * 客户端程序版本描述 V0.9 V1.0
     */
    protected String cuVersionDesc = ConfigHelper.getValueByKey("interface.msgBody.cuVersionDesc");
    
    /**
     * 操作系统版本,在get方法中已经获取
     */
    protected String systemVersion;
    
    /**
     * ebPortal令牌 (WebPortal配置以下位加密串)
     * BNuceAXEQmgZ71vrOPOl0EhswHJW4iSQVrcQ4jJPgIgJHP5kiEB4ww==
     * 给业务平台系统需要
     * MD5(ALLCAM+配置加密串) 加密后给业务平台
     */
    protected String webPortalKey = SystemUtil.getWebPortalKey();
    
    public String getUserLan()
    {
        return userLan;
    }
    
    public void setUserLan(String userLan)
    {
        this.userLan = userLan;
    }
    
    public String getCuType()
    {
        return cuType;
    }
    
    public void setCuType(String cuType)
    {
        this.cuType = cuType;
    }
    
    public String getCuVersion()
    {
        return cuVersion;
    }
    
    public void setCuVersion(String cuVersion)
    {
        this.cuVersion = cuVersion;
    }
    
    public String getCuVersionDesc()
    {
        return cuVersionDesc;
    }
    
    public void setCuVersionDesc(String cuVersionDesc)
    {
        this.cuVersionDesc = cuVersionDesc;
    }
    
    public String getSystemVersion()
    {
        Properties props=System.getProperties(); //获得系统属性集    
        systemVersion = props.getProperty("os.version"); //操作系统版本 

        return systemVersion;
    }
    
    public void setSystemVersion(String systemVersion)
    {
        this.systemVersion = systemVersion;
    }
    
    public String getWebPortalKey()
    {
        return webPortalKey;
    }
    
    public void setWebPortalKey(String webPortalKey)
    {
        this.webPortalKey = webPortalKey;
    }
}
