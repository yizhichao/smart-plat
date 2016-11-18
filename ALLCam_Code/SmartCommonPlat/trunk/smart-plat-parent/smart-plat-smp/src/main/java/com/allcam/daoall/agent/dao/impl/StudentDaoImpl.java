package com.allcam.daoall.agent.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.StudentDao;
import com.allcam.pojo.StudentInfo;

/**
 * 用户相关的数据库实现类
 * 
 * @author marui
 * @version [版本号, Jul 4, 2015]
 */
@Repository
public class StudentDaoImpl extends BaseDao<Object> implements StudentDao
{
    public static final Log LOG = LogFactory.getLog(StudentDaoImpl.class);
    
    /**
     * 增加用户信息
     * 
     * @param studentInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    public int addStudentInfo(StudentInfo studentInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().insert("StudentInfo.addStudentInfo", studentInfo);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.addStudentInfo Error....", e);
        }
        return k;
    }
    
    /**
     * 根据条件查询用户信息
     * 
     * @param studentInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    public List<StudentInfo> getStudentInfoByCer(StudentInfo studentInfo)
    {
        List<StudentInfo> returnStudentList = null;
        
        try
        {
            returnStudentList = getSqlSession().selectList("StudentInfo.getStudentInfoByCer", studentInfo);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.getStudentInfoByCer Error....", e);
        }
        return returnStudentList;
    }
    
    /**
     * 根据条件查询用户信息
     * 
     * @param studentInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    public StudentInfo getOneStudentInfoByCer(StudentInfo studentInfo)
    {
        StudentInfo returnStudentInfo = null;
        
        try
        {
            returnStudentInfo = getSqlSession().selectOne("StudentInfo.getStudentInfoByCer", studentInfo);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.getOneStudentInfoByCer Error....", e);
        }
        return returnStudentInfo;
    }
    
    /**
     * 删除用户信息
     * 
     * @param studentInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    public int deleteStudentInfoByCer(StudentInfo studentInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().delete("StudentInfo.delStudentInfo", studentInfo);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.deleteStudentInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 更新用户信息
     * 
     * @param studentInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    public int updateStudentInfoByCer(StudentInfo studentInfo)
    {
        int k = 0;
        try
        {
            k = getSqlSession().update("StudentInfo.updateStudentInfo", studentInfo);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.updateStudentInfoByCer Error....", e);
        }
        return k;
    }
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    public List<StudentInfo> queryStudentInfoListByCer(Map<String, Object> map)
    {
        List<StudentInfo> StudentInfoList = new ArrayList<StudentInfo>();
        try
        {
            StudentInfoList = getSqlSession().selectList("StudentInfo.queryStudentInfoByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.queryStudentInfoListByCer Error...", e);
        }
        return StudentInfoList;
    }
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    public List<StudentInfo> queryDeviceSyncStudentByPage(Map<String, Object> map)
    {
        List<StudentInfo> StudentInfoList = new ArrayList<StudentInfo>();
        try
        {
            StudentInfoList = getSqlSession().selectList("StudentInfo.queryDeviceSyncStudentByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.queryDeviceSyncStudentByPage Error...", e);
        }
        return StudentInfoList;
    }
    
    /**
     * 根据条件模糊搜索用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    public List<StudentInfo> searchStudentInfo(Map<String, Object> map)
    {
        List<StudentInfo> StudentInfoList = new ArrayList<StudentInfo>();
        try
        {
            StudentInfoList = getSqlSession().selectList("StudentInfo.searchStudentInfoByPage", map);
        }
        catch (Exception e)
        {
            LOG.error("StudentDaoImpl.queryStudentInfoListByCer Error...", e);
        }
        return StudentInfoList;
    }
    
    @Override
    public List<StudentInfo> getStudentInfo(Map<String, Object> map)
    {
        return getSqlSession().selectList("StudentInfo.queryStudentInfo", map);
    }
    
    @Override
    public int getStudentTotal(Map<String, Object> map)
    {
        return getSqlSession().selectOne("StudentInfo.queryStudentTotal", map);
    }
}
