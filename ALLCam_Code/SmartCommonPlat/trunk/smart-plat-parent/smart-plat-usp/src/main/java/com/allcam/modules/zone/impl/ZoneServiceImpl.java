package com.allcam.modules.zone.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.ZoneDao;
import com.allcam.modules.zone.inf.ZoneService;
import com.allcam.modules.zone.model.ZoneInfo;
import com.allcam.utils.DateUtil;

@Service
public class ZoneServiceImpl implements ZoneService
{
    
    @Resource
    ZoneDao zoneDao;
    
    @Override
    public boolean addArea(ZoneInfo zoneInfo)
    {
        String dateTime = DateUtil.formatTime(new Date(), DateUtil.DATE_19);
        zoneInfo.setCreateDate(dateTime);
        zoneInfo.setLastDate(dateTime);
        zoneInfo.setStatus(1);
        if (0 < zoneDao.addZoneInfo(zoneInfo))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean modArea(ZoneInfo zoneInfo)
    {
        String dateTime = DateUtil.formatTime(new Date(), DateUtil.DATE_19);
        zoneInfo.setLastDate(dateTime);
        if (0 < zoneDao.modZoneInfo(zoneInfo))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean delArea(ZoneInfo zoneInfo)
    {
        if (0 < zoneDao.delZoneInfo(zoneInfo))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public List<ZoneInfo> queryZoneInfoListByPage(Map<String, Object> map)
    {
        return zoneDao.queryZoneInfoListByPage(map);
    }
    
    @Override
    public ZoneInfo queryZoneInfoByZoneId(String zoneId)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zoneId", zoneId);
        return zoneDao.getZoneInfo(map);
    }
}
