package com.allcam.modules.plat.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.PlatDao;
import com.allcam.modules.plat.inf.PlatService;
import com.allcam.modules.plat.model.PlatInfo;
import com.allcam.utils.DateUtil;

@Service
public class PlatServiceImpl implements PlatService
{
    @Resource
    PlatDao platDao;
    
    @Override
    public boolean addPlat(PlatInfo platInfo)
    {
        String dateTime = DateUtil.formatTime(new Date(), DateUtil.DATE_19);
        platInfo.setCreateDate(dateTime);
        platInfo.setLastDate(dateTime);
        platInfo.setStatus("1");
        if (0 < platDao.addPlatInfo(platInfo))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean modPlat(PlatInfo PlatInfo)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean delPlat(PlatInfo PlatInfo)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public PlatInfo queryPlatInfoByPlatId(String platId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PlatInfo> queryPlatInfoListByPage(Map<String, Object> map)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PlatInfo> queryPlatInfoList(Map<String, Object> map)
        throws Exception
    {
        return platDao.queryPlatInfoList(map);
    }

    @Override
    public int queryPlatInfoTotal(Map<String, Object> map)
        throws Exception
    {
        return platDao.queryPlatInfoTotal(map);
    }
    
}
