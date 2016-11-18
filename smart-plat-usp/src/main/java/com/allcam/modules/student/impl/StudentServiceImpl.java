package com.allcam.modules.student.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.StudentDao;
import com.allcam.modules.student.inf.StudentService;
import com.allcam.pojo.StudentInfo;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Resource
    private StudentDao studentDao;
    
    /**
     * 增加用户信息
     * 
     * @param studentInfo 用户信息
     * 
     * @return int 返回受影响的行数
     */
    public int addStudentInfo(StudentInfo studentInfo)
    {
        return studentDao.addStudentInfo(studentInfo);
    }
    
    /**
     * 根据条件查询用户信息
     * 
     * @param studentInfo 查询条件
     * 
     * @return StudentInfo 查询到的用户信息
     */
    public StudentInfo getStudentInfoByCer(StudentInfo studentInfo)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("StudentInfo", studentInfo);
        // List<StudentInfo> StudentInfoList = StudentDao.getStudentInfoByCer(StudentInfo);
        
        StudentInfo resultStudentInfo = studentDao.getOneStudentInfoByCer(studentInfo);
        
        // if (CollectionUtils.isNotEmpty(StudentInfoList))
        // {
        // resultStudentInfo = StudentInfoList.get(0);
        // }
        
        return resultStudentInfo;
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
        return studentDao.updateStudentInfoByCer(studentInfo);
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
        return studentDao.deleteStudentInfoByCer(studentInfo);
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
        return studentDao.queryStudentInfoListByCer(map);
    }
    
    /**
     * 根据条件搜索查询用户
     * 
     * @param map 查询条件
     * 
     * @return List<StudentInfo> 查询到的结果
     */
    public List<StudentInfo> searchStudentInfo(Map<String, Object> map)
    {
        return studentDao.searchStudentInfo(map);
    }
    
    public List<StudentInfo> getStudentInfo(Map<String, Object> map)
        throws Exception
    {
        List<StudentInfo> studentList = studentDao.getStudentInfo(map);
        return studentList;
    }
    
    public int getStudentTotal(Map<String, Object> map)
        throws Exception
    {
        int total = studentDao.getStudentTotal(map);
        return total;
    }
}
