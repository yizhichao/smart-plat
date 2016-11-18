package com.allcam.modules.admin.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;
import com.allcam.pojo.POJO;

/**
 * 管理员实体类
 * tbl_sys_admin
 * @author marui
 * 
 */
public class AdminInfo extends BaseInfo implements Serializable
{
    /**
     * 序列号
     */
    private static final long serialVersionUID = 3473917279640699152L;
    
    private int id;
    
    private String adminId;
    
    private String username;
    
    private String password;
    
    private String adminDesc;
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getAdminId()
    {
        return adminId;
    }
    
    public void setAdminId(String adminId)
    {
        this.adminId = adminId;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getAdminDesc()
    {
        return adminDesc;
    }
    
    public void setAdminDesc(String adminDesc)
    {
        this.adminDesc = adminDesc;
    }
    
}
