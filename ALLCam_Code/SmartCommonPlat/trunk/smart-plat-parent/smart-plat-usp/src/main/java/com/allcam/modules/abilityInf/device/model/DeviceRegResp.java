package com.allcam.modules.abilityInf.device.model;

import java.util.List;

import com.allcam.modules.bean.bpm.ResponseInfo;
import com.allcam.pojo.TaskInfo;
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
public class DeviceRegResp extends ResponseInfo
{
    private String schoolId;
    
    private String schoolName;
    
    private String deviceId;
    
    private List<TaskInfo> taskList;
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
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
    
    public List<TaskInfo> getTaskList()
    {
        return taskList;
    }

    public void setTaskList(List<TaskInfo> taskList)
    {
        this.taskList = taskList;
    }

    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
