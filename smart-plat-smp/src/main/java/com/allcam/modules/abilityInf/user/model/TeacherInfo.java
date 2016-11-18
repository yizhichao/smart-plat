package com.allcam.modules.abilityInf.user.model;

public class TeacherInfo
{
    private String cardId;
    
    private String userId;
    
    private String userCode;
    
    private String userName;
    
    private String displayName;
    
    private String accType;
    
    private String status;
    
    private String sex;
    
    private String email;
    
    private String phone;
    
    private String shortPhone;
    
    private String fixedPhone;
    
    private String address;
    
    private String postCode;
    
    private String photo;
    
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
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getDisplayName()
    {
        return displayName;
    }
    
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
    
    public String getAccType()
    {
        return accType;
    }
    
    public void setAccType(String accType)
    {
        this.accType = accType;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getShortPhone()
    {
        return shortPhone;
    }
    
    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }
    
    public String getFixedPhone()
    {
        return fixedPhone;
    }
    
    public void setFixedPhone(String fixedPhone)
    {
        this.fixedPhone = fixedPhone;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getPhoto()
    {
        return photo;
    }
    
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }
    
    @Override
    public String toString()
    {
        return "TeacherInfo [cardId=" + cardId + ", userId=" + userId + ", userCode=" + userCode + ", userName="
            + userName + ", displayName=" + displayName + ", accType=" + accType + ", status=" + status + ", sex="
            + sex + ", email=" + email + ", phone=" + phone + ", shortPhone=" + shortPhone + ", fixedPhone="
            + fixedPhone + ", address=" + address + ", postCode=" + postCode + ", photo=" + photo + "]";
    }
}