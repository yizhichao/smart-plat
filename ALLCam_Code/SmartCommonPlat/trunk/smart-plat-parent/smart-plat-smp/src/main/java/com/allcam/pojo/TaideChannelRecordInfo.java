package com.allcam.pojo;

import java.util.Date;

public class TaideChannelRecordInfo
{
    private int tgID;// ：原始记录的id
    
    private String client;// ：(客户机名称) 关联客户机表clientid
    
    private String channel;// ：(通道机) 关联通道机channelID
    
    private String perInfo;// ：PerInfo 关联人员表piid
    
    private String dept; // (部门编号)（部门表外键） 从部门表中取关联deptid
    
    private String pdept;// 父部门ID
    
    private String credNO1;// (证件号1) 对应学工号
    
    private String serialNo;// ：卡号
    
    private String tgStatus;// ：通过状态 Setting表 type=2
    
    private Date tgTime;// ：通过时间
    
    private String inOut;// ：进出方向 Setting表 type=4
    
    private String upFlag;// ：发短信标识 0 未发送 1 已发送
    
    private String upDT;// :发送时间
    
    private String blReason; // 补录原因
    
    private String blDT; // 补录时间
    
    private String buluOper; // 操作员
    
    private String capturePhotoPath_Front;
    
    private String capturePhotoPath_Back;
    
    private String passRoomID;
    
    private String piMobilePhone1;
    
    private String pageSize;
    
    public int getTgID()
    {
        return tgID;
    }

    public void setTgID(int tgID)
    {
        this.tgID = tgID;
    }

    public String getClient()
    {
        return client;
    }
    
    public void setClient(String client)
    {
        this.client = client;
    }
    
    public String getChannel()
    {
        return channel;
    }
    
    public void setChannel(String channel)
    {
        this.channel = channel;
    }
    
    public String getPerInfo()
    {
        return perInfo;
    }
    
    public void setPerInfo(String perInfo)
    {
        this.perInfo = perInfo;
    }
    
    public String getSerialNo()
    {
        return serialNo;
    }
    
    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }
    
    public String getTgStatus()
    {
        return tgStatus;
    }
    
    public void setTgStatus(String tgStatus)
    {
        this.tgStatus = tgStatus;
    }
    
    public Date getTgTime()
    {
        return tgTime;
    }

    public void setTgTime(Date tgTime)
    {
        this.tgTime = tgTime;
    }

    public String getInOut()
    {
        return inOut;
    }
    
    public void setInOut(String inOut)
    {
        this.inOut = inOut;
    }
    
    public String getUpFlag()
    {
        return upFlag;
    }
    
    public void setUpFlag(String upFlag)
    {
        this.upFlag = upFlag;
    }
    
    public String getUpDT()
    {
        return upDT;
    }
    
    public void setUpDT(String upDT)
    {
        this.upDT = upDT;
    }
    
    public String getBlReason()
    {
        return blReason;
    }
    
    public void setBlReason(String blReason)
    {
        this.blReason = blReason;
    }
    
    public String getBlDT()
    {
        return blDT;
    }
    
    public void setBlDT(String blDT)
    {
        this.blDT = blDT;
    }
    
    public String getBuluOper()
    {
        return buluOper;
    }
    
    public void setBuluOper(String buluOper)
    {
        this.buluOper = buluOper;
    }
    
    public String getCapturePhotoPath_Front()
    {
        return capturePhotoPath_Front;
    }
    
    public void setCapturePhotoPath_Front(String capturePhotoPath_Front)
    {
        this.capturePhotoPath_Front = capturePhotoPath_Front;
    }
    
    public String getCapturePhotoPath_Back()
    {
        return capturePhotoPath_Back;
    }
    
    public void setCapturePhotoPath_Back(String capturePhotoPath_Back)
    {
        this.capturePhotoPath_Back = capturePhotoPath_Back;
    }
    
    public String getPassRoomID()
    {
        return passRoomID;
    }
    
    public void setPassRoomID(String passRoomID)
    {
        this.passRoomID = passRoomID;
    }
    
    public String getCredNO1()
    {
        return credNO1;
    }
    
    public void setCredNO1(String credNO1)
    {
        this.credNO1 = credNO1;
    }
    
    public String getDept()
    {
        return dept;
    }
    
    public void setDept(String dept)
    {
        this.dept = dept;
    }
    
    public String getPdept()
    {
        return pdept;
    }

    public void setPdept(String pdept)
    {
        this.pdept = pdept;
    }

    public String getPiMobilePhone1()
    {
        return piMobilePhone1;
    }

    public void setPiMobilePhone1(String piMobilePhone1)
    {
        this.piMobilePhone1 = piMobilePhone1;
    }

    public String getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }

    @Override
    public String toString()
    {
        return "TaideChannelRecordInfo [tgID=" + tgID + ", client=" + client + ", channel=" + channel + ", perInfo="
            + perInfo + ", dept=" + dept + ", pdept=" + pdept + ", credNO1=" + credNO1 + ", serialNo=" + serialNo
            + ", tgStatus=" + tgStatus + ", tgTime=" + tgTime + ", inOut=" + inOut + ", upFlag=" + upFlag + ", upDT="
            + upDT + ", blReason=" + blReason + ", blDT=" + blDT + ", buluOper=" + buluOper
            + ", capturePhotoPath_Front=" + capturePhotoPath_Front + ", capturePhotoPath_Back=" + capturePhotoPath_Back
            + ", passRoomID=" + passRoomID + ", piMobilePhone1=" + piMobilePhone1 + ", pageSize=" + pageSize + "]";
    }
}
