package com.allcam.modules.camera.inf;

import java.util.List;


import com.allcam.modules.camera.model.CameraInfo;


public interface CameraService {
	
	public CameraInfo get(int id);

    public int insert(CameraInfo cameraInfo);
    public int insert(List<CameraInfo> cameraInfoList);
    // /**
    // * 获取设备列表
    // *
    // * @param map
    // * 查询条件
    // *
    // * @return List<DeviceInfo> 设备信息
    // */
    // List<DeviceInfo> getDeviceInfo(Map<String, Object> map) throws Exception;
    //
    // /**
    // * 获取设备总数
    // *
    // * @param map
    // * 查询条件
    // *
    // * @return int 设备总数
    // */
//     int getDeviceTotal(Map<String, Object> map) throws Exception;
    //
    // List<UserInfo> getDeviceUser(DeviceInfo deviceInfo) throws Exception;
    //
    // List<DeviceUserInfo> getDeviceUser(Map<String, Object> map) throws
    // Exception;
    //
    // int getDeviceUserTotal(Map<String, Object> map) throws Exception;
    //
    // /**
    // * 根据条件查询学生
    // *
    // * @param map
    // * 查询条件
    // *
    // * @return List<StudentInfo> 查询到的结果
    // */
    // List<StudentInfo> getStudentInfo(Map<String, Object> map);
    //
    // int getStudentTotal(Map<String, Object> map);
    //
    // /**
    // * 根据条件查询老师
    // *
    // * @param map
    // * 查询条件
    // *
    // * @return List<UserInfo> 查询到的结果
    // */
    // List<UserInfo> getUserInfo(Map<String, Object> map);
    //
    // int getUserTotal(Map<String, Object> map);
    //
    // int addDeviceStudent(List<DeviceStudentInfo> paramList);
    //
    // int deleteDeviceStudent(List<DeviceStudentInfo> paramList);
    //
    // int addDeviceTeacher(List<DeviceTeacherInfo> paramList);
    //
    // int deleteDeviceTeacher(List<DeviceTeacherInfo> paramList);
    //
    // int updateDeviceSchool(Map<String, String> map);
    //
    // int deleteDeviceSchoolStudent(Map<String, String> map);
    //
    // int deleteDeviceSchoolTeacher(Map<String, String> map);
    //
    // List<TaskInfo> getDeviceTask(Map<String, Object> map) throws Exception;
    //
    // int getDeviceTaskTotal(Map<String, Object> map) throws Exception;
    //
    // int addTask(Map<String, String> map);
    //
    // int addDeviceTaskMap(Map<String, String> map);
}
