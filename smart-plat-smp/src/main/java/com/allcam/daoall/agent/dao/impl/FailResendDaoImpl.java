package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.FailResendDao;
import com.allcam.pojo.PersonFailResendInfo;

@Repository
public class FailResendDaoImpl extends BaseDao<Object> implements FailResendDao
{
    
    public static final Log LOG = LogFactory.getLog(FailResendDaoImpl.class);
    
    @Override
    public List<PersonFailResendInfo> queryPersonFailResendInfo(PersonFailResendInfo personFailResendInfo)
    {
        return getSqlSession().selectList("PersonFailResendInfo.queryPersonFailResendInfo", personFailResendInfo);
    }
    
    @Override
    public void addPersonFailResendInfo(PersonFailResendInfo personFailResendInfo)
    {
        getSqlSession().update("PersonFailResendInfo.addPersonFailResendInfo", personFailResendInfo);
    }
    
    @Override
    public void modPersonFailResendInfo(PersonFailResendInfo personFailResendInfo)
    {
        getSqlSession().update("PersonFailResendInfo.modPersonFailResendInfo", personFailResendInfo);
    }
    
    @Override
    public void delPersonFailResendInfo(PersonFailResendInfo personFailResendInfo)
    {
        getSqlSession().update("PersonFailResendInfo.delPersonFailResendInfo", personFailResendInfo);
    }
    
}
