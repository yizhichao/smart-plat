package com.allcam.modules.user.model;

import java.io.Serializable;
import java.util.List;

import com.allcam.modules.student.model.StudentInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserExtendData implements Serializable
{
    
    private static final long serialVersionUID = 4029255292983013874L;
    
    private String userName;
    
    private String userType;
    
    private String loginName;
    
    private String userPhoto;
    
    private String backGroundUrl;
    
    private String aliasName;
    
    private String userCode;
    
    private String userCardId;
    
    private String email;
    
    private String userId;
    
    private String status;
    
    private String accType;
    
    private String phone;
    
    private String sex;
    
    private String shortPhone;
    
    private String fixedPhone;
    
    private String address;
    
    private String postcode;
    
    private String schoolId;
    
    private String schoolName;
    
    private String ecshopUserId;
    
    private List<StudentInfo> studentList;
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public String getUserPhoto()
    {
        return userPhoto;
    }
    
    public String getBackGroundUrl()
    {
        return backGroundUrl;
    }
    
    public String getAliasName()
    {
        return aliasName;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public String getUserCardId()
    {
        return userCardId;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public String getAccType()
    {
        return accType;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public String getShortPhone()
    {
        return shortPhone;
    }
    
    public String getFixedPhone()
    {
        return fixedPhone;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getPostcode()
    {
        return postcode;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }
    
    public String getEcshopUserId()
    {
        return ecshopUserId;
    }
    
    public List<StudentInfo> getStudentList()
    {
        return studentList;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public void setUserPhoto(String userPhoto)
    {
        this.userPhoto = userPhoto;
    }
    
    public void setBackGroundUrl(String backGroundUrl)
    {
        this.backGroundUrl = backGroundUrl;
    }
    
    public void setAliasName(String aliasName)
    {
        this.aliasName = aliasName;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public void setUserCardId(String userCardId)
    {
        this.userCardId = userCardId;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public void setAccType(String accType)
    {
        this.accType = accType;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }
    
    public void setFixedPhone(String fixedPhone)
    {
        this.fixedPhone = fixedPhone;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }
    
    public void setEcshopUserId(String ecshopUserId)
    {
        this.ecshopUserId = ecshopUserId;
    }
    
    public void setStudentList(List<StudentInfo> studentList)
    {
        this.studentList = studentList;
    }
    
    @Override
    public String toString()
    {
        return "UserExtendData [userName=" + userName + ", userType=" + userType + ", loginName=" + loginName
            + ", userPhoto=" + userPhoto + ", backGroundUrl=" + backGroundUrl + ", aliasName=" + aliasName
            + ", userCode=" + userCode + ", userCardId=" + userCardId + ", email=" + email + ", userId=" + userId
            + ", status=" + status + ", accType=" + accType + ", phone=" + phone + ", sex=" + sex + ", shortPhone="
            + shortPhone + ", fixedPhone=" + fixedPhone + ", address=" + address + ", postcode=" + postcode
            + ", schoolId=" + schoolId + ", schoolName=" + schoolName + ", ecshopUserId=" + ecshopUserId
            + ", studentList=" + studentList + "]";
    }
    
}
