package com.allcam.modules.bean.bpm;

import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * HTTP请求对象
 * 
 * @author yizhichao
 * @version [版本号, 2014-5-26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestInfo
{
    /** 消息类型 */
    private String msgType;
    
    /** 消息版本 */
    private String version;
    
    /** 消息目标 */
    private String direction;
    
    /** 用户编号 */
    private String userId;
    
    /** 对应ECSHOP用户编号 */
    private String ecShopUserId;
    
    /** 登录名 */
    private String loginName;
    
    /** 登录名 */
    private String passWord;
    
    /** 用户昵称 */
    private String userName;
    
    /** 用户类型 */
    private String userType;
    
    /** 幼儿园（学校）编号 */
    private String nurId;
    
    private String userNameAuth;
    
    /** 语言环境 */
    private String userLan;
    
    /** 客户端类型 */
    private String cuType;
    
    /** 客户端程序版本 */
    private String cuVersion;
    
    /** 客户端程序版本描述 */
    private String cuVersionDesc;
    
    /** 操作系统版本 */
    private String systemVersion;
    
    public String getCuVersionDesc()
    {
        return cuVersionDesc;
    }
    
    public void setCuVersionDesc(String cuVersionDesc)
    {
        this.cuVersionDesc = cuVersionDesc;
    }
    
    public String getMsgType()
    {
        return msgType;
    }
    
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    
    public String getVersion()
    {
        return version;
    }
    
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    public String getDirection()
    {
        return direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
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
    
    public String getSystemVersion()
    {
        return systemVersion;
    }
    
    public void setSystemVersion(String systemVersion)
    {
        this.systemVersion = systemVersion;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getEcShopUserId()
    {
        return ecShopUserId;
    }
    
    public void setEcShopUserId(String ecShopUserId)
    {
        this.ecShopUserId = ecShopUserId;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getPassWord()
    {
        return passWord;
    }
    
    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getUserNameAuth()
    {
        return userNameAuth;
    }
    
    public void setUserNameAuth(String userNameAuth)
    {
        this.userNameAuth = userNameAuth;
    }
   
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
    
}
