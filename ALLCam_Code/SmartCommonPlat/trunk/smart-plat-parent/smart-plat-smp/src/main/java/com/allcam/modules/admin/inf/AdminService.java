package com.allcam.modules.admin.inf;

import com.allcam.modules.admin.model.AdminInfo;

/**
 * 管理员相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-10-15]
 */
public interface AdminService
{
    /**
     * 用户登录
     * 
     * @param username 用户名
     * @param password 密码
     * 
     * @return AdminInfo 管理员信息
     */
    AdminInfo getAdminInfo(String username, String password)
        throws Exception;
    
}
