package com.allcam.pojo;

import java.io.Serializable;

/**
 * 学校信息对象 <一句话功能简述> <功能详细描述>
 * 
 * @author marui
 * @version [版本号, Aug 28, 2015]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SchoolInfo implements Serializable
{
    
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -6623609326677652099L;
    
    /**
     * 编号
     */
    private String schoolId;
    
    /**
     * 学校名称
     */
    private String schoolName;
    
    /**
     * 学校地址
     */
    private String schoolAddress;
    
    /**
     * 所属区
     */
    private String schoolRegion;
    
    /**
     * 所属县
     */
    private String schoolCounty;
    
    /**
     * 所属市
     */
    private String schoolCity;
    
    /**
     * 所属省
     */
    private String schoolProvince;
    
    /**
     * 学校logo
     */
    private String schoolLogo;
    
    /**
     * 学校主页地址
     */
    private String schoolHome;
    
    /**
     * 学校匿名账号
     */
    private String anonymousName;
    
    /**
     * 学校排序字段
     */
    private String sort;
    
    /**
     * 学校管理系统HTTP URL
     */
    private String bpmServerUrl;
    
    /**
     * 学校业务平台HTTP URL
     */
    private String bpcServerUrl;
    
    /**
     * 学校业务平台HTTPS URL
     */
    private String bpcHttpsServerUrl;
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }
    
    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }
    
    public String getSchoolAddress()
    {
        return schoolAddress;
    }
    
    public void setSchoolAddress(String schoolAddress)
    {
        this.schoolAddress = schoolAddress;
    }
    
    public String getSchoolRegion()
    {
        return schoolRegion;
    }
    
    public void setSchoolRegion(String schoolRegion)
    {
        this.schoolRegion = schoolRegion;
    }
    
    public String getSchoolCounty()
    {
        return schoolCounty;
    }
    
    public void setSchoolCounty(String schoolCounty)
    {
        this.schoolCounty = schoolCounty;
    }
    
    public String getSchoolCity()
    {
        return schoolCity;
    }
    
    public void setSchoolCity(String schoolCity)
    {
        this.schoolCity = schoolCity;
    }
    
    public String getSchoolProvince()
    {
        return schoolProvince;
    }
    
    public void setSchoolProvince(String schoolProvince)
    {
        this.schoolProvince = schoolProvince;
    }
    
    public String getSchoolLogo()
    {
        return schoolLogo;
    }
    
    public void setSchoolLogo(String schoolLogo)
    {
        this.schoolLogo = schoolLogo;
    }
    
    public String getSchoolHome()
    {
        return schoolHome;
    }
    
    public void setSchoolHome(String schoolHome)
    {
        this.schoolHome = schoolHome;
    }
    
    public String getAnonymousName()
    {
        return anonymousName;
    }
    
    public void setAnonymousName(String anonymousName)
    {
        this.anonymousName = anonymousName;
    }
    
    public String getSort()
    {
        return sort;
    }
    
    public void setSort(String sort)
    {
        this.sort = sort;
    }
    
    public String getBpmServerUrl()
    {
        return bpmServerUrl;
    }
    
    public void setBpmServerUrl(String bpmServerUrl)
    {
        this.bpmServerUrl = bpmServerUrl;
    }
    
    public String getBpcServerUrl()
    {
        return bpcServerUrl;
    }
    
    public void setBpcServerUrl(String bpcServerUrl)
    {
        this.bpcServerUrl = bpcServerUrl;
    }
    
    public String getBpcHttpsServerUrl()
    {
        return bpcHttpsServerUrl;
    }
    
    public void setBpcHttpsServerUrl(String bpcHttpsServerUrl)
    {
        this.bpcHttpsServerUrl = bpcHttpsServerUrl;
    }
    
    public String[] values()
    {
        String[] arr = {this.schoolName, this.schoolAddress, this.schoolHome, this.bpmServerUrl, this.bpcServerUrl};
        return arr;
    }
    
    @Override
    public String toString()
    {
        return "SchoolInfo [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
            + ", schoolRegion=" + schoolRegion + ", schoolCounty=" + schoolCounty + ", schoolCity=" + schoolCity
            + ", schoolProvince=" + schoolProvince + ", schoolLogo=" + schoolLogo + ", schoolHome=" + schoolHome
            + ", anonymousName=" + anonymousName + ", sort=" + sort + ", bpmServerUrl=" + bpmServerUrl
            + ", bpcServerUrl=" + bpcServerUrl + ", bpcHttpsServerUrl=" + bpcHttpsServerUrl + "]";
    }
    
}
