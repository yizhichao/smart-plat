package com.allcam.modules.abilityInf.sysversion.model;

import com.allcam.modules.bean.bpm.ResponseInfo;
import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * 检查版本信息bean
 * 
 * @author YiZhichao
 * @version [版本号, 2014-10-18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "operations", "roles", "menus"})
public class CheckSysVersionResp extends ResponseInfo
{
    private String schoolId;
    
    private String deviceId;
    
    private String type;
    
    private String compatible;
    
    private String cuVersion;
    
    private String cuVersionMd5;
    
    private String cuVersionName;
    
    private String cuVersionDesc;
    
    private String cuVersionAddress;
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    @JsonIgnore
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getCompatible()
    {
        return compatible;
    }
    
    public void setCompatible(String compatible)
    {
        this.compatible = compatible;
    }
    
    public String getCuVersion()
    {
        return cuVersion;
    }
    
    public void setCuVersion(String cuVersion)
    {
        this.cuVersion = cuVersion;
    }
    
    public String getCuVersionName()
    {
        return cuVersionName;
    }
    
    public void setCuVersionName(String cuVersionName)
    {
        this.cuVersionName = cuVersionName;
    }
    
    public String getCuVersionDesc()
    {
        return cuVersionDesc;
    }
    
    public void setCuVersionDesc(String cuVersionDesc)
    {
        this.cuVersionDesc = cuVersionDesc;
    }
    
    public String getCuVersionAddress()
    {
        return cuVersionAddress;
    }
    
    public void setCuVersionAddress(String cuVersionAddress)
    {
        this.cuVersionAddress = cuVersionAddress;
    }
    
    public String getCuVersionMd5()
    {
        return cuVersionMd5;
    }

    public void setCuVersionMd5(String cuVersionMd5)
    {
        this.cuVersionMd5 = cuVersionMd5;
    }

    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
