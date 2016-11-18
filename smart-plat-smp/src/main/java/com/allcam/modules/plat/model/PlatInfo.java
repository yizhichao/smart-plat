package com.allcam.modules.plat.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;

public class PlatInfo extends BaseInfo implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 7352262357464716902L;
    
    private int id;
    
    private String zoneId;
    
    private String zoneName;
    
    private String platId;
    
    private String platName;
    
    private String platType;
    
    private String platIp;
    
    private String platPort;
    
    private String platVersion;
    
    private String status;
    
    private String remark;
    
    private String createDate;
    
    private String lastDate;
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getPlatId()
    {
        return platId;
    }
    
    public void setPlatId(String platId)
    {
        this.platId = platId;
    }
    
    public String getPlatName()
    {
        return platName;
    }
    
    public void setPlatName(String platName)
    {
        this.platName = platName;
    }
    
    public String getPlatType()
    {
        return platType;
    }
    
    public void setPlatType(String platType)
    {
        this.platType = platType;
    }
    
    public String getPlatIp()
    {
        return platIp;
    }
    
    public void setPlatIp(String platIp)
    {
        this.platIp = platIp;
    }
    
    public String getPlatPort()
    {
        return platPort;
    }
    
    public void setPlatPort(String platPort)
    {
        this.platPort = platPort;
    }
    
    public String getPlatVersion()
    {
        return platVersion;
    }
    
    public void setPlatVersion(String platVersion)
    {
        this.platVersion = platVersion;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public String getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }
    
    public String getLastDate()
    {
        return lastDate;
    }
    
    public void setLastDate(String lastDate)
    {
        this.lastDate = lastDate;
    }
    
    public String getZoneId()
    {
        return zoneId;
    }
    
    public void setZoneId(String zoneId)
    {
        this.zoneId = zoneId;
    }
    
    public String getZoneName()
    {
        return zoneName;
    }
    
    public void setZoneName(String zoneName)
    {
        this.zoneName = zoneName;
    }
    
    public String[] values()
    {
        String[] arr =
            {this.platName, this.platType, this.platIp, this.platPort, this.platVersion, this.status, this.remark,
                this.lastDate, this.createDate, this.platId, this.zoneId, this.zoneName};
        return arr;
    }
    
    @Override
    public String toString()
    {
        return "PlatInfo [id=" + id + ", zoneId=" + zoneId + ", zoneName=" + zoneName + ", platId=" + platId
            + ", platName=" + platName + ", platType=" + platType + ", platIp=" + platIp + ", platPort=" + platPort
            + ", platVersion=" + platVersion + ", status=" + status + ", remark=" + remark + ", createDate="
            + createDate + ", lastDate=" + lastDate + "]";
    }
}
