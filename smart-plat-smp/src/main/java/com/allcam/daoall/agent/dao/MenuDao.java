package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.modules.menu.model.MenuInfo;

/**
 * 菜单相关的数据库接口层
 * 
 * @author  marui
 * @version  [版本号, Jul 4, 2015]
 */
public interface MenuDao
{
    /**
     * 查询所有的菜单
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    List<MenuInfo> queryAllMenuInfo();
    
    /**
     * 查询用户可以操作的菜单项
     * @param paramMap
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    List<MenuInfo> queryUserMenu(Map<String, String> paramMap);
}

