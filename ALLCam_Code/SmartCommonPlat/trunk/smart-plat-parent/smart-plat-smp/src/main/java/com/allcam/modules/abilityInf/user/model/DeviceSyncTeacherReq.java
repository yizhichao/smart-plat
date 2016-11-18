package com.allcam.modules.abilityInf.user.model;

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
public class DeviceSyncTeacherReq extends RequestInfo
{
    private String sysType;
    
    private String sysKey;
    
    private String deviceId;
    
    private String schoolId;
    
    private String userId;
    
    private String userName;
    
    private String pageNo;
    
    private String pageSize;
    
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
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(String pageNo)
    {
        this.pageNo = pageNo;
    }
    
    public String getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
