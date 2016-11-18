package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.NurSeryTaideMapDao;
import com.allcam.pojo.NurSeryTaideMapInfo;
import com.allcam.pojo.PersonFailResendInfo;

@Repository
public class NurSeryTaideMapDaoImpl extends BaseDao<Object> implements NurSeryTaideMapDao
{
    
    public static final Log LOG = LogFactory.getLog(NurSeryTaideMapDaoImpl.class);
    
    @Override
    public List<NurSeryTaideMapInfo> queryNurSeryTaideMap(NurSeryTaideMapInfo nurSeryTaideMapInfo)
    {
        return getSqlSession().selectList("NurSeryTaideMapInfo.querySchoolInfoList", nurSeryTaideMapInfo);
    }

    @Override
    public void modNurSeryTaideMap(NurSeryTaideMapInfo nurSeryTaideMapInfo)
    {
        getSqlSession().update("NurSeryTaideMapInfo.modNurSeryTaideMap", nurSeryTaideMapInfo);
    }
}
