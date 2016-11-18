package com.allcam.modules.mobile.model;

import java.util.List;

import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.bean.Result;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取学校接口的响应对象
 * 
 * @author marui
 * @version [版本号, Aug 25, 2015]
 */
public class GetSchoolsRes
{
    @JsonProperty(value = "MsgHead")
    private MsgHead msgHead;
    
    @JsonProperty(value = "Result")
    private Result result;
    
    @JsonProperty(value = "SchoolList")
    private List<GetSchoolsResSchooInfo> schoolList;
    
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
    
    public List<GetSchoolsResSchooInfo> getSchoolList()
    {
        return schoolList;
    }
    
    public void setSchoolList(List<GetSchoolsResSchooInfo> schoolList)
    {
        this.schoolList = schoolList;
    }
    
}
