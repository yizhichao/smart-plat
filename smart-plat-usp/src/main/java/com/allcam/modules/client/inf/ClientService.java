package com.allcam.modules.client.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.client.model.ClientInfo;

public interface ClientService
{
    public boolean addClient(ClientInfo clientInfo);
    
    public boolean modClient(ClientInfo clientInfo);
    
    public boolean delClient(ClientInfo clientInfo);
    
    public ClientInfo queryClientInfoByClientId(String clientId);
    
    public List<ClientInfo> queryClientInfoListByPage(Map<String, Object> map);
    
    List<ClientInfo> queryClientInfoList(Map<String, Object> map)
        throws Exception;
    
    int queryClientInfoTotal(Map<String, Object> map)
        throws Exception;
}
