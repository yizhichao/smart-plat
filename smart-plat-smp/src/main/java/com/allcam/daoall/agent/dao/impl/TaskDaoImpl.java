package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.TaskDao;
import com.allcam.pojo.TaskInfo;

@Repository
public class TaskDaoImpl extends BaseDao<Object> implements TaskDao
{
    
    public static final Log LOG = LogFactory.getLog(TaskDaoImpl.class);
    
    @Override
    public int addTaskInfo(TaskInfo taskInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("TaskInfo.addTaskInfo", taskInfo);
        }
        catch (Exception e)
        {
            LOG.error("TaskDaoImpl.addTaskInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<TaskInfo> getTaskInfo(TaskInfo taskInfo)
    {
        return getSqlSession().selectList("TaskInfo.queryTaskInfo", taskInfo);
    }
    
    @Override
    public int modTaskInfo(TaskInfo taskInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("TaskInfo.modTaskInfo", taskInfo);
        }
        catch (Exception e)
        {
            LOG.error("TaskDaoImpl.updateTaskInfo Error....", e);
        }
        return k;
    }
}
