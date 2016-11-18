package com.allcam.modules.plat.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.plat.model.PlatInfo;

public interface PlatService
{
    public boolean addPlat(PlatInfo PlatInfo);
    
    public boolean modPlat(PlatInfo PlatInfo);
    
    public boolean delPlat(PlatInfo PlatInfo);

    public PlatInfo queryPlatInfoByPlatId(String platId);

    public List<PlatInfo> queryPlatInfoListByPage(Map<String, Object> map);
    
    List<PlatInfo> queryPlatInfoList(Map<String, Object> map)
        throws Exception;
    
    int queryPlatInfoTotal(Map<String, Object> map)
        throws Exception;
}
