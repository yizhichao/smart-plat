package com.allcam.modules.mobile.model;

import com.allcam.modules.bean.MsgHead;
import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取学校请求数据对象
 * 
 * @author  marui
 * @version  [版本号, Aug 25, 2015]
 */
public class GetSchoolsReq
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "MsgBody")
    private GetSchoolsReqBody msgBody;
    
    public MsgHead getMsgHead()
    {
        return msgHead;
    }
    
    public void setMsgHead(MsgHead msgHead)
    {
        this.msgHead = msgHead;
    }
    
    public GetSchoolsReqBody getMsgBody()
    {
        return msgBody;
    }

    public void setMsgBody(GetSchoolsReqBody msgBody)
    {
        this.msgBody = msgBody;
    }

    /**
     * 重写toString方法
     * @return 返回本类有意义的对象
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
