package com.allcam.modules.mobile.model;

import com.allcam.utils.SystemUtil;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthLoginReqBody
{
    /**
     * BDGW(考勤管理系统)
     */
    private String sysType = "1";
    
    /**
     * sysKey令牌 (bdgwKey配置以下位加密串)BNuceAXEQmgZ71vrOPOl0EhswHJW4iSQVrcQ4jJPgIgJHP5kiEB4ww==给AUC系统需要 MD5(ALLCAM+配置加密串)
     * 加密后给AUC
     */
    @JsonProperty(value = "sysKey")
    private String sysKey = SystemUtil.getBDGWKey();
    
    /**
     * 用户id(AUTH_LOGIN_SSO接口用)
     */
    @JsonProperty(value = "userId")
    private String userId;
    
    /**
     * 用户名
     */
    @JsonProperty(value = "userName")
    private String userName;
    
    /**
     * 密码，des3加密(AUTH_LOGIN_PWD接口用)
     */
    @JsonProperty(value = "passWord")
    private String password;
    
    /**
     * 学校编号(AUTH_LOGIN_PWD接口用)
     */
    @JsonProperty(value = "schoolId")
    private String schoolId;
    
    /**
     * 鉴权令牌
     */
    private String token;
    
    /**
     * 加密串
     */
    private String encrypt;
    
    /**
     * 时间戳
     */
    @JsonProperty(value = "timeStamp")
    private String timestamp;
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getSysType()
    {
        return sysType;
    }
    
    public void setSysType(String sysType)
    {
        this.sysType = sysType;
    }
    
    public String getSysKey()
    {
        return sysKey;
    }
    
    public void setSysKey(String sysKey)
    {
        this.sysKey = sysKey;
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
    
    public String getToken()
    {
        return token;
    }
    
    public void setToken(String token)
    {
        this.token = token;
    }
    
    public String getEncrypt()
    {
        return encrypt;
    }
    
    public void setEncrypt(String encrypt)
    {
        this.encrypt = encrypt;
    }
    
    public String getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
}
