package com.allcam.pojo;

import java.io.Serializable;

import com.allcam.utils.Tools;

/**
 * 用户实体类
 * 
 * @author marui
 * @version [版本号, Jul 10, 2015]
 */
public class UserInfo implements Serializable
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 5729754358787539200L;
    
    /**
     * 考勤卡ID
     */
    private String cardId;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 登录名
     */
    private String loginName;
    
    /**
     * 最后登录时间
     */
    private String lastTime;
    
    /**
     * 角色编号
     */
    private String roleId;
    
    /**
     * 组织结构ID
     */
    private String organizationId;
    
    /**
     * 学校ID
     */
    private String schoolId;
    
    /**
     * 学校名称
     */
    private String schoolName;
    
    /**
     * 姓名
     */
    private String userName;
    
    /**
     * 姓名对应的拼音
     */
    private String userNamePinYin;
    
    /**
     * 用户唯一代号（例如：工号，身份证号码）
     */
    private String userCode;
    
    /**
     * 手机号码
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
     * 邮箱
     */
    private String email;
    
    /**
     * 性别。0: 男 1: 女 2: 保密
     */
    private String sex;
    
    /**
     * 生日
     */
    private String birthday;
    
    /**
     * QQ
     */
    private String qq;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 家庭住址
     */
    private String homeAddress;
    
    /**
     * 职位
     */
    private String position;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 用户账号类型 0. 普通帐号（字符串） 1. 手机号码 2. 邮箱 3. 微信号 4. QQ 5. 测试账号 公共账号（访客）
     */
    private String accType;
    
    /**
     * 状态 0：正常 1：停用
     */
    private String status;
    
    /**
     * 邮编
     */
    private String postCode;
    
    /**
     * 头像图片编码信息 base64编码
     */
    private String photo;
    
    /**
     * 其它号码1
     */
    private String otherNumber1;
    
    /**
     * 其它号码2
     */
    private String otherNumber2;
    
    /**
     * 是否在通讯录中显示,1显示 0不显示，默认为显示
     */
    private String isShow;
    
    /**
     * 所属的部门信息
     */
    private OrganizationInfo organizationInfo;
    
    private String deviceId;
    
    public String getCardId()
    {
        return cardId;
    }
    
    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }
    
    public String getIsShow()
    {
        return isShow;
    }
    
    public void setIsShow(String isShow)
    {
        this.isShow = isShow;
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
    
    public String getUserNamePinYin()
    {
        return userNamePinYin;
    }
    
    public String getOtherNumber1()
    {
        return otherNumber1;
    }
    
    public void setOtherNumber1(String otherNumber1)
    {
        this.otherNumber1 = otherNumber1;
    }
    
    public String getOtherNumber2()
    {
        return otherNumber2;
    }
    
    public void setOtherNumber2(String otherNumber2)
    {
        this.otherNumber2 = otherNumber2;
    }
    
    public void setUserNamePinYin(String userNamePinYin)
    {
        this.userNamePinYin = userNamePinYin;
    }
    
    public OrganizationInfo getOrganizationInfo()
    {
        return organizationInfo;
    }
    
    public void setOrganizationInfo(OrganizationInfo organizationInfo)
    {
        this.organizationInfo = organizationInfo;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getLoginName()
    {
        return loginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }
    
    public String getLastTime()
    {
        return lastTime;
    }
    
    public void setLastTime(String lastTime)
    {
        this.lastTime = lastTime;
    }
    
    public String getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    public String getOrganizationId()
    {
        return organizationId;
    }
    
    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getUserCode()
    {
        return userCode;
    }
    
    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
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
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getBirthday()
    {
        return birthday;
    }
    
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
    
    public String getQq()
    {
        return qq;
    }
    
    public void setQq(String qq)
    {
        this.qq = qq;
    }
    
    public String getNickName()
    {
        return nickName;
    }
    
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }
    
    public String getHomeAddress()
    {
        return homeAddress;
    }
    
    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String[] chooseUserValues()
    {
        String[] arr =
            {this.cardId, this.userName, this.schoolName, this.phone, this.userCode, this.sex,
                this.userId};
        return arr;
    }
    
    public String[] values()
    {
        String[] arr =
            {this.cardId, this.userName, this.userCode, this.phone, this.shortPhone, this.fixedPhone, this.email,
                this.sex, this.birthday, this.nickName, this.qq, this.homeAddress, this.schoolName, this.position,
                this.lastTime};
        return arr;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
    
}
