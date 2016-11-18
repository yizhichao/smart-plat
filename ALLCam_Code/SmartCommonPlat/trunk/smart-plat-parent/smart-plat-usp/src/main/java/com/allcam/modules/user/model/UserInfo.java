package com.allcam.modules.user.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 用户信息对象
 *
 * @author  marui
 * @version  [版本号, 2014-7-18]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -6708581615370032811L;

    /**
     * 用户显示名称
     */
    private String userName;
    
    /**
     * 用户登录名
     */
    private String loginName;
    
    /**
     * SVS登录名
     */
    private String loginSvsName;
    
    /**
     * SVS登录密码 MD5 加密
     */
    private String loginSvsPwd;
    
    /**
     * SVS登录域
     */
    private String loginDomain;
    
    /**
     * 用户唯一ID
     */
    private String userId;
    
    /**
     * 用户类型 1：老师 2：家长 3：校长 4：匿名帐号
     */
    private String userType;
    
    /**
     * 用户登录类型 0：普通帐号（字符串） 1：手机号码 2：QQ 3：微信号 4：邮箱
     */
    private String userLoginType;
    
    /**
     * 用户对应的学校ID
     */
    private String nurId;
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginSvsName()
    {
        return loginSvsName;
    }

    public void setLoginSvsName(String loginSvsName)
    {
        this.loginSvsName = loginSvsName;
    }

    public String getLoginSvsPwd()
    {
        return loginSvsPwd;
    }

    public void setLoginSvsPwd(String loginSvsPwd)
    {
        this.loginSvsPwd = loginSvsPwd;
    }

    public String getLoginDomain()
    {
        return loginDomain;
    }

    public void setLoginDomain(String loginDomain)
    {
        this.loginDomain = loginDomain;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserType()
    {
        return userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getUserLoginType()
    {
        return userLoginType;
    }

    public void setUserLoginType(String userLoginType)
    {
        this.userLoginType = userLoginType;
    }

    public String getNurId()
    {
        return nurId;
    }

    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
}
