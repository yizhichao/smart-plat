package com.allcam.modules.abilityInf.device.model;

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
public class DeviceRegReq extends RequestInfo
{
    /** 语言环境 */
    private String userLan;
    
    private String deviceSys;
    
    private String sysType;
    
    private String sysKey;
    
    private String deviceId;
    
    private String deviceType;
    
    private String softVersion;
    
    private String ip;
    
    private String macAddr;
    
    private String deviceName;
    
    public String getUserLan()
    {
        return userLan;
    }

    public void setUserLan(String userLan)
    {
        this.userLan = userLan;
    }

    public String getDeviceSys()
    {
        return deviceSys;
    }
    
    public void setDeviceSys(String deviceSys)
    {
        this.deviceSys = deviceSys;
    }
    
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
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getDeviceType()
    {
        return deviceType;
    }
    
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }
    
    public String getSoftVersion()
    {
        return softVersion;
    }
    
    public void setSoftVersion(String softVersion)
    {
        this.softVersion = softVersion;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public void setIp(String ip)
    {
        this.ip = ip;
    }
    
    public String getMacAddr()
    {
        return macAddr;
    }
    
    public void setMacAddr(String macAddr)
    {
        this.macAddr = macAddr;
    }
    
    public String getDeviceName()
    {
        return deviceName;
    }
    
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
