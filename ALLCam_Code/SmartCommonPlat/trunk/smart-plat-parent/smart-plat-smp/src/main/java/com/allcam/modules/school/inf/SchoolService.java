package com.allcam.modules.school.inf;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.SchoolInfo;

/**
 * 学校相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface SchoolService
{
    /**
     * 添加学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int addSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 删除学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int deleteSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 修改学校信息
     * 
     * @param schoolInfo 学校信息
     * 
     * @return int 受影响的行数
     */
    int updateSchoolInfo(SchoolInfo schoolInfo);
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return List<SchoolInfo> 查询到的学校信息
     */
    List<SchoolInfo> querySchoolInfoByCer(Map<String, Object> map);
    
    /**
     * 根据学校信息查询学校的详细信息
     * 
     * @param schoolInfo 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    SchoolInfo getSchoolInfoByCer(SchoolInfo schoolInfo);
    
    /**
     * 查询学校信息
     * 
     * @param map 查询条件
     * 
     * @return SchoolInfo 查询到的学校信息
     */
    SchoolInfo queryOneSchoolInfoByCer(String schoolId);
    
    /**
     * 获取学校列表
     * 
     * @param map 查询条件
     * 
     * @return List<SchoolInfo> 学校信息
     */
    List<SchoolInfo> getSchoolInfo(Map<String, Object> map)
        throws Exception;
    
    /**
     * 获取学校总数
     * 
     * @param map 查询条件
     * 
     * @return int 学校总数
     */
    int getSchoolTotal(Map<String, Object> map)
        throws Exception;
}
