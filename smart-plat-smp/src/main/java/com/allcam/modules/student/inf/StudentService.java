package com.allcam.modules.student.inf;

import java.util.List;
import java.util.Map;

import com.allcam.pojo.StudentInfo;


/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface StudentService
{
    /**
     * 增加用户信息
     * @param studentInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    int addStudentInfo(StudentInfo studentInfo);
    
    /**
     * 根据条件查询用户信息
     * @param studentInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    StudentInfo getStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 更新用户信息
     * @param studentInfo 更新条件
     * 
     * @return int 返回受影响的行数
     */
    int updateStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 删除用户信息
     * @param studentInfo 删除条件
     * 
     * @return int 返回受影响的行数
     */
    int deleteStudentInfoByCer(StudentInfo studentInfo);
    
    /**
     * 根据条件查询用户
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    List<StudentInfo> queryStudentInfoListByCer(Map<String, Object> map);
    
    /**
     * 根据条件搜索查询用户
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    List<StudentInfo> searchStudentInfo(Map<String, Object> map);
    
    /**
     * 获取学生列表
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 学生信息
     */
    List<StudentInfo> getStudentInfo(Map<String, Object> map)
        throws Exception;
    
    /**
     * 获取学生总数
     * 
     * @param map 查询条件
     * 
     * @return int 学生总数
     */
    int getStudentTotal(Map<String, Object> map)
        throws Exception;
}
