package com.allcam.daoall.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.AdsDao;
import com.allcam.pojo.AdsInfo;

@Repository
public class AdsDaoImpl extends BaseDao<Object> implements AdsDao
{
    
    public static final Log LOG = LogFactory.getLog(AdsDaoImpl.class);
    
    @Override
    public List<AdsInfo> queryAdsInfo(Map<String, Object> map)
    {
        return getSqlSession().selectList("AdsInfo.queryAdsInfo", map);
    }
}
