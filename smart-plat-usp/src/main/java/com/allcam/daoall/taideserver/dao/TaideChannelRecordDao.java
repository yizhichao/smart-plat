package com.allcam.daoall.taideserver.dao;

import java.util.List;

import com.allcam.pojo.TaideChannelRecordInfo;

public interface TaideChannelRecordDao
{
    public List<TaideChannelRecordInfo> getChannelRecordInfo(TaideChannelRecordInfo taideChannelRecordInfo);
}
