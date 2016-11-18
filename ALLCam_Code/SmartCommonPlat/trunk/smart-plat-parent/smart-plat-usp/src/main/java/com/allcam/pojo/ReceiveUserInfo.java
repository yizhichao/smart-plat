package com.allcam.pojo;

public class ReceiveUserInfo
{
    private String receiveId;
    
    private String nurId;
    
    private String bpcServerUrl;
    
    private String cardId;
    
    private String userCode;
    
    private String userId;
    
    private String userName;
    
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
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getCardId()
    {
        return cardId;
    }
    
    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
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
        return "ReceiveUserInfo [receiveId=" + receiveId + ", nurId=" + nurId + ", bpcServerUrl=" + bpcServerUrl
            + ", cardId=" + cardId + ", userCode=" + userCode + ", userId=" + userId + ", userName=" + userName
            + ", mobile=" + mobile + ", photoUrl=" + photoUrl + ", receiveTime=" + receiveTime + ", receiveType="
            + receiveType + ", content=" + content + "]";
    }
}
