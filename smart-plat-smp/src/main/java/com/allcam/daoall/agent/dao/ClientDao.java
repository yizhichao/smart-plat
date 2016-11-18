package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.modules.client.model.ClientInfo;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yizhichao
 * @version [版本号, 2016年7月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ClientDao
{
    int addClientInfo(ClientInfo ClientInfo);
    
    int modClientInfo(ClientInfo ClientInfo);
    
    int delClientInfo(ClientInfo ClientInfo);
    
    List<ClientInfo> queryClientInfoListByCer(Map<String, Object> map);
    
    List<ClientInfo> queryClientInfoListByPage(Map<String, Object> map);
    
    List<ClientInfo> searchClientInfo(Map<String, Object> map);
    
    ClientInfo getClientInfo(Map<String, Object> map);
    
    public List<ClientInfo> queryClientInfoList(Map<String, Object> map);
    
    public int queryClientInfoTotal(Map<String, Object> map);
}
