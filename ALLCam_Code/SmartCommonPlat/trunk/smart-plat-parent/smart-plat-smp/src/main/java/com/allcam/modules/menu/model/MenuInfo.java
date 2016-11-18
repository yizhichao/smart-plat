package com.allcam.modules.menu.model;

import java.io.Serializable;

/**
 * 菜单实体对象，对应tbl_menu_info表中的数据
 * 
 * @author  marui
 * @version  [版本号, Jul 5, 2015]
 */
public class MenuInfo implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -5148523018251088952L;
    
    /**
     * 菜单编号
     */
    private String menuId;
    
    /**
     * 菜单名
     */
    private String menuName;
    
    /**
     * 父菜单编号
     */
    private String parentMenuId;
    
    /**
     * 菜单图标地址
     */
    private String menuIcon;
    
    /**
     * 菜单跳转地址
     */
    private String menuTarget;
    
    /**
     * 菜单排序
     */
    private int sort;
    
    /**
     * 是否默认选中,1表示是选中，0表示不选中
     */
    private int checked;
    
    /**
     * 是否在菜单中显示，1显示,0不显示
     */
    private String isShow;

    public String getMenuId()
    {
        return menuId;
    }

    public void setMenuId(String menuId)
    {
        this.menuId = menuId;
    }

    public String getMenuName()
    {
        return menuName;
    }

    public void setMenuName(String menuName)
    {
        this.menuName = menuName;
    }

    public String getParentMenuId()
    {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId)
    {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuIcon()
    {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon)
    {
        this.menuIcon = menuIcon;
    }

    public String getMenuTarget()
    {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget)
    {
        this.menuTarget = menuTarget;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }

    public int getChecked()
    {
        return checked;
    }

    public void setChecked(int checked)
    {
        this.checked = checked;
    }

    public String getIsShow()
    {
        return isShow;
    }

    public void setIsShow(String isShow)
    {
        this.isShow = isShow;
    }

    @Override
    public String toString()
    {
        return "MenuInfo [menuId=" + menuId + ", menuName=" + menuName + ", parentMenuId=" + parentMenuId
            + ", menuIcon=" + menuIcon + ", menuTarget=" + menuTarget + ", sort=" + sort + ", checked=" + checked
            + ", isShow=" + isShow + "]";
    }
}
