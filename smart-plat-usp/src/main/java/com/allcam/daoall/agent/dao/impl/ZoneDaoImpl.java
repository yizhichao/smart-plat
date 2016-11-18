package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.ZoneDao;
import com.allcam.modules.zone.model.ZoneInfo;

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
public class ZoneDaoImpl extends BaseDao<Object> implements ZoneDao
{
    public static final Log LOG = LogFactory.getLog(ZoneDaoImpl.class);
    
    @Override
    public int addZoneInfo(ZoneInfo ZoneInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("ZoneInfo.addZoneInfo", ZoneInfo);
        }
        catch (Exception e)
        {
            LOG.error("ZoneDaoImpl.addZoneInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int modZoneInfo(ZoneInfo ZoneInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ZoneInfo.modZoneInfo", ZoneInfo);
        }
        catch (Exception e)
        {
            LOG.error("ZoneDaoImpl.modZoneInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int delZoneInfo(ZoneInfo ZoneInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ZoneInfo.delZoneInfo", ZoneInfo);
        }
        catch (Exception e)
        {
            LOG.error("ZoneDaoImpl.delZoneInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<ZoneInfo> queryZoneInfoListByCer(Map<String, Object> map)
    {
        List<ZoneInfo> resourceList = new ArrayList<ZoneInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ZoneInfo.queryZoneInfoListByCer", map);
        }
        catch (Exception e)
        {
            LOG.error("ZoneInfo.queryZoneInfoListByCer Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<ZoneInfo> queryZoneInfoListByPage(Map<String, Object> map)
    {
        List<ZoneInfo> resourceList = new ArrayList<ZoneInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ZoneInfo.queryZoneInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("ZoneInfo.queryZoneInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<ZoneInfo> searchZoneInfo(Map<String, Object> map)
    {
        List<ZoneInfo> resourceList = new ArrayList<ZoneInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ZoneInfo.queryZoneInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("ZoneInfo.queryZoneInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public ZoneInfo getZoneInfo(Map<String, Object> map)
    {
        ZoneInfo resourceList = null;
        try
        {
            resourceList = getSqlSession().selectOne("ZoneInfo.getZoneInfo", map);
        }
        catch (Exception e)
        {
            LOG.error("ZoneInfo.getZoneInfo Error...", e);
        }
        return resourceList;
    }
}
