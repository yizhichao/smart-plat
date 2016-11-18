package com.allcam.modules.admin.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.AdminDao;
import com.allcam.modules.admin.inf.AdminService;
import com.allcam.modules.admin.model.AdminInfo;
import com.allcam.log.SystemServiceLog;

/**
 * 管理员相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-10-15]
 */
@Service
public class AdminServiceImpl implements AdminService
{
    @Resource
    private AdminDao adminDao;
    
    /**
     * 用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * 
     * @return AdminInfo 管理员信息
     */
    @SystemServiceLog(description = "获取管理员信息")
    public AdminInfo getAdminInfo(String username, String password)
        throws Exception
    {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setUsername(username);
        adminInfo.setPassword(password);
        AdminInfo result = adminDao.getAdminInfo(adminInfo);
        return result;
    }
    
}
