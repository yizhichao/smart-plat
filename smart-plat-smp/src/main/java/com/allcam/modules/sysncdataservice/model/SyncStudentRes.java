package com.allcam.modules.sysncdataservice.model;

import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.bean.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步老师的响应对象
 * 
 * @author marui
 * @version [版本号, Aug 28, 2015]
 */
public class SyncStudentRes
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "Result")
    private Result result;
    
    @JsonProperty(value = "MsgBody")
    private SyncStudentResBody msgBody;
    
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
    
    public SyncStudentResBody getMsgBody()
    {
        return msgBody;
    }
    
    public void setMsgBody(SyncStudentResBody msgBody)
    {
        this.msgBody = msgBody;
    }
}
