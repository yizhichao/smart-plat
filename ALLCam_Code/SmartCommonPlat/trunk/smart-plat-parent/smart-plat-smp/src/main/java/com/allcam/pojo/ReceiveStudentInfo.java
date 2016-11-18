package com.allcam.pojo;

public class ReceiveStudentInfo
{
    private String receiveId;
    
    private String studentId;
    
    private String classId;
    
    private String className;
    
    private String nurId;
    
    private String bpcServerUrl;
    
    private String studentCode;
    
    private String studentName;
    
    private String cardId;
    
    private String userId;
    
    private String userName;
    
    private String relationType;
    
    private String mobile;
    
    private String photoUrl;
    
    private String receiveTime;
    
    private String receiveType;
    
    private String content;
    
    public String getReceiveId()
    {
        return receiveId;
    }

    public void setReceiveId(String receiveId)
    {
        this.receiveId = receiveId;
    }

    public String getStudentId()
    {
        return studentId;
    }
    
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }
    
    public String getClassId()
    {
        return classId;
    }
    
    public void setClassId(String classId)
    {
        this.classId = classId;
    }
    
    public String getClassName()
    {
        return className;
    }
    
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getStudentCode()
    {
        return studentCode;
    }
    
    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }
    
    public String getCardId()
    {
        return cardId;
    }
    
    public void setCardId(String cardId)
    {
        this.cardId = cardId;
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
    
    public String getRelationType()
    {
        return relationType;
    }
    
    public void setRelationType(String relationType)
    {
        this.relationType = relationType;
    }
    
    public String getMobile()
    {
        return mobile;
    }
    
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    
    public String getPhotoUrl()
    {
        return photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl)
    {
        this.photoUrl = photoUrl;
    }
    
    public String getReceiveTime()
    {
        return receiveTime;
    }
    
    public void setReceiveTime(String receiveTime)
    {
        this.receiveTime = receiveTime;
    }
    
    public String getReceiveType()
    {
        return receiveType;
    }
    
    public void setReceiveType(String receiveType)
    {
        this.receiveType = receiveType;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getBpcServerUrl()
    {
        return bpcServerUrl;
    }

    public void setBpcServerUrl(String bpcServerUrl)
    {
        this.bpcServerUrl = bpcServerUrl;
    }

    @Override
    public String toString()
    {
        return "ReceiveStudentInfo [receiveId=" + receiveId + ", studentId=" + studentId + ", classId=" + classId
            + ", className=" + className + ", nurId=" + nurId + ", bpcServerUrl=" + bpcServerUrl + ", studentCode="
            + studentCode + ", studentName=" + studentName + ", cardId=" + cardId + ", userId=" + userId
            + ", userName=" + userName + ", relationType=" + relationType + ", mobile=" + mobile + ", photoUrl="
            + photoUrl + ", receiveTime=" + receiveTime + ", receiveType=" + receiveType + ", content=" + content + "]";
    }
}
