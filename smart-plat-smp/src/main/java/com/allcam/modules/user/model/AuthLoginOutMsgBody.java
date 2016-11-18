package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgBody;

/**
 * 用户注销接口的body消息体对象
 * 
 * @author  marui
 * @version  [版本号, 2015-3-9]
 */
public class AuthLoginOutMsgBody extends MsgBody implements Serializable
{

    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -6033273593374122861L;
    
    /**
     * 鉴权token
     */
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
    
    
}
