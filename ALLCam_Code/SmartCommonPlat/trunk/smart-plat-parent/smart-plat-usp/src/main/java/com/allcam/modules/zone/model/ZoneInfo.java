package com.allcam.modules.zone.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZoneInfo extends BaseInfo implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 6918905017385397346L;
    
    private int id;
    
    private String zoneId;
    
    private String zoneName;
    
    private String parentId;
    
    private int status;
    
    private String zoneCode;
    
    private String zoneInfo;
    
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
    
    public String getParentId()
    {
        return parentId;
    }
    
    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
    
    public String getZoneCode()
    {
        return zoneCode;
    }
    
    public void setZoneCode(String zoneCode)
    {
        this.zoneCode = zoneCode;
    }
    
    public String getZoneInfo()
    {
        return zoneInfo;
    }
    
    public void setZoneInfo(String zoneInfo)
    {
        this.zoneInfo = zoneInfo;
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

    @Override
    public String toString()
    {
        return "ZoneInfo [id=" + id + ", zoneId=" + zoneId + ", zoneName=" + zoneName + ", parentId=" + parentId
            + ", status=" + status + ", zoneCode=" + zoneCode + ", zoneInfo=" + zoneInfo + ", remark=" + remark
            + ", createDate=" + createDate + ", lastDate=" + lastDate + "]";
    }
}
