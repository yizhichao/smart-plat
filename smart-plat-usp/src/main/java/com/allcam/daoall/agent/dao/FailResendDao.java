package com.allcam.daoall.agent.dao;

import java.util.List;

import com.allcam.pojo.PersonFailResendInfo;

public interface FailResendDao
{
    public List<PersonFailResendInfo> queryPersonFailResendInfo(PersonFailResendInfo personFailResendInfo);
    
    public void addPersonFailResendInfo(PersonFailResendInfo personFailResendInfo);
    
    public void modPersonFailResendInfo(PersonFailResendInfo personFailResendInfo);
    
    public void delPersonFailResendInfo(PersonFailResendInfo personFailResendInfo);
}
