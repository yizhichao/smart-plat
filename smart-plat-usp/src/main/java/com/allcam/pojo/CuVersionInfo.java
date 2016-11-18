package com.allcam.pojo;

public class CuVersionInfo
{
    private String id;
    
    private String nurId;
    
    private String cuType;
    
    private String versionId;
    
    private String versionMd5;
    
    private String versionName;
    
    private String versionDesc;
    
    private String versionUrl;
    
    private String compatible;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getNurId()
    {
        return nurId;
    }
    
    public void setNurId(String nurId)
    {
        this.nurId = nurId;
    }
    
    public String getCuType()
    {
        return cuType;
    }
    
    public void setCuType(String cuType)
    {
        this.cuType = cuType;
    }
    
    public String getVersionId()
    {
        return versionId;
    }
    
    public void setVersionId(String versionId)
    {
        this.versionId = versionId;
    }
    
    public String getVersionMd5()
    {
        return versionMd5;
    }

    public void setVersionMd5(String versionMd5)
    {
        this.versionMd5 = versionMd5;
    }

    public String getVersionName()
    {
        return versionName;
    }
    
    public void setVersionName(String versionName)
    {
        this.versionName = versionName;
    }
    
    public String getVersionDesc()
    {
        return versionDesc;
    }
    
    public void setVersionDesc(String versionDesc)
    {
        this.versionDesc = versionDesc;
    }
    
    public String getVersionUrl()
    {
        return versionUrl;
    }
    
    public void setVersionUrl(String versionUrl)
    {
        this.versionUrl = versionUrl;
    }
    
    public String getCompatible()
    {
        return compatible;
    }
    
    public void setCompatible(String compatible)
    {
        this.compatible = compatible;
    }
    
    @Override
    public String toString()
    {
        return "CuVersionInfo [id=" + id + ", nurId=" + nurId + ", cuType=" + cuType + ", versionId=" + versionId
            + ", versionName=" + versionName + ", versionDesc=" + versionDesc + ", versionUrl=" + versionUrl
            + ", compatible=" + compatible + "]";
    }
}
