package com.allcam.utils;

public class AboutInfo
{
    private String companyInfo; // String Y 公司信息
    
    private String serviceHotline;// String Y 服务热线：025-8335 9216, 18051009315
    
    private String serviceImail;// String Y 服务邮箱：service@baobaocam.com
    
    private String webSiteAddress;// String Y 网站地址：www.baobaocam.com
    
    public String getCompanyInfo()
    {
        return companyInfo;
    }
    
    public void setCompanyInfo(String companyInfo)
    {
        this.companyInfo = companyInfo;
    }
    
    public String getServiceHotline()
    {
        return serviceHotline;
    }
    
    public void setServiceHotline(String serviceHotline)
    {
        this.serviceHotline = serviceHotline;
    }
    
    public String getServiceImail()
    {
        return serviceImail;
    }
    
    public void setServiceImail(String serviceImail)
    {
        this.serviceImail = serviceImail;
    }
    
    public String getWebSiteAddress()
    {
        return webSiteAddress;
    }
    
    public void setWebSiteAddress(String webSiteAddress)
    {
        this.webSiteAddress = webSiteAddress;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
