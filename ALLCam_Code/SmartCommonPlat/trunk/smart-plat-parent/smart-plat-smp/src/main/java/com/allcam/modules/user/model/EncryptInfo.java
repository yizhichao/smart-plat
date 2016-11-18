package com.allcam.modules.user.model;

import java.io.Serializable;

/**
 * 鉴权信息
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class EncryptInfo implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 900717749288040983L;
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
