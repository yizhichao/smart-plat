package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.ResponseCommon;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取用户信息的响应求对象
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class GetUserInfoResponse extends ResponseCommon implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -7603113111535279792L;
    
    @JsonProperty(value = "MsgBody")
    private UserInfo userInfo;
    
    public UserInfo getUserInfo()
    {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }
    
}
