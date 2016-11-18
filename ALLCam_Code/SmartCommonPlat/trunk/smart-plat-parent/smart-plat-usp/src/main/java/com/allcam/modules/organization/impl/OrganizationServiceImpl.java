package com.allcam.modules.organization.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.OrganizationDao;
import com.allcam.modules.organization.inf.OrganizationService;
import com.allcam.pojo.OrganizationInfo;
import com.allcam.utils.DateUtil;
import com.allcam.utils.RandomUtil;

/**
 * 组织相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class OrganizationServiceImpl implements OrganizationService
{
    @Resource
    private OrganizationDao organizationDao;
    
    /**
     * 添加组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int addOrganizationInfo(OrganizationInfo organizationInfo)
    {
        Date date = new Date();
        
        if (StringUtils.isBlank(organizationInfo.getOrganizationId()))
        {
            organizationInfo.setOrganizationId(RandomUtil.randomStringa(32));
        }
        
        organizationInfo.setCreateTime(DateUtil.formatTime(date,
                DateUtil.DATE_14));
        organizationInfo.setUpdateTime(DateUtil.formatTime(date,
                DateUtil.DATE_14));
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        OrganizationInfo oi = new OrganizationInfo();
        oi.setParentOrganizationId(organizationInfo.getParentOrganizationId());
        map.put("organizationInfo", oi);
        // 查询当前父组织下面有多少个组织
        List<OrganizationInfo> organizationInfoList = organizationDao.queryOrganizationInfoByCer(map);
        
        if (CollectionUtils.isNotEmpty(organizationInfoList))
        {
            organizationInfo.setSort(String.valueOf(organizationInfoList.size() + 1));
        }
        else
        {
            organizationInfo.setSort("1");
        }
        return organizationDao.addOrganizationInfo(organizationInfo);
    }
    
    /**
     * 删除组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int deleteOrganizationInfo(OrganizationInfo organizationInfo)
    {
        return organizationDao.deleteOrganizationInfo(organizationInfo);
    }
    
    /**
     * 修改组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int updateOrganizationInfo(OrganizationInfo organizationInfo)
    {
        Date date = new Date();
        organizationInfo.setUpdateTime(DateUtil.formatTime(date,
                DateUtil.DATE_14));
        return organizationDao.updateOrganizationInfo(organizationInfo);
    }
    
    /**
     * 根据条件查询组织机构
     * @param map 查询条件
     * 
     * @return List<OrganizationInfo> 查询到的结果
     */
    public List<OrganizationInfo> queryOrganizationInfoByCer(
            Map<String, Object> map)
    {
        return organizationDao.queryOrganizationInfoByCer(map);
    }
    
    /**
     * 根据组织ID查询组织信息
     * @param organizationId 组织ID
     * 
     * @return organizationId 组织信息
     */
    public OrganizationInfo getOrganizationInfoById(String organizationId)
    {
        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.setOrganizationId(organizationId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("organizationInfo", organizationInfo);
        
        List<OrganizationInfo> oriList = queryOrganizationInfoByCer(map);
        if (CollectionUtils.isNotEmpty(oriList))
        {
            return oriList.get(0);
        }
        else
        {
            return organizationInfo;
        }
    }
    
    /**
     * 当前父组织结构信息
     * @param parentOrgId 需要获取的父组织ID
     * 
     * @return OrganizationInfo 父组织结构信息
     */
    public OrganizationInfo getParentOrganization(String parentOrgId)
    {
        OrganizationInfo organizationInfo = null;
        
        if (!"0".equals(parentOrgId))
        {
            organizationInfo = getOrganizationInfoById(parentOrgId);
            
            parentOrganizationInfo(organizationInfo);
        }
        
        return organizationInfo;
    }
    
    private void parentOrganizationInfo(OrganizationInfo organizationInfo)
    {
        if (!"0".equals(organizationInfo.getParentOrganizationId()))
        {
            OrganizationInfo parentOrganizationInfo = getOrganizationInfoById(organizationInfo.getParentOrganizationId());
            
            organizationInfo.setParentOrganizationInfo(parentOrganizationInfo);
            
            parentOrganizationInfo(parentOrganizationInfo);
        }
    }
}
