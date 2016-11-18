package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.SchoolDao;
import com.allcam.pojo.SchoolInfo;

/**
 * 学校相关的数据库实现类
 * 
 * @author marui
 * @version [版本号, Jul 4, 2015]
 */
@Repository
public class SchoolDaoImpl extends BaseDao<Object> implements SchoolDao
{
    public static final Log LOG = LogFactory.getLog(SchoolDaoImpl.class);
    
    /**
     * 添加学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int addSchoolInfo(SchoolInfo schoolInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("SchoolInfo.addSchoolInfo", schoolInfo);
        }
        catch (Exception e)
        {
            LOG.error("SchoolDaoImpl.addSchoolInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 删除学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int deleteSchoolInfo(SchoolInfo schoolInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().delete("SchoolInfo.deleteSchoolInfo", schoolInfo);
        }
        catch (Exception e)
        {
            LOG.error("SchoolDaoImpl.deleteSchoolInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 修改学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    public int updateSchoolInfo(SchoolInfo schoolInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("SchoolInfo.updateSchoolInfo", schoolInfo);
        }
        catch (Exception e)
        {
            LOG.error("SchoolDaoImpl.updateSchoolInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return List<SchoolInfo> 查询到的学校信息
     */
    public List<SchoolInfo> querySchoolInfoByCer(Map<String, Object> map)
    {
        List<SchoolInfo> schoolInfo = new ArrayList<SchoolInfo>();
        try
        {
            schoolInfo = getSqlSession().selectList("SchoolInfo.querySchoolInfoByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("SchoolDaoImpl.querySchoolInfoByCer Error...", e);
        }
        return schoolInfo;
    }
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    public SchoolInfo queryOneSchoolInfoByCer(String schoolId)
    {
        SchoolInfo result = new SchoolInfo();
        try
        {
            result = getSqlSession().selectOne("SchoolInfo.queryOneSchoolInfoByCer", schoolId);
        }
        catch (Exception e)
        {
            LOG.error("SchoolDaoImpl.querySchoolInfoByCer Error...", e);
        }
        return result;
    }
    
    @Override
    public List<SchoolInfo> getSchoolInfo(Map<String, Object> map)
    {
        return getSqlSession().selectList("SchoolInfo.querySchoolInfo", map);
    }
    
    @Override
    public int getSchoolTotal(Map<String, Object> map)
    {
        return getSqlSession().selectOne("SchoolInfo.querySchoolTotal", map);
    }
}
