package com.allcam.daoall.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.OrganizationDao;
import com.allcam.pojo.OrganizationInfo;

/**
 * 组织相关的数据库实现类
 * 
 * @author  marui
 * @version  [版本号, Jul 4, 2015]
 */
@Repository
public class OrganizationDaoImpl extends BaseDao<Object> implements
        OrganizationDao
{
    public static final Log LOG = LogFactory.getLog(OrganizationDaoImpl.class);
    
    /**
     * 添加组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int addOrganizationInfo(OrganizationInfo organizationInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("OrganizationInfo.addOrganizationInfo",
                    organizationInfo);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.addOrganizationInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 删除组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int deleteOrganizationInfo(OrganizationInfo organizationInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().delete("OrganizationInfo.deleteOrganizationInfo",
                    organizationInfo);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.deleteOrganizationInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 修改组织机构
     * @param organizationInfo 组织机构信息
     * 
     * @return int 受影响的行数
     */
    public int updateOrganizationInfo(OrganizationInfo organizationInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("OrganizationInfo.updateOrganizationInfo",
                    organizationInfo);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.updateOrganizationInfo Error....", e);
        }
        return k;
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
        List<OrganizationInfo> organizationInfoList = null;
        try
        {
            organizationInfoList = getSqlSession().selectList("OrganizationInfo.queryOrganizationInfoByCer",
                    map);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.queryOrganizationInfoByCer Error....",
                    e);
        }
        return organizationInfoList;
    }
    
    /**
     * 根据条件查询组织机构
     * @param map 查询条件
     * 
     * @return List<OrganizationInfo> 查询到的结果
     */
    public List<OrganizationInfo> queryOrganizationInfoByPage(
            Map<String, Object> map)
    {
        List<OrganizationInfo> organizationInfoList = null;
        try
        {
            organizationInfoList = getSqlSession().selectList("OrganizationInfo.queryOrganizationInfoByPage",
                    map);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.queryOrganizationInfoByPage Error....",
                    e);
        }
        return organizationInfoList;
    }
    
    /**
     * 根据组织ID查询组织信息
     * @param organizationId 组织ID
     * 
     * @return organizationId 组织信息
     */
    public OrganizationInfo getOrganizationInfoById(String organizationId)
    {
        OrganizationInfo organizationInfo = null;
        try
        {
            organizationInfo = getSqlSession().selectOne("OrganizationInfo.queryOrganizationInfoByPage",
                    organizationId);
        }
        catch (Exception e)
        {
            LOG.error("OrganizationDaoImpl.getOrganizationInfoById Error....",
                    e);
        }
        return organizationInfo;
    }
}
