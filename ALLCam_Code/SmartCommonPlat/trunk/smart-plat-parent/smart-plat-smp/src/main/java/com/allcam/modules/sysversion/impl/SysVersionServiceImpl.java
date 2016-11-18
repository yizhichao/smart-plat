package com.allcam.modules.sysversion.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.UserDao;
import com.allcam.modules.sysversion.inf.SysVersionService;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class SysVersionServiceImpl implements SysVersionService
{
    @Resource
    private UserDao userDao;
    
}
