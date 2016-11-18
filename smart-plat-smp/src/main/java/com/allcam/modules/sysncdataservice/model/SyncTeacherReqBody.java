package com.allcam.modules.sysncdataservice.model;

import com.allcam.utils.SystemUtil;

/**
 * 同步老师的请求的主体对象
 * 
 * @author  marui
 * @version  [版本号, Aug 28, 2015]
 */
public class SyncTeacherReqBody
{
    /**
     * BDGW(考勤系统)
     */
    private String sysType = "1";
    
    /**
     * BDGW令牌
     */
    private String sysKey = SystemUtil.getBDGWKey();
    
    /**
     * 学校ID 指定学校获取
     */
    private String schoolId;
    
    /**
     * 可选  可以指定用户获取
     */
    private String userId;
    
    /**
     * 可选  可以根据用户模糊匹配
     */
    private String userName;
    
    /**
     * 分页查询-当前页 默认 1
     */
    private String pageNo;
    
    /**
     * 分页查询-页大小 默认 100
     */
    private String pageSize;
    
    public String getSysType()
    {
        return sysType;
    }

    public void setSysType(String sysType)
    {
        this.sysType = sysType;
    }

    public String getSysKey()
    {
        return sysKey;
    }

    public void setSysKey(String sysKey)
    {
        this.sysKey = sysKey;
    }

    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(String pageNo)
    {
        this.pageNo = pageNo;
    }
    
    public String getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(String pageSize)
    {
        this.pageSize = pageSize;
    }
}
