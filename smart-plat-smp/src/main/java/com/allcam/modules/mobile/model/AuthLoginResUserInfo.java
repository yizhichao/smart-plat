package com.allcam.modules.mobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 单点登录接口返回的UserInfo节点参数
 * 
 * @author marui
 * @version [版本号, Aug 25, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthLoginResUserInfo
{
    private String userId;
    
    private String userName;
    
    private String schoolId;
    
    private String schoolName;
    
    private String loginName;
    
    private String aliasName;
    
    private String userType;
    
    private String userCode;
    
    private String accType;
    
    private String status;
    
    private String password;
    
    private String userAucPwd;
    
    private String mobile;
    
    private String shortPhone;
    
    private String fixedPhone;
    
    private String lastDate;
    
    private String registerDate;
    
    private String enableDate;
    
    private String disableDate;
    
    private String ecshopUserId;
    
    private String userExtendData;
    
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
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }
    
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getAliasName()
    {
        return aliasName;
    }
    
    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getAccType()
    {
        return accType;
    }
    
    public void setAccType(String accType)
    {
        this.accType = accType;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getUserAucPwd()
    {
        return userAucPwd;
    }
    
    public void setUserAucPwd(String userAucPwd)
    {
        this.userAucPwd = userAucPwd;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getShortPhone()
    {
        return shortPhone;
    }
    
    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }
    
    public String getFixedPhone()
    {
        return fixedPhone;
    }
    
    public void setFixedPhone(String fixedPhone)
    {
        this.fixedPhone = fixedPhone;
    }
    
    public String getLastDate()
    {
        return lastDate;
    }
    
    public void setLastDate(String lastDate)
    {
        this.lastDate = lastDate;
    }
    
    public String getRegisterDate()
    {
        return registerDate;
    }
    
    public void setRegisterDate(String registerDate)
    {
        this.registerDate = registerDate;
    }
    
    public String getEnableDate()
    {
        return enableDate;
    }
    
    public void setEnableDate(String enableDate)
    {
        this.enableDate = enableDate;
    }
    
    public String getDisableDate()
    {
        return disableDate;
    }
    
    public void setDisableDate(String disableDate)
    {
        this.disableDate = disableDate;
    }
    
    public String getEcshopUserId()
    {
        return ecshopUserId;
    }
    
    public void setEcshopUserId(String ecshopUserId)
    {
        this.ecshopUserId = ecshopUserId;
    }
    
    public String getUserExtendData()
    {
        return userExtendData;
    }
    
    public void setUserExtendData(String userExtendData)
    {
        this.userExtendData = userExtendData;
    }
    
}
