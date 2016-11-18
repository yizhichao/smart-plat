package com.allcam.modules.bean.bpm;

import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * HTTP响应对象
 * 
 * @author yizhichao
 * @version [版本号, 2014-5-26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "operations", "roles", "menus"})
public class ResponseInfo
{
    @JsonProperty("MsgHead")
    private MsgHeadResp msgHeadResp;
    
    @JsonProperty("Result")
    private ResultInfo resultInfo;
    
    /** 消息类型 */
    // private String msgType;
    //
    // /** 消息版本 */
    // private String version;
    //
    // /** 消息目标 */
    // private String direction;
    
    /** 响应码 */
    private String errorCode;
    
    /** 响应描述 */
    private String errorDes;
    
    // public String getMsgType()
    // {
    // return msgType;
    // }
    //
    // public void setMsgType(String msgType)
    // {
    // this.msgType = msgType;
    // }
    //
    // public String getVersion()
    // {
    // return version;
    // }
    //
    // public void setVersion(String version)
    // {
    // this.version = version;
    // }
    //
    // public String getDirection()
    // {
    // return direction;
    // }
    //
    // public void setDirection(String direction)
    // {
    // this.direction = direction;
    // }
    @JsonIgnore
    public String getErrorCode()
    {
        return errorCode;
    }
    
    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }
    
    @JsonIgnore
    public String getErrorDes()
    {
        return errorDes;
    }
    
    public void setErrorDes(String errorDes)
    {
        this.errorDes = errorDes;
    }
    
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
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
