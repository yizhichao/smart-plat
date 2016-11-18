package com.allcam.modules.logs.model;

import java.io.Serializable;

import com.allcam.modules.mobile.model.AuthLoginResUserInfo;

public class Log implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 4491586007487550037L;
    
    private String description;
    
    private String exceptionCode;
    
    private String type;
    
    private String exceptionDetail;
    
    private String method;
    
    private String params;
    
    private AuthLoginResUserInfo createBy;
    
    private String createDate;
    
    private String requestIp;
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getExceptionCode()
    {
        return exceptionCode;
    }
    
    public void setExceptionCode(String exceptionCode)
    {
        this.exceptionCode = exceptionCode;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getExceptionDetail()
    {
        return exceptionDetail;
    }
    
    public void setExceptionDetail(String exceptionDetail)
    {
        this.exceptionDetail = exceptionDetail;
    }
    
    public String getMethod()
    {
        return method;
    }
    
    public void setMethod(String method)
    {
        this.method = method;
    }
    
    public String getParams()
    {
        return params;
    }
    
    public void setParams(String params)
    {
        this.params = params;
    }
    
    public AuthLoginResUserInfo getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(AuthLoginResUserInfo createBy)
    {
        this.createBy = createBy;
    }

    public String getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }
    
    public String getRequestIp()
    {
        return requestIp;
    }
    
    public void setRequestIp(String requestIp)
    {
        this.requestIp = requestIp;
    }
    
    @Override
    public String toString()
    {
        return "Log [description=" + description + ", exceptionCode=" + exceptionCode + ", type=" + type
            + ", exceptionDetail=" + exceptionDetail + ", method=" + method + ", params=" + params + ", createBy="
            + createBy + ", createDate=" + createDate + ", requestIp=" + requestIp + "]";
    }
}
