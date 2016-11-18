package com.allcam.modules.client.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;

public class ClientInfo extends BaseInfo implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 929594891447143585L;
    
    private int id;
    
    private String zoneId;
    
    private String zoneName;
    
    private String clientId;
    
    private String clientName;
    
    private String status;
    
    private String clientType;
    
    private String postCode;
    
    private String address;
    
    private String email;
    
    private String phone;
    
    private String fax;
    
    private String remark;
    
    private String createDate;
    
    private String lastDate;
    
    private String passWord;
    
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
    
    public String getClientId()
    {
        return clientId;
    }
    
    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }
    
    public String getClientName()
    {
        return clientName;
    }
    
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getClientType()
    {
        return clientType;
    }
    
    public void setClientType(String clientType)
    {
        this.clientType = clientType;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
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
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getFax()
    {
        return fax;
    }
    
    public void setFax(String fax)
    {
        this.fax = fax;
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
    
    public String getPassWord()
    {
        return passWord;
    }
    
    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }
    
    public String[] values()
    {
        String[] arr =
            {this.clientName, this.clientType, this.postCode, this.address, this.email, this.phone, this.fax,
                this.status, this.remark, this.lastDate, this.createDate, this.zoneId, this.zoneName, this.passWord};
        return arr;
    }
    
    @Override
    public String toString()
    {
        return "ClientInfo [id=" + id + ", zoneId=" + zoneId + ", zoneName=" + zoneName + ", clientId=" + clientId
            + ", clientName=" + clientName + ", status=" + status + ", clientType=" + clientType + ", postCode="
            + postCode + ", address=" + address + ", email=" + email + ", phone=" + phone + ", fax=" + fax
            + ", remark=" + remark + ", createDate=" + createDate + ", lastDate=" + lastDate + ", passWord=" + passWord
            + "]";
    }
}
