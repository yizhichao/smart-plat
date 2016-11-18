package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.AdsInfo;

public interface AdsDao
{
    public List<AdsInfo> queryAdsInfo(Map<String, Object> map);
}
