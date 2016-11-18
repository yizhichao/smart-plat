package com.allcam.modules.abilityInf.user.model;

import java.util.List;

import com.allcam.modules.bean.PageInfo;
import com.allcam.modules.bean.bpm.ResponseInfo;
import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * 检查版本信息bean
 * 
 * @author YiZhichao
 * @version [版本号, 2014-10-18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "operations", "roles", "menus"})
public class DeviceSyncTeacherResp extends ResponseInfo
{
    private String schoolId;
    
    private String deviceId;
    
    private PageInfo pageInfo;
    
    private List<TeacherInfo> userList;
    
    private String taskServerUrl;
    
    public String getTaskServerUrl()
    {
        return taskServerUrl;
    }
    
    public void setTaskServerUrl(String taskServerUrl)
    {
        this.taskServerUrl = taskServerUrl;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public PageInfo getPageInfo()
    {
        return pageInfo;
    }
    
    public void setPageInfo(PageInfo pageInfo)
    {
        this.pageInfo = pageInfo;
    }
    
    public List<TeacherInfo> getUserList()
    {
        return userList;
    }
    
    public void setUserList(List<TeacherInfo> userList)
    {
        this.userList = userList;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
