package com.allcam.pojo;

import java.io.Serializable;

import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户实体类
 * 
 * @author marui
 * @version [版本号, Jul 10, 2015]
 */
public class StudentInfo implements Serializable
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 5729754358787539200L;
    
    private String id;
    
    /**
     * 组织结构ID
     */
    private String organizationId;
    
    /**
     * 学校ID
     */
    private String schoolId;
    
    private String schoolName;
    
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
    
    private String lastDate;
    
    private String deviceId;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
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
    
    public String getOrganizationId()
    {
        return organizationId;
    }
    
    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getStudentEnName()
    {
        return studentEnName;
    }
    
    public void setStudentEnName(String studentEnName)
    {
        this.studentEnName = studentEnName;
    }
    
    public String getLastDate()
    {
        return lastDate;
    }
    
    public void setLastDate(String lastDate)
    {
        this.lastDate = lastDate;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }
    
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }
    
    @JsonIgnore
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String[] chooseStudentValues()
    {
        String[] arr =
            {this.cardId, this.userName, this.schoolName, this.studentName, this.studentCode, this.className,
                this.studentId};
        return arr;
    }
    
    public String[] values()
    {
        String[] arr =
            {this.cardId, this.userName, this.studentName, this.studentCode, this.studentEnName, this.gender,
                this.schoolName, this.gradeName, this.className, this.lastDate};
        return arr;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
    
}
