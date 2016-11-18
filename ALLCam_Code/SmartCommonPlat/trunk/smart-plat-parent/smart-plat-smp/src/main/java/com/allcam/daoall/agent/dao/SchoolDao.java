package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.SchoolInfo;

/**
 * 学校相关的数据库接口层
 * 
 * @author  marui
 * @version  [版本号, Jul 4, 2015]
 */
public interface SchoolDao
{
    /**
     * 添加学校信息
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int addSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 删除学校信息
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int deleteSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 修改学校信息
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int updateSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 查询学校信息
     * @param map 查询条件
     * 
     * @return List<SchoolInfo> 查询到的学校信息
     */
    List<SchoolInfo> querySchoolInfoByCer(Map<String, Object> map);
    
    /**
     * 查询学校信息
     * @param map 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    SchoolInfo queryOneSchoolInfoByCer(String schoolId);
    
    List<SchoolInfo> getSchoolInfo(Map<String, Object> map);
    
    int getSchoolTotal(Map<String, Object> map);
}
