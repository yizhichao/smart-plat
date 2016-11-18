package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.modules.plat.model.PlatInfo;

/**
 * 
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yizhichao
 * @version [版本号, 2016年7月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PlatDao
{
    int addPlatInfo(PlatInfo PlatInfo);
    
    int modPlatInfo(PlatInfo PlatInfo);
    
    int delPlatInfo(PlatInfo PlatInfo);
    
    List<PlatInfo> queryPlatInfoListByCer(Map<String, Object> map);
    
    List<PlatInfo> queryPlatInfoListByPage(Map<String, Object> map);
    
    List<PlatInfo> searchPlatInfo(Map<String, Object> map);
    
    PlatInfo getPlatInfo(Map<String, Object> map);
    
    public List<PlatInfo> queryPlatInfoList(Map<String, Object> map);
    
    public int queryPlatInfoTotal(Map<String, Object> map);
}
