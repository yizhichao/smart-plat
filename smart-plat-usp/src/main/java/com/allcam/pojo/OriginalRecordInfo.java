package com.allcam.pojo;

import java.util.Date;


public class OriginalRecordInfo
{
    private int serialNum;// 序列号
    
    private String id;// ：原始记录的id
    
    private String personID;// ：人员的ID对应personinfo表的code字段
    
    private String cardUUID;// ：卡号
    
    private String monitorPointInfoID;// ：终端ID，在出入口管理系统中配置
    
    private String time;// ：刷卡时间
    
    private String direction;// ：进出方向，10为进，20为出
    
    private String channelID;// ：通道ID，在出入口管理系统中配置
    
    private String eventType;// ：记录类型
    
    private Date uploadTime;// ：写入表的时间
    
    private String catchPicture;// :抓拍照片获取的地址，对接方需自己填写ip:端口号/
    
    private String tableName;
    
    private String pageSize;
    
    public int getSerialNum()
    {
        return serialNum;
    }

    public void setSerialNum(int serialNum)
    {
        this.serialNum = serialNum;
    }

    private int index;
    
    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getPersonID()
    {
        return personID;
    }
    
    public void setPersonID(String personID)
    {
        this.personID = personID;
    }
    
    public String getCardUUID()
    {
        return cardUUID;
    }
    
    public void setCardUUID(String cardUUID)
    {
        this.cardUUID = cardUUID;
    }
    
    public String getMonitorPointInfoID()
    {
        return monitorPointInfoID;
    }
    
    public void setMonitorPointInfoID(String monitorPointInfoID)
    {
        this.monitorPointInfoID = monitorPointInfoID;
    }
    
    public String getTime()
    {
        return time;
    }
    
    public void setTime(String time)
    {
        this.time = time;
    }
    
    public String getDirection()
    {
        return direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public String getChannelID()
    {
        return channelID;
    }
    
    public void setChannelID(String channelID)
    {
        this.channelID = channelID;
    }
    
    public String getEventType()
    {
        return eventType;
    }
    
    public void setEventType(String eventType)
    {
        this.eventType = eventType;
    }
    
    public Date getUploadTime()
    {
        return uploadTime;
    }
    
    public void setUploadTime(Date uploadTime)
    {
        this.uploadTime = uploadTime;
    }
    
    public String getCatchPicture()
    {
        return catchPicture;
    }
    
    public void setCatchPicture(String catchPicture)
    {
        this.catchPicture = catchPicture;
    }
    
    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }
    
    private String startTime;
    
    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    @Override
    public String toString()
    {
        return "OriginalRecordInfo [id=" + id + ", personID=" + personID + ", cardUUID=" + cardUUID
            + ", monitorPointInfoID=" + monitorPointInfoID + ", time=" + time + ", direction=" + direction
            + ", channelID=" + channelID + ", eventType=" + eventType + ", uploadTime=" + uploadTime
            + ", catchPicture=" + catchPicture + ", tableName=" + tableName + ", pageSize=" + pageSize + ", index="
            + index + ", startTime=" + startTime + "]";
    }
}
