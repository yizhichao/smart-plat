package com.allcam.modules.menu.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.menu.model.MenuInfo;


/**
 * 菜单相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface MenuService
{
    /**
     * 查询所有的菜单
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryAllMenuInfo();
    
    /**
     * 查询用户可以操作的菜单项
     * @param paramMap
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryUserMenu(Map<String, String> paramMap);
}
