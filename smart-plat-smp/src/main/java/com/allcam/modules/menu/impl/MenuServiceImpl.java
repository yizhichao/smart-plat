package com.allcam.modules.menu.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.MenuDao;
import com.allcam.modules.menu.inf.MenuService;
import com.allcam.modules.menu.model.MenuInfo;

/**
 * 菜单相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class MenuServiceImpl implements MenuService
{
    @Resource
    private MenuDao menuDao;
    
    /**
     * 查询所有的菜单
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryAllMenuInfo()
    {
        return menuDao.queryAllMenuInfo();
    }
    
    /**
     * 查询用户可以操作的菜单项
     * @param paramMap
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryUserMenu(Map<String, String> paramMap)
    {
        return menuDao.queryUserMenu(paramMap);
    }
}
