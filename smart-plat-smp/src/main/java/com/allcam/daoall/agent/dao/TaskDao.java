package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.TaskInfo;

public interface TaskDao
{
    
    public int addTaskInfo(TaskInfo taskInfo);
    
    public List<TaskInfo> getTaskInfo(TaskInfo taskInfo);
    
    public int modTaskInfo(TaskInfo taskInfo);
    
}
