package com.allcam.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 幼儿园实体类
 * 
 * @author yizhichao
 * 
 */
public class NurSeryBeiyangMapInfo implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 8165266924726490636L;
    
    private String nurId;
    
    private String nurName;
    
    private String schoolId;
    
    private String anonymousName;
    
    private String logoUrl;
    
    private String startUrl;
    
    private String shopUrl;
    
    private String sort;
    
    private String bpcServerUrl;
    
    private String schoolDesc;// 中小学描述
    
    private String address;// 学校地址
    
    private String email;// 学校邮箱
    
    private String webSiteUrl;// 学校网站地址
    
    private String tel;// 学校联系电话
    
    private String fax;// 学校传真
    
    private String previewPic;// 图片URL
    
    private String lastDate;// 上次更新时间
    
    private String personinfoTblname;
    
    private String originalrecordTblname;
    
    private String leaveinfoTblname;
    
    private int startIndex;
    
    private Date startTime;  
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getNurName()
    {
        return nurName;
    }
    
    public void setNurName(String nurName)
    {
        this.nurName = nurName;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
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
    
    public String getStartUrl()
    {
        return startUrl;
    }
    
    public void setStartUrl(String startUrl)
    {
        this.startUrl = startUrl;
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
    
    public String getPersoninfoTblname()
    {
        return personinfoTblname;
    }
    
    public void setPersoninfoTblname(String personinfoTblname)
    {
        this.personinfoTblname = personinfoTblname;
    }
    
    public String getOriginalrecordTblname()
    {
        return originalrecordTblname;
    }
    
    public void setOriginalrecordTblname(String originalrecordTblname)
    {
        this.originalrecordTblname = originalrecordTblname;
    }
    
    public String getLeaveinfoTblname()
    {
        return leaveinfoTblname;
    }
    
    public void setLeaveinfoTblname(String leaveinfoTblname)
    {
        this.leaveinfoTblname = leaveinfoTblname;
    }
    
    public int getStartIndex()
    {
        return startIndex;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    @Override
    public String toString()
    {
        return "NurSeryBeiyangMapInfo [nurId=" + nurId + ", nurName=" + nurName + ", schoolId=" + schoolId
            + ", anonymousName=" + anonymousName + ", logoUrl=" + logoUrl + ", startUrl=" + startUrl + ", shopUrl="
            + shopUrl + ", sort=" + sort + ", bpcServerUrl=" + bpcServerUrl + ", schoolDesc=" + schoolDesc
            + ", address=" + address + ", email=" + email + ", webSiteUrl=" + webSiteUrl + ", tel=" + tel + ", fax="
            + fax + ", previewPic=" + previewPic + ", lastDate=" + lastDate + ", personinfoTblname="
            + personinfoTblname + ", originalrecordTblname=" + originalrecordTblname + ", leaveinfoTblname="
            + leaveinfoTblname + ", startIndex=" + startIndex + ", startTime=" + startTime + "]";
    }
}
