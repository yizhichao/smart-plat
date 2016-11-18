package com.allcam.modules.sysncdataservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 同步老师接口主体对象中老师信息
 * 
 * @author marui
 * @version [版本号, Aug 28, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncStudentInfo implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1231864571246763133L;
    
    private String cardId;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 用户姓名 / 登录名
     */
    private String userName;
    
    /**
     * 用户显示名
     */
    private String displayName;
    
    private String userPhoto;
    
    private String studentId;
    
    private String studentCode;
    
    private String studentName;
    
    private String studentEnName;
    
    /**
     * 性别 0：男 1：女
     */
    private String gender;
    
    private String gradeName;
    
    private String className;
    
    /**
     * 头像图片编码信息 base64编码
     */
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
    
    public String getUserPhoto()
    {
        return userPhoto;
    }
    
    public void setUserPhoto(String userPhoto)
    {
        this.userPhoto = userPhoto;
    }
    
    public String getStudentId()
    {
        return studentId;
    }
    
    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
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
    
    public String getGender()
    {
        return gender;
    }
    
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
    public String getGradeName()
    {
        return gradeName;
    }
    
    public void setGradeName(String gradeName)
    {
        this.gradeName = gradeName;
    }
    
    public String getClassName()
    {
        return className;
    }
    
    public void setClassName(String className)
    {
        this.className = className;
    }
    
    public String getPhoto()
    {
        return photo;
    }
    
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }
    
    public String getStudentEnName()
    {
        return studentEnName;
    }
    
    public void setStudentEnName(String studentEnName)
    {
        this.studentEnName = studentEnName;
    }
    
    @Override
    public String toString()
    {
        return "SyncStudentInfo [cardId=" + cardId + ", userId=" + userId + ", userName=" + userName + ", displayName="
            + displayName + ", userPhoto=" + userPhoto + ", studentId=" + studentId + ", studentCode=" + studentCode
            + ", studentName=" + studentName + ", studentEnName=" + studentEnName + ", gender=" + gender
            + ", gradeName=" + gradeName + ", className=" + className + ", photo=" + photo + "]";
    }
}
