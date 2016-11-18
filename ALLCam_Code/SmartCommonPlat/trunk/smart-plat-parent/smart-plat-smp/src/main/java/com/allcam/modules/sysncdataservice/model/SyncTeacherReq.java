package com.allcam.modules.sysncdataservice.model;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步老师的请求对象
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncTeacherReq
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private SyncTeacherReqBody syncTeacherReqBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public SyncTeacherReqBody getSyncTeacherReqBody()
    {
        return syncTeacherReqBody;
    }
    
    public void setSyncTeacherReqBody(SyncTeacherReqBody syncTeacherReqBody)
    {
        this.syncTeacherReqBody = syncTeacherReqBody;
    }
}
