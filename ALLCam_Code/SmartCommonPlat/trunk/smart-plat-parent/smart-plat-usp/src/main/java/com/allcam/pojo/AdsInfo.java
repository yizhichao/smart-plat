package com.allcam.pojo;

public class AdsInfo
{
    private String adsId;// String Y 广告ID
    
    private String adsType;// String Y 0：文字+图片+视频（网页） 默认 1：纯视频播放
    
    private String adsName;// String Y 广告名称
    
    private String adsDesc;// String Y 广告描述
    
    private String adsServerUrl;// String Y 广告播放URL

    public String getAdsId()
    {
        return adsId;
    }

    public void setAdsId(String adsId)
    {
        this.adsId = adsId;
    }

    public String getAdsType()
    {
        return adsType;
    }

    public void setAdsType(String adsType)
    {
        this.adsType = adsType;
    }

    public String getAdsName()
    {
        return adsName;
    }

    public void setAdsName(String adsName)
    {
        this.adsName = adsName;
    }

    public String getAdsDesc()
    {
        return adsDesc;
    }

    public void setAdsDesc(String adsDesc)
    {
        this.adsDesc = adsDesc;
    }

    public String getAdsServerUrl()
    {
        return adsServerUrl;
    }

    public void setAdsServerUrl(String adsServerUrl)
    {
        this.adsServerUrl = adsServerUrl;
    }
    
}
