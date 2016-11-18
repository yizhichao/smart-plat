package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.ReceiveStudentInfo;

public interface ReceiveStudentDao
{
    
    public int addReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo);
    
    public List<ReceiveStudentInfo> getReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo);
    
    public int modReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo);
    
}
