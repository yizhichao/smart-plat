package com.allcam.pojo;

import java.io.Serializable;

/**
 * 幼儿园实体类
 * 
 * @author yizhichao
 * 
 */
public class PersonFailResendInfo implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 8165266924726490636L;
    
    private String id;
    
    private String nurId;
    
    private String resendId;
    
    private String bpcUrl;
    
    private String filePath;
    
    private int userType; // int NOT NULL DEFAULT 0 COMMENT '0：学生;1：老师;2：未知',
    
    private String userData;
    
    private String studentData;
    
    private String receiveId;
    
    private int isModPhoto;
    
    private int status;
    
    private int resendCount;
    
    private String pageSize;
    
    private String exceptionMsg;
    
    public int getUserType()
    {
        return userType;
    }
    
    public void setUserType(int userType)
    {
        this.userType = userType;
    }
    
    public String getUserData()
    {
        return userData;
    }
    
    public void setUserData(String userData)
    {
        this.userData = userData;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getResendId()
    {
        return resendId;
    }
    
    public void setResendId(String resendId)
    {
        this.resendId = resendId;
    }
    
    public String getBpcUrl()
    {
        return bpcUrl;
    }
    
    public void setBpcUrl(String bpcUrl)
    {
        this.bpcUrl = bpcUrl;
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
    public String getStudentData()
    {
        return studentData;
    }
    
    public void setStudentData(String studentData)
    {
        this.studentData = studentData;
    }
    
    public int getIsModPhoto()
    {
        return isModPhoto;
    }
    
    public void setIsModPhoto(int isModPhoto)
    {
        this.isModPhoto = isModPhoto;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public int getResendCount()
    {
        return resendCount;
    }
    
    public void setResendCount(int resendCount)
    {
        this.resendCount = resendCount;
    }
    
    public String getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public String getReceiveId()
    {
        return receiveId;
    }
    
    public void setReceiveId(String receiveId)
    {
        this.receiveId = receiveId;
    }
    
    public String getExceptionMsg()
    {
        return exceptionMsg;
    }
    
    public void setExceptionMsg(String exceptionMsg)
    {
        this.exceptionMsg = exceptionMsg;
    }
    
    @Override
    public String toString()
    {
        return "PersonFailResendInfo [id=" + id + ", nurId=" + nurId + ", resendId=" + resendId + ", bpcUrl=" + bpcUrl
            + ", filePath=" + filePath + ", userType=" + userType + ", userData=" + userData + ", studentData="
            + studentData + ", receiveId=" + receiveId + ", isModPhoto=" + isModPhoto + ", status=" + status
            + ", resendCount=" + resendCount + ", pageSize=" + pageSize + ", exceptionMsg=" + exceptionMsg + "]";
    }
}
