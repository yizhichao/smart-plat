package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户注销接口的请求参数
 * 
 * @author  marui
 * @version  [版本号, 2015-3-9]
 */
public class AuthLoginoutRequest implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -2418113738297007114L;
    
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private AuthLoginOutMsgBody msgBody;

    public MsgHead getMsgHead()
    {
        return msgHead;
    }

    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }

    public AuthLoginOutMsgBody getMsgBody()
    {
        return msgBody;
    }

    public void setMsgBody(AuthLoginOutMsgBody msgBody)
    {
        this.msgBody = msgBody;
    }
}
