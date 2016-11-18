package com.allcam.pojo;

public class TaskInfo
{
    private String deviceId;
    
    private String taskId;
    
    private String taskValue;
    
    private String taskName;
    
    private String taskData;
    
    private String taskServerUrl;
    
    private String createDate;
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getTaskId()
    {
        return taskId;
    }
    
    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }
    
    public String getTaskValue()
    {
        return taskValue;
    }
    
    public void setTaskValue(String taskValue)
    {
        this.taskValue = taskValue;
    }
    
    public String getTaskName()
    {
        return taskName;
    }
    
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
    
    public String getTaskData()
    {
        return taskData;
    }
    
    public void setTaskData(String taskData)
    {
        this.taskData = taskData;
    }
    
    public String getTaskServerUrl()
    {
        return taskServerUrl;
    }
    
    public void setTaskServerUrl(String taskServerUrl)
    {
        this.taskServerUrl = taskServerUrl;
    }
    
    public String getCreateDate()
    {
        return createDate;
    }
    
    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }
    
    public String[] values()
    {
        String[] arr = {this.taskId, this.taskValue, this.createDate};
        return arr;
    }
    
    @Override
    public String toString()
    {
        return "TaskInfo [deviceId=" + deviceId + ", taskId=" + taskId + ", taskValue=" + taskValue + ", taskName="
            + taskName + ", taskData=" + taskData + ", taskServerUrl=" + taskServerUrl + ", createDate=" + createDate
            + "]";
    }
    
}
