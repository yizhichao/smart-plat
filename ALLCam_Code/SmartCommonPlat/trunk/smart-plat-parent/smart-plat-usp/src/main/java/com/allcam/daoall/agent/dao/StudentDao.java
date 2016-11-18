package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.StudentInfo;

/**
 * 用户相关的数据库接口层
 * 
 * @author marui
 * @version [版本号, Jul 4, 2015]
 */
public interface StudentDao
{
    /**
     * 增加用户信息
     * 
     * @param DeviceUserInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    int addStudentInfo(StudentInfo studentInfo);
    
      /**
     * 根据条件查询用户信息
     * 
     * @param DeviceUserInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    List<StudentInfo> getStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 根据条件查询用户信息
     * 
     * @param DeviceUserInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    StudentInfo getOneStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 更新用户信息
     * 
     * @param DeviceUserInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    int updateStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 删除用户信息
     * 
     * @param DeviceUserInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    int deleteStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    List<StudentInfo> queryStudentInfoListByCer(Map<String, Object> map);
    
    /**
     * 根据条件查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    List<StudentInfo> queryDeviceSyncStudentByPage(Map<String, Object> map);
    
    /**
     * 根据条件搜索查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    List<StudentInfo> searchStudentInfo(Map<String, Object> map);
    
    List<StudentInfo> getStudentInfo(Map<String, Object> map);
    
    int getStudentTotal(Map<String, Object> map);
}
