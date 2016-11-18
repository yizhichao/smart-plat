package com.allcam.pojo;

import java.io.Serializable;
import java.util.List;
import com.allcam.utils.Tools;

/**
 * 组织实体对象
 * 
 * @author  marui
 * @version  [版本号, Jul 5, 2015]
 */
public class OrganizationInfo implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -5148523018251088952L;
    
    /**
     * 编号
     */
    private String organizationId;
    
    /**
     * 组织名称
     */
    private String organizationName;
    
    /**
     * 父组织
     */
    private String parentOrganizationId;
    
    /**
     * 学校ID
     */
    private String schoolId;
    
    /**
     * 排序
     */
    private String sort;
    
    /**
     * 创建时间
     */
    private String createTime;
    
    /**
     * 更新时间
     */
    private String updateTime;
    
    /**
     * 创建者ID
     */
    private String createBy;
    
    /**
     * 更新者ID
     */
    private String updateBy;
    
    /**
     * 组织下的人员
     */
    private List<UserInfo> userInfoList;
    
    /**
     * 当前组织结构下面的子组织
     */
    private List<OrganizationInfo> childOrg;
    
    /**
     * 需要缩进的空格数
     */
    private int spaceNum;
    
    /**
     * 当前组织结构的父组织结构
     */
    private OrganizationInfo parentOrganizationInfo;
    
    public OrganizationInfo getParentOrganizationInfo()
    {
        return parentOrganizationInfo;
    }
    
    public void setParentOrganizationInfo(
            OrganizationInfo parentOrganizationInfo)
    {
        this.parentOrganizationInfo = parentOrganizationInfo;
    }
    
    public int getSpaceNum()
    {
        return spaceNum;
    }
    
    public void setSpaceNum(int spaceNum)
    {
        this.spaceNum = spaceNum;
    }
    
    public List<OrganizationInfo> getChildOrg()
    {
        return childOrg;
    }
    
    public void setChildOrg(List<OrganizationInfo> childOrg)
    {
        this.childOrg = childOrg;
    }
    
    public List<UserInfo> getUserInfoList()
    {
        return userInfoList;
    }
    
    public void setUserInfoList(List<UserInfo> userInfoList)
    {
        this.userInfoList = userInfoList;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public String getCreateBy()
    {
        return createBy;
    }
    
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }
    
    public String getUpdateBy()
    {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }
    
    public String getOrganizationId()
    {
        return organizationId;
    }
    
    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
    }
    
    public String getOrganizationName()
    {
        return organizationName;
    }
    
    public void setOrganizationName(String organizationName)
    {
        this.organizationName = organizationName;
    }
    
    public String getParentOrganizationId()
    {
        return parentOrganizationId;
    }
    
    public void setParentOrganizationId(String parentOrganizationId)
    {
        this.parentOrganizationId = parentOrganizationId;
    }
    
    public String getSchoolId()
    {
        return schoolId;
    }
    
    public void setSchoolId(String schoolId)
    {
        this.schoolId = schoolId;
    }
    
    public String getSort()
    {
        return sort;
    }
    
    public void setSort(String sort)
    {
        this.sort = sort;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
