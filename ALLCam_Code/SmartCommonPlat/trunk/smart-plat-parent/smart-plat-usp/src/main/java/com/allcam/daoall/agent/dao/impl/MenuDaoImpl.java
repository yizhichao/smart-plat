package com.allcam.daoall.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.MenuDao;
import com.allcam.modules.menu.model.MenuInfo;

/**
 * 菜单相关的数据库实现类
 * 
 * @author  marui
 * @version  [版本号, Jul 4, 2015]
 */
@Repository
public class MenuDaoImpl extends BaseDao<Object> implements MenuDao
{
    public static final Log LOG = LogFactory.getLog(MenuDaoImpl.class);
    
    /**
     * 查询所有的菜单
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryAllMenuInfo()
    {
        return getSqlSession().selectList("MenuInfo.queryAllMenuInfo");
    }
    
    /**
     * 查询用户可以操作的菜单项
     * @param paramMap
     * 
     * @return List<MenuInfo> [返回类型说明]
     */
    public List<MenuInfo> queryUserMenu(Map<String, String> paramMap)
    {
        return getSqlSession().selectList("MenuInfo.queryUserMenu", paramMap);
    }
}
