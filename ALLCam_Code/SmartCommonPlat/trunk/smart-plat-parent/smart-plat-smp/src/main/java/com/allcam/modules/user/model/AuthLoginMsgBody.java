package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgBody;

/**
 * 用户鉴权的扩展类
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class AuthLoginMsgBody extends MsgBody implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 8052488580891515438L;

    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 用户密码 （DES3加密）
     */
    private String passWord;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
}
