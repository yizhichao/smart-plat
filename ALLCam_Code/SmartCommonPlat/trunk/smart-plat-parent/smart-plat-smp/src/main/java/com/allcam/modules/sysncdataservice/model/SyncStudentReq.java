package com.allcam.modules.sysncdataservice.model;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步老师的请求对象
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncStudentReq
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private SyncStudentReqBody syncStudentReqBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public SyncStudentReqBody getSyncStudentReqBody()
    {
        return syncStudentReqBody;
    }
    
    public void setSyncStudentReqBody(SyncStudentReqBody syncStudentReqBody)
    {
        this.syncStudentReqBody = syncStudentReqBody;
    }
}
