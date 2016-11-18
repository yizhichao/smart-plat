package com.allcam.daoall.agent.dao.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.CuVersionDao;
import com.allcam.pojo.CuVersionInfo;

@Repository
public class CuVersionDaoImpl extends BaseDao<Object> implements CuVersionDao
{
    
    public static final Log LOG = LogFactory.getLog(CuVersionDaoImpl.class);
    
    @Override
    public CuVersionInfo queryCuVersionInfo(Map<String, Object> map)
    {
        return getSqlSession().selectOne("CuVersionInfo.queryCuVersionInfo", map);
    }
}
