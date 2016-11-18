package com.allcam.modules.sysncdataservice.model;

import com.allcam.modules.bean.MsgHead;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 同步学校的请求对象
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncSchoolReq
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private SyncSchoolReqBody syncSchoolReqBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public SyncSchoolReqBody getSyncSchoolReqBody()
    {
        return syncSchoolReqBody;
    }
    
    public void setSyncSchoolReqBody(SyncSchoolReqBody syncSchoolReqBody)
    {
        this.syncSchoolReqBody = syncSchoolReqBody;
    }
}
