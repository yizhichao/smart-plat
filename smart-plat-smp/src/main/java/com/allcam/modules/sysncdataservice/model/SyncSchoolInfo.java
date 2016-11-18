package com.allcam.modules.sysncdataservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 同步接口的学校信息对象
 * 
 * @author marui
 * @version [版本号, Aug 28, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncSchoolInfo implements Serializable
{
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = -3777112998122803539L;
    
    /**
     * 学校id
     */
    private String schoolId;
    
    /**
     * 学校名称
     */
    private String schoolName;
    
    /**
     * 学校匿名账号
     */
    private String anonymousName;
    
    /**
     * 学校logo
     */
    private String logoUrl;
    
    private String startUrl;
    
    /**
     * 学校网店
     */
    private String shopUrl;
    
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
    
    private String schoolDesc;
    
    private String address;
    
    private String email;
    
    private String webSiteUrl;
    
    private String tel;
    
    private String fax;
    
    private String previewPic;
    
    private String lastDate;
    
    private String officeId;
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public String getStartUrl()
    {
        return startUrl;
    }
    
    public void setStartUrl(String startUrl)
    {
        this.startUrl = startUrl;
    }
    
    public String getSchoolDesc()
    {
        return schoolDesc;
    }
    
    public void setSchoolDesc(String schoolDesc)
    {
        this.schoolDesc = schoolDesc;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getWebSiteUrl()
    {
        return webSiteUrl;
    }
    
    public void setWebSiteUrl(String webSiteUrl)
    {
        this.webSiteUrl = webSiteUrl;
    }
    
    public String getTel()
    {
        return tel;
    }
    
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    
    public String getFax()
    {
        return fax;
    }
    
    public void setFax(String fax)
    {
        this.fax = fax;
    }
    
    public String getPreviewPic()
    {
        return previewPic;
    }
    
    public void setPreviewPic(String previewPic)
    {
        this.previewPic = previewPic;
    }
    
    public String getLastDate()
    {
        return lastDate;
    }
    
    public void setLastDate(String lastDate)
    {
        this.lastDate = lastDate;
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
    
    public String getAnonymousName()
    {
        return anonymousName;
    }
    
    public void setAnonymousName(String anonymousName)
    {
        this.anonymousName = anonymousName;
    }
    
    public String getLogoUrl()
    {
        return logoUrl;
    }
    
    public void setLogoUrl(String logoUrl)
    {
        this.logoUrl = logoUrl;
    }
    
    public String getShopUrl()
    {
        return shopUrl;
    }
    
    public void setShopUrl(String shopUrl)
    {
        this.shopUrl = shopUrl;
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
    
    public String getOfficeId()
    {
        return officeId;
    }
    
    public void setOfficeId(String officeId)
    {
        this.officeId = officeId;
    }
    
}
