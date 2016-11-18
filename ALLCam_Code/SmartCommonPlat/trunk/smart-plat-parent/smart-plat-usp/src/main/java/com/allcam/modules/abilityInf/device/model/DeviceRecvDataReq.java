package com.allcam.modules.abilityInf.device.model;

import com.allcam.modules.bean.bpm.RequestInfo;
import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceRecvDataReq extends RequestInfo
{
    // old
    private String sysId;
    
    private String schoolId;
    
    private String deviceId;
    
    private String deviceType;
    
    private String softVersion;
    
    private String userId;
    
    private String userName;
    
    private String userType;
    
    // old
    private String studentCode;
    
    private String userCode;
    
    private String userMobiles;
    
    // old
    private String users;
    
    private String action;
    
    private String dateTime;
    
    private String picture;
    
    private String isUpPhoto;
    
    private String receiveId;
    
    private boolean isModPhoto = false;
    
    public String getSysId()
    {
        return sysId;
    }
    
    public void setSysId(String sysId)
    {
        this.sysId = sysId;
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
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public String getStudentCode()
    {
        return studentCode;
    }
    
    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getUserMobiles()
    {
        return userMobiles;
    }
    
    public void setUserMobiles(String userMobiles)
    {
        this.userMobiles = userMobiles;
    }
    
    public String getUsers()
    {
        return users;
    }
    
    public void setUsers(String users)
    {
        this.users = users;
    }
    
    public String getAction()
    {
        return action;
    }
    
    public void setAction(String action)
    {
        this.action = action;
    }
    
    public String getDateTime()
    {
        return dateTime;
    }
    
    public void setDateTime(String dateTime)
    {
        this.dateTime = dateTime;
    }
    
    public String getPicture()
    {
        return picture;
    }
    
    public void setPicture(String picture)
    {
        this.picture = picture;
    }
    
    public String getIsUpPhoto()
    {
        return isUpPhoto;
    }
    
    public void setIsUpPhoto(String isUpPhoto)
    {
        this.isUpPhoto = isUpPhoto;
    }
    
    public String getReceiveId()
    {
        return receiveId;
    }
    
    public void setReceiveId(String receiveId)
    {
        this.receiveId = receiveId;
    }
    
    public boolean getIsModPhoto()
    {
        return isModPhoto;
    }
    
    public void setIsModPhoto(boolean isModPhoto)
    {
        this.isModPhoto = isModPhoto;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
