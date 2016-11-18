package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.ClientDao;
import com.allcam.modules.client.model.ClientInfo;

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
public class ClientDaoImpl extends BaseDao<Object> implements ClientDao
{
    public static final Log LOG = LogFactory.getLog(ClientDaoImpl.class);
    
    @Override
    public int addClientInfo(ClientInfo ClientInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("ClientInfo.addClientInfo", ClientInfo);
        }
        catch (Exception e)
        {
            LOG.error("ClientDaoImpl.addClientInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int modClientInfo(ClientInfo ClientInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ClientInfo.modClientInfo", ClientInfo);
        }
        catch (Exception e)
        {
            LOG.error("ClientDaoImpl.modClientInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public int delClientInfo(ClientInfo ClientInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("ClientInfo.delClientInfo", ClientInfo);
        }
        catch (Exception e)
        {
            LOG.error("ClientDaoImpl.delClientInfo Error....", e);
        }
        return k;
    }
    
    @Override
    public List<ClientInfo> queryClientInfoListByCer(Map<String, Object> map)
    {
        List<ClientInfo> resourceList = new ArrayList<ClientInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ClientInfo.queryClientInfoListByCer", map);
        }
        catch (Exception e)
        {
            LOG.error("ClientInfo.queryClientInfoListByCer Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<ClientInfo> queryClientInfoListByPage(Map<String, Object> map)
    {
        List<ClientInfo> resourceList = new ArrayList<ClientInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ClientInfo.queryClientInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("ClientInfo.queryClientInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public List<ClientInfo> searchClientInfo(Map<String, Object> map)
    {
        List<ClientInfo> resourceList = new ArrayList<ClientInfo>();
        try
        {
            resourceList = getSqlSession().selectList("ClientInfo.queryClientInfoListByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("ClientInfo.queryClientInfoListByPage Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public ClientInfo getClientInfo(Map<String, Object> map)
    {
        ClientInfo resourceList = null;
        try
        {
            resourceList = getSqlSession().selectOne("ClientInfo.getClientInfo", map);
        }
        catch (Exception e)
        {
            LOG.error("ClientInfo.getClientInfo Error...", e);
        }
        return resourceList;
    }
    
    @Override
    public int queryClientInfoTotal(Map<String, Object> map)
    {
        return getSqlSession().selectOne("ClientInfo.queryClientInfoTotal", map);
    }
    
    @Override
    public List<ClientInfo> queryClientInfoList(Map<String, Object> map)
    {
        List<ClientInfo> resourceList = null;
        try
        {
            resourceList = getSqlSession().selectList("ClientInfo.queryClientInfoList", map);
        }
        catch (Exception e)
        {
            LOG.error("ClientInfo.queryClientInfoList Error...", e);
        }
        return resourceList;
    }
}
