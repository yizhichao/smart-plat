package com.allcam.modules.mobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 学校信息
 * 
 * @author marui
 * @version [版本号, Aug 25, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSchoolsResSchooInfo
{
    private String schoolId;
    
    private String schoolName;
    
    private String anonymousName;
    
    private String logoUrl;
    
    private String startUrl;
    
    private String shopUrl;
    
    private String sort;
    
    private String bpmServerUrl;
    
    private String bpcServerUrl;
    
    private String bpcHttpsServerUrl;
    
    private String schoolDesc;// 中小学描述
    
    private String address;// 学校地址
    
    private String email;// 学校邮箱
    
    private String webSiteUrl;// 学校网站地址
    
    private String tel;// 学校联系电话
    
    private String fax;// 学校传真
    
    private String previewPic;// 图片URL
    
    private String lastDate;// 上次更新时间
    
    private String officeId;// 上次更新时间
    
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
    
    public String getBpcServerUrl()
    {
        return bpcServerUrl;
    }
    
    public void setBpcServerUrl(String bpcServerUrl)
    {
        this.bpcServerUrl = bpcServerUrl;
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
    
    public String getStartUrl()
    {
        return startUrl;
    }
    
    public void setStartUrl(String startUrl)
    {
        this.startUrl = startUrl;
    }
    
    public String getBpmServerUrl()
    {
        return bpmServerUrl;
    }
    
    public void setBpmServerUrl(String bpmServerUrl)
    {
        this.bpmServerUrl = bpmServerUrl;
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
    
    @Override
    public String toString()
    {
        return "GetSchoolsResSchooInfo [schoolId=" + schoolId + ", schoolName=" + schoolName + ", anonymousName=" + anonymousName
            + ", logoUrl=" + logoUrl + ", startUrl=" + startUrl + ", shopUrl=" + shopUrl + ", sort=" + sort
            + ", bpmServerUrl=" + bpmServerUrl + ", bpcServerUrl=" + bpcServerUrl + ", bpcHttpsServerUrl="
            + bpcHttpsServerUrl + ", schoolDesc=" + schoolDesc + ", address=" + address + ", email=" + email
            + ", webSiteUrl=" + webSiteUrl + ", tel=" + tel + ", fax=" + fax + ", previewPic=" + previewPic
            + ", lastDate=" + lastDate + ", officeId=" + officeId + "]";
    }
    
}
