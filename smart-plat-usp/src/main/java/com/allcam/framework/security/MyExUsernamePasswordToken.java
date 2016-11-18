package com.allcam.framework.security;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.raising.system.framework.enums.Enums.UserType;

/**
 * MyToken
 * 
 * @author  marui
 * @version  [版本号, 2015-3-4]
 */
public class MyExUsernamePasswordToken extends UsernamePasswordToken
{
    private static final long serialVersionUID = -6791577552546396582L;
    
    // 机构代码
    private String usercode;
    
    // 用户类型
    private UserType userType;
    
    // 验证码
    private String captche;
    
    /**
     * @param username 用户名
     * @param password 密码
     */
    public MyExUsernamePasswordToken(String username, String password)
    {
        super(username, password);
    }
    
    /**
     * @param username 用户名
     * @param password 密码
     * @param userType 用户类型
     */
    public MyExUsernamePasswordToken(String username, String password,
            UserType userType)
    {
        super(username, password);
        this.userType = userType;
    }
    
    /**
     * @param username 用户名
     * @param password 密码
     * @param captche 验证码
     * @param userType 用户类型
     */
    public MyExUsernamePasswordToken(String username, String password,
            String captche, UserType userType)
    {
        super(username, password);
        this.userType = userType;
        this.captche = captche;
    }
    
    public UserType getUserType()
    {
        return userType;
    }
    
    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }
    
    public String getCaptche()
    {
        return captche;
    }
    
    public void setCaptche(String captche)
    {
        this.captche = captche;
    }
    
    public String getUsercode()
    {
        return usercode;
    }
    
    public void setUsercode(String usercode)
    {
        this.usercode = usercode;
    }
    
}
