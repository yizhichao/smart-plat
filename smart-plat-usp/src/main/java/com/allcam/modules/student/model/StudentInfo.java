package com.allcam.modules.student.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentInfo implements Serializable
{



    /**
     * 注释内容
     */
    private static final long serialVersionUID = -8007020119310225719L;



    private String idPhoto;
    
    private String idCardNo;
    
    private String birthday;
    
    private String sex;
    
    private String hobby;
    
    private String studentId;
    
    private String studentName;
    
    private String studentEnName;
    
    private String studentCode;
    
    private String classId;
    
    private String className;

    public String getIdPhoto()
    {
        return idPhoto;
    }

    public String getIdCardNo()
    {
        return idCardNo;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public String getSex()
    {
        return sex;
    }

    public String getHobby()
    {
        return hobby;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getStudentEnName()
    {
        return studentEnName;
    }

    public String getStudentCode()
    {
        return studentCode;
    }

    public String getClassId()
    {
        return classId;
    }

    public String getClassName()
    {
        return className;
    }

    public void setIdPhoto(String idPhoto)
    {
        this.idPhoto = idPhoto;
    }

    public void setIdCardNo(String idCardNo)
    {
        this.idCardNo = idCardNo;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public void setStudentId(String studentId)
    {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public void setStudentEnName(String studentEnName)
    {
        this.studentEnName = studentEnName;
    }

    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    @Override
    public String toString()
    {
        return "StudentInfo [idPhoto=" + idPhoto + ", idCardNo=" + idCardNo + ", birthday=" + birthday + ", sex=" + sex
            + ", hobby=" + hobby + ", studentId=" + studentId + ", studentName=" + studentName + ", studentEnName="
            + studentEnName + ", studentCode=" + studentCode + ", classId=" + classId + ", className=" + className
            + "]";
    }
    
    
}

