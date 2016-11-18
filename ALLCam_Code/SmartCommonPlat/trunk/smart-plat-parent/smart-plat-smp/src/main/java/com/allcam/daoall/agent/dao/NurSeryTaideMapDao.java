package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.NurSeryTaideMapInfo;
import com.allcam.pojo.PersonFailResendInfo;

public interface NurSeryTaideMapDao
{
    public List<NurSeryTaideMapInfo> queryNurSeryTaideMap(NurSeryTaideMapInfo nurSeryTaideMapInfo);
    
    public void modNurSeryTaideMap(NurSeryTaideMapInfo nurSeryTaideMapInfo);
}
