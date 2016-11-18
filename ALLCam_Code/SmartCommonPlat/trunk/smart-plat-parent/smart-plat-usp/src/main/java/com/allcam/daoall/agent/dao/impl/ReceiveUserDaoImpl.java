package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.ReceiveUserDao;
import com.allcam.pojo.ReceiveUserInfo;

@Repository
public class ReceiveUserDaoImpl extends BaseDao<Object> implements ReceiveUserDao
{
    
    public static final Log LOG = LogFactory.getLog(ReceiveUserDaoImpl.class);
    
    @Override
    public int addReceiveUserInfo(ReceiveUserInfo receiveUserInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("ReceiveUserInfo.addReceiveUserInfo", receiveUserInfo);
        }
        catch (Exception e)
        {
            LOG.error("ReceiveUserDaoImpl.addReceiveUserInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<ReceiveUserInfo> getReceiveUserInfo(ReceiveUserInfo receiveUserInfo)
    {
        return getSqlSession().selectList("ReceiveUserInfo.queryReceiveUserInfo", receiveUserInfo);
    }
    
    @Override
    public int modReceiveUserInfo(ReceiveUserInfo receiveUserInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ReceiveUserInfo.modReceiveUserInfo", receiveUserInfo);
        }
        catch (Exception e)
        {
            LOG.error("ReceiveUserDaoImpl.updateReceiveUserInfo Error....", e);
        }
        return k;
    }
}
