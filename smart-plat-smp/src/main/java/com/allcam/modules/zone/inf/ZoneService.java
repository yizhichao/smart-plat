package com.allcam.modules.zone.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.zone.model.ZoneInfo;

public interface ZoneService
{
    public boolean addArea(ZoneInfo zoneInfo);
    
    public boolean modArea(ZoneInfo zoneInfo);
    
    public boolean delArea(ZoneInfo zoneInfo);
    
    public List<ZoneInfo> queryZoneInfoListByPage(Map<String, Object> map);
    
    public ZoneInfo queryZoneInfoByZoneId(String zoneId);
}
