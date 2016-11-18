package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgBody;

/**
 * 用户鉴权的扩展类
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class GetUserInfoMsgBody extends MsgBody implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 6332594497731481353L;
    /**
     * 鉴权令牌
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
