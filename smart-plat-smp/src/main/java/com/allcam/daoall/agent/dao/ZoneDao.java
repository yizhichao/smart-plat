package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.modules.zone.model.ZoneInfo;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yizhichao
 * @version [版本号, 2016年7月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ZoneDao
{
    int addZoneInfo(ZoneInfo ZoneInfo);
    
    int modZoneInfo(ZoneInfo ZoneInfo);
    
    int delZoneInfo(ZoneInfo ZoneInfo);
    
    List<ZoneInfo> queryZoneInfoListByCer(Map<String, Object> map);
    
    List<ZoneInfo> queryZoneInfoListByPage(Map<String, Object> map);
    
    List<ZoneInfo> searchZoneInfo(Map<String, Object> map);
    
    ZoneInfo getZoneInfo(Map<String, Object> map);
}
