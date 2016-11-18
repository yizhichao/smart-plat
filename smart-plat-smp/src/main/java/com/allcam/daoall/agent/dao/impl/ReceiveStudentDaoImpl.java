package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.ReceiveStudentDao;
import com.allcam.pojo.ReceiveStudentInfo;

@Repository
public class ReceiveStudentDaoImpl extends BaseDao<Object> implements ReceiveStudentDao
{
    
    public static final Log LOG = LogFactory.getLog(ReceiveStudentDaoImpl.class);
    
    @Override
    public int addReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("ReceiveStudentInfo.addReceiveStudentInfo", receiveStudentInfo);
        }
        catch (Exception e)
        {
            LOG.error("ReceiveStudentDaoImpl.addReceiveStudentInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<ReceiveStudentInfo> getReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo)
    {
        return getSqlSession().selectList("ReceiveStudentInfo.queryReceiveStudentInfo", receiveStudentInfo);
    }
    
    @Override
    public int modReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ReceiveStudentInfo.modReceiveStudentInfo", receiveStudentInfo);
        }
        catch (Exception e)
        {
            LOG.error("ReceiveStudentDaoImpl.updateReceiveStudentInfo Error....", e);
        }
        return k;
    }
}
