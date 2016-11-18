package com.allcam.modules.mobile.model;

import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.bean.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 单点登录接口的响应对象
 * 
 * @author marui
 * @version [版本号, Aug 25, 2015]
 */
public class AuthLoginRes
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "Result")
    private Result result;
    
    @JsonProperty(value = "ServerInfo")
    private AuthLoginResServerInfo serverInfo;
    
    @JsonProperty(value = "UserInfo")
    private AuthLoginResUserInfo userInfo;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public Result getResult()
    {
        return result;
    }
    
    public void setResult(Result result)
    {
        this.result = result;
    }
    
    public AuthLoginResServerInfo getServerInfo()
    {
        return serverInfo;
    }
    
    public void setServerInfo(AuthLoginResServerInfo serverInfo)
    {
        this.serverInfo = serverInfo;
    }
    
    public AuthLoginResUserInfo getUserInfo()
    {
        return userInfo;
    }
    
    public void setUserInfo(AuthLoginResUserInfo userInfo)
    {
        this.userInfo = userInfo;
    }
    
}
