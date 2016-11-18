package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.PlatDao;
import com.allcam.modules.plat.model.PlatInfo;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yizhichao
 * @version [版本号, 2016年7月4日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Repository
public class PlatDaoImpl extends BaseDao<Object> implements PlatDao
{
    public static final Log LOG = LogFactory.getLog(PlatDaoImpl.class);
    
    @Override
    public int addPlatInfo(PlatInfo PlatInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("PlatInfo.addPlatInfo", PlatInfo);
        }
        catch (Exception e)
        {
            LOG.error("PlatDaoImpl.addPlatInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int modPlatInfo(PlatInfo PlatInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("PlatInfo.modPlatInfo", PlatInfo);
        }
        catch (Exception e)
        {
            LOG.error("PlatDaoImpl.modPlatInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int delPlatInfo(PlatInfo PlatInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("PlatInfo.delPlatInfo", PlatInfo);
        }
        catch (Exception e)
        {
            LOG.error("PlatDaoImpl.delPlatInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<PlatInfo> queryPlatInfoListByCer(Map<String, Object> map)
    {
        List<PlatInfo> resourceList = new ArrayList<PlatInfo>();
        try
        {
            resourceList = getSqlSession().selectList("PlatInfo.queryPlatInfoListByCer", map);
        }
        catch (Exception e)
        {
            LOG.error("PlatInfo.queryPlatInfoListByCer Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<PlatInfo> queryPlatInfoListByPage(Map<String, Object> map)
    {
        List<PlatInfo> resourceList = new ArrayList<PlatInfo>();
        try
        {
            resourceList = getSqlSession().selectList("PlatInfo.queryPlatInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("PlatInfo.queryPlatInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<PlatInfo> searchPlatInfo(Map<String, Object> map)
    {
        List<PlatInfo> resourceList = new ArrayList<PlatInfo>();
        try
        {
            resourceList = getSqlSession().selectList("PlatInfo.queryPlatInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("PlatInfo.queryPlatInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public PlatInfo getPlatInfo(Map<String, Object> map)
    {
        PlatInfo resourceList = null;
        try
        {
            resourceList = getSqlSession().selectOne("PlatInfo.getPlatInfo", map);
        }
        catch (Exception e)
        {
            LOG.error("PlatInfo.getPlatInfo Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public int queryPlatInfoTotal(Map<String, Object> map)
    {
        return getSqlSession().selectOne("PlatInfo.queryPlatInfoTotal", map);
    }
    
    @Override
    public List<PlatInfo> queryPlatInfoList(Map<String, Object> map)
    {
        List<PlatInfo> resourceList = null;
        try
        {
            resourceList = getSqlSession().selectList("PlatInfo.queryPlatInfoList", map);
        }
        catch (Exception e)
        {
            LOG.error("PlatInfo.queryPlatInfoList Error...", e);
        }
        return resourceList;
    }
}
