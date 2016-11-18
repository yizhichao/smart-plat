package com.allcam.modules.user.web.controller;

import com.raising.system.framework.enums.Enums.UserType;

/**
 * 登录对象
 * 
 * @author
 * 
 */
public class LoginCommand
{
    private String usercode; // 机构代码
    
    private String username; // 账号
    
    private String password; // 密码
    
    private UserType userType; // 用户类型
    
    private boolean rememberMe = false; // 记住我
    
    public LoginCommand()
    {
    }
    
    public String getUsercode()
    {
        return usercode;
    }
    
    public void setUsercode(String usercode)
    {
        this.usercode = usercode;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public boolean isRememberMe()
    {
        return rememberMe;
    }
    
    public void setRememberMe(boolean rememberMe)
    {
        this.rememberMe = rememberMe;
    }
    
    public UserType getUserType()
    {
        return userType;
    }
    
    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }
}
