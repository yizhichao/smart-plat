package com.allcam.daoall.agent.dao;

import java.util.Map;

import com.allcam.pojo.CuVersionInfo;

public interface CuVersionDao
{
    public CuVersionInfo queryCuVersionInfo(Map<String, Object> map);
}
