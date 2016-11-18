package com.allcam.modules.organization.inf;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.OrganizationInfo;


/**
 * 组织相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface OrganizationService
{
    /**
     * 添加组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    int addOrganizationInfo(OrganizationInfo organizationInfo);
    
    /**
     * 删除组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    int deleteOrganizationInfo(OrganizationInfo organizationInfo);
    
    /**
     * 修改组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    int updateOrganizationInfo(OrganizationInfo organizationInfo);
    
    /**
     * 根据条件查询组织机构
     * @param map 查询条件
     * 
     * @return List<OrganizationInfo> 查询到的结果
     */
    List<OrganizationInfo> queryOrganizationInfoByCer(Map<String, Object> map);
    
    /**
     * 根据组织ID查询组织信息
     * @param organizationId 组织ID
     * 
     * @return organizationId 组织信息
     */
    OrganizationInfo getOrganizationInfoById(String organizationId);
    
    /**
     * 当前父组织结构信息
     * @param parentOrgId 需要获取的父组织ID
     * 
     * @return OrganizationInfo 父组织结构信息
     */
    OrganizationInfo getParentOrganization(String parentOrgId);
}
