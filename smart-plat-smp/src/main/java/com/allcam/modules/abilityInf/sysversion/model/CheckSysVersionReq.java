package com.allcam.modules.abilityInf.sysversion.model;

import com.allcam.modules.bean.bpm.RequestInfo;
import com.allcam.utils.Tools;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckSysVersionReq extends RequestInfo
{
    private String sysType;
    
    private String sysKey;
    
    private String userLan;
    
    private String cuType;
    
    private String cuVersion;
    
    private String cuVersionDesc;
    
    private String systemVersion;
    
    private String schoolId;
    
    private String deviceId;
    
    public String getSysType()
    {
        return sysType;
    }
    
    public void setSysType(String sysType)
    {
        this.sysType = sysType;
    }
    
    public String getSysKey()
    {
        return sysKey;
    }
    
    public void setSysKey(String sysKey)
    {
        this.sysKey = sysKey;
    }
    
    public String getUserLan()
    {
        return userLan;
    }
    
    public void setUserLan(String userLan)
    {
        this.userLan = userLan;
    }
    
    public String getCuType()
    {
        return cuType;
    }
    
    public void setCuType(String cuType)
    {
        this.cuType = cuType;
    }
    
    public String getCuVersion()
    {
        return cuVersion;
    }
    
    public void setCuVersion(String cuVersion)
    {
        this.cuVersion = cuVersion;
    }
    
    public String getCuVersionDesc()
    {
        return cuVersionDesc;
    }
    
    public void setCuVersionDesc(String cuVersionDesc)
    {
        this.cuVersionDesc = cuVersionDesc;
    }
    
    public String getSystemVersion()
    {
        return systemVersion;
    }
    
    public void setSystemVersion(String systemVersion)
    {
        this.systemVersion = systemVersion;
    }
    
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
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
