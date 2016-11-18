package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.ReceiveUserInfo;

public interface ReceiveUserDao
{
    
    public int addReceiveUserInfo(ReceiveUserInfo receiveUserInfo);
    
    public List<ReceiveUserInfo> getReceiveUserInfo(ReceiveUserInfo receiveUserInfo);
    
    public int modReceiveUserInfo(ReceiveUserInfo receiveUserInfo);
    
}
