package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.NurSeryBeiyangMapInfo;

public interface NurSeryBeiyangMapDao
{
    public List<NurSeryBeiyangMapInfo> queryNurSeryBeiyangMap(NurSeryBeiyangMapInfo nurSeryBeiyangMapInfo);

    public void modNurSeryBeiyangMap(NurSeryBeiyangMapInfo nurSeryBeiyangMapInfo);
}
