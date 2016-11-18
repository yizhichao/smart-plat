package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.ResponseCommon;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录接口的请求消息体
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class AuthLoginResponse extends ResponseCommon implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 2855958411776066666L;
    
    @JsonProperty(value = "EncryptInfo")
    private EncryptInfo encryptInfo;
    
    public EncryptInfo getEncryptInfo()
    {
        return encryptInfo;
    }
    
    public void setEncryptInfo(EncryptInfo encryptInfo)
    {
        this.encryptInfo = encryptInfo;
    }
}
