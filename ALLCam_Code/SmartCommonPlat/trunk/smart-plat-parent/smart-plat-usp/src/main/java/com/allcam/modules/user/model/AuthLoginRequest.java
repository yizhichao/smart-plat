package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录接口的请求消息体
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class AuthLoginRequest implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 5983975103092311026L;
    
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private AuthLoginMsgBody msgBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public AuthLoginMsgBody getMsgBody()
    {
        return msgBody;
    }
    
    public void setMsgBody(AuthLoginMsgBody msgBody)
    {
        this.msgBody = msgBody;
    }
    
}
