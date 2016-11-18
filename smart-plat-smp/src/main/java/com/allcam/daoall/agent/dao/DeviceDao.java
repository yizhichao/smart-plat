package com.allcam.daoall.agent.dao;

import java.util.List;
import java.util.Map;

import com.allcam.modules.device.model.DeviceInfo;
import com.allcam.modules.plat.model.PlatInfo;

public interface DeviceDao {

    public DeviceInfo get(int id);

    public DeviceInfo get(DeviceInfo deviceInfo);

    public int insert(DeviceInfo deviceInfo);

    public int delete(List<String> devids);

    public int update(DeviceInfo deviceInfo);

    // public int addDeviceInfo(DeviceInfo deviceInfo);
    //
    // public List<DeviceInfo> getDeviceInfo(Map<String, Object> map);
    //
    // public List<UserInfo> getDeviceUser(DeviceInfo deviceInfo);
    //
    // public List<DeviceUserInfo> getDeviceUser(Map<String, Object> map);
    //
     public int getDeviceTotal(Map<String, Object> map);
    //
    // public int getDeviceUserTotal(Map<String, Object> map);
    //
    // public int modDeviceInfo(DeviceInfo deviceInfo);
    //
    // /**
    // * 根据条件查询学生
    // *
    // * @param map 查询条件
    // *
    // * @return List<StudentInfo> 查询到的结果
    // */
    // public List<StudentInfo> getStudentInfo(Map<String, Object> map);
    //
    // public int getStudentTotal(Map<String, Object> map);
    //
    // public List<UserInfo> getUserInfo(Map<String, Object> map);
    //
    // public int getUserTotal(Map<String, Object> map);
    //
    // public int addDeviceStudent(List<DeviceStudentInfo> paramList);
    //
    // public int deleteDeviceStudent(List<DeviceStudentInfo> paramList);
    //
    // public int addDeviceTeacher(List<DeviceTeacherInfo> paramList);
    //
    // public int deleteDeviceTeacher(List<DeviceTeacherInfo> paramList);
    //
    // public int updateDeviceSchool(Map<String, String> map);
    //
    // public int deleteDeviceSchoolStudent(Map<String, String> map);
    //
    // public int deleteDeviceSchoolTeacher(Map<String, String> map);
    //
    // public List<TaskInfo> getDeviceTask(Map<String, Object> map);
    //
    // public int getDeviceTaskTotal(Map<String, Object> map);
    //
    // public int addTask(Map<String, String> map);
    //
    // public int addDeviceTaskMap(Map<String, String> map);

	public List<DeviceInfo> queryDeviceInfoList(Map<String, Object> map);
}
