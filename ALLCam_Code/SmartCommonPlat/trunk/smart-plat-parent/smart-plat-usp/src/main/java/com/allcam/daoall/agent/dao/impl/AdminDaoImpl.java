package com.allcam.daoall.agent.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.AdminDao;
import com.allcam.modules.admin.model.AdminInfo;

@Repository
public class AdminDaoImpl extends BaseDao<Object> implements AdminDao
{

    public static final Log LOG = LogFactory.getLog(AdminDaoImpl.class);
    
    @Override
    public AdminInfo getAdminInfo(AdminInfo adminInfo)
    {
        return getSqlSession().selectOne("AdminInfo.queryAdminInfo", adminInfo);
    }
}
