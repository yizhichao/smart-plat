package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.NurSeryBeiyangMapDao;
import com.allcam.pojo.NurSeryBeiyangMapInfo;

@Repository
public class NurSeryBeiyangMapDaoImpl extends BaseDao<Object> implements NurSeryBeiyangMapDao
{
    
    public static final Log LOG = LogFactory.getLog(NurSeryBeiyangMapDaoImpl.class);
    
    @Override
    public List<NurSeryBeiyangMapInfo> queryNurSeryBeiyangMap(NurSeryBeiyangMapInfo nurSeryBeiyangMapInfo)
    {
        return getSqlSession().selectList("NurSeryBeiyangMapInfo.querySchoolInfoList", nurSeryBeiyangMapInfo);
    }

    @Override
    public void modNurSeryBeiyangMap(NurSeryBeiyangMapInfo nurSeryBeiyangMapInfo)
    {
        getSqlSession().update("NurSeryBeiyangMapInfo.modNurSeryBeiyangMap", nurSeryBeiyangMapInfo);
    }
}
