package com.allcam.modules.sysncdataservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 同步老师接口主体对象中老师信息
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncTeacherInfo implements Serializable
{
    
    /**
     * 本类的序列号
     */
    private static final long serialVersionUID = 1879021968381565247L;
    
    private String cardId;
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 用户唯一代号（例如：工号，身份证号码）
     */
    private String userCode;
    
    /**
     * 用户姓名 / 登录名
     */
    private String userName;
    
    /**
     * 用户显示名
     */
    private String displayName;
    
    /**
     * 用户账号类型
     */
    private String accType;
    
    /**
     * 状态  0：正常 1：停用
     */
    private String status;
    
    /**
     * 性别   0：男 1：女
     */
    private String sex;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 用户手机号码
     */
    private String phone;
    
    /**
     * 手机短号
     */
    private String shortPhone;
    
    /**
     * 座机号码
     */
    private String fixedPhone;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 邮编
     */
    private String postCode;
    
    /**
     * 头像图片编码信息 base64编码
     */
    private String photo;
    
    public String getCardId()
    {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getShortPhone()
    {
        return shortPhone;
    }

    public void setShortPhone(String shortPhone)
    {
        this.shortPhone = shortPhone;
    }

    public String getFixedPhone()
    {
        return fixedPhone;
    }

    public void setFixedPhone(String fixedPhone)
    {
        this.fixedPhone = fixedPhone;
    }

    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getDisplayName()
    {
        return displayName;
    }
    
    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
    
    public String getAccType()
    {
        return accType;
    }
    
    public void setAccType(String accType)
    {
        this.accType = accType;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
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
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getPhoto()
    {
        return photo;
    }
    
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }
}
