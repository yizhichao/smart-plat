package com.allcam.modules.user.model;

import java.io.Serializable;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取用户信息的请求对象
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class GetUserInfoRequest implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -7603113111535279792L;
    
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private GetUserInfoMsgBody getUserInfoMsgBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public GetUserInfoMsgBody getGetUserInfoMsgBody()
    {
        return getUserInfoMsgBody;
    }
    
    public void setGetUserInfoMsgBody(GetUserInfoMsgBody getUserInfoMsgBody)
    {
        this.getUserInfoMsgBody = getUserInfoMsgBody;
    }
    
}
