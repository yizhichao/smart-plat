package com.allcam.modules.bean.bpm;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResp implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2448422900223464376L;

    @JsonProperty("MsgHead")
    private MsgHeadResp msgHeadResp;

    @JsonProperty("Result")
    private ResultInfo resultInfo;

    public MsgHeadResp getMsgHeadResp()
    {
        return msgHeadResp;
    }

    public void setMsgHeadResp(MsgHeadResp msgHeadResp)
    {
        this.msgHeadResp = msgHeadResp;
    }

    public ResultInfo getResultInfo()
    {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo)
    {
        this.resultInfo = resultInfo;
    }
}
