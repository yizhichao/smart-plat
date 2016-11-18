package com.allcam.modules.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 通用响应消息的对象，其它接口继承于此类
 * 
 * @author  yuan
 * @version  [版本号, 2015-3-6]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ResponseCommon
{
    @JsonProperty(value = "MsgHead")
    protected MsgHead msgHead;
    
    @JsonProperty(value = "Result")
    protected Result result;
    
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
}
