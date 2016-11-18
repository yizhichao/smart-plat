package com.allcam.modules.client.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.ClientDao;
import com.allcam.log.SystemServiceLog;
import com.allcam.modules.client.inf.ClientService;
import com.allcam.modules.client.model.ClientInfo;
import com.allcam.utils.DateUtil;

@Service
public class ClientServiceImpl implements ClientService
{
    @Resource
    ClientDao clientDao;
    
    @Override
    @SystemServiceLog ( description = "res.addClient")
    public boolean addClient(ClientInfo ClientInfo)
    {
        String dateTime = DateUtil.formatTime(new Date(), DateUtil.DATE_19);
        ClientInfo.setCreateDate(dateTime);
        ClientInfo.setLastDate(dateTime);
        ClientInfo.setStatus("1");
        if (0 < clientDao.addClientInfo(ClientInfo))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean modClient(ClientInfo ClientInfo)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean delClient(ClientInfo ClientInfo)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ClientInfo queryClientInfoByClientId(String ClientId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ClientInfo> queryClientInfoListByPage(Map<String, Object> map)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ClientInfo> queryClientInfoList(Map<String, Object> map)
        throws Exception
    {
        return clientDao.queryClientInfoList(map);
    }

    @Override
    public int queryClientInfoTotal(Map<String, Object> map)
        throws Exception
    {
        return clientDao.queryClientInfoTotal(map);
    }
    
}
