package com.allcam.modules.device.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.DeviceDao;
import com.allcam.modules.device.inf.DeviceService;
import com.allcam.modules.device.model.DeviceInfo;

/**
 * 设备相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-10-15]
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Resource
    private DeviceDao deviceDao;

    public DeviceInfo get(int id) {
        return deviceDao.get(id);
    }

    public int insert(DeviceInfo deviceInfo) {
        return deviceDao.insert(deviceInfo);
    }

    // @Resource
    // private DeviceDao deviceDao;
    //
    // /**
    // * 获取设备列表
    // *
    // * @param map 查询条件
    // *
    // * @return List<DeviceInfo> 设备信息
    // */
    // public List<DeviceInfo> getDeviceInfo(Map<String, Object> map)
    // throws Exception
    // {
    // List<DeviceInfo> deviceList = deviceDao.getDeviceInfo(map);
    // return deviceList;
    // }
    //
    // public int getDeviceTotal(Map<String, Object> map)
    // throws Exception
    // {
    // int total = deviceDao.getDeviceTotal(map);
    // return total;
    // }
    //
    // public List<UserInfo> getDeviceUser(DeviceInfo deviceInfo)
    // throws Exception
    // {
    // List<UserInfo> userList = deviceDao.getDeviceUser(deviceInfo);
    // return userList;
    // }
    //
    // public List<DeviceUserInfo> getDeviceUser(Map<String, Object> map)
    // throws Exception
    // {
    // List<DeviceUserInfo> list = deviceDao.getDeviceUser(map);
    // return list;
    // }
    //
    // public int getDeviceUserTotal(Map<String, Object> map)
    // throws Exception
    // {
    // int total = deviceDao.getDeviceUserTotal(map);
    // return total;
    // }
    //
    // /**
    // * 根据条件查询学生
    // *
    // * @param map 查询条件
    // *
    // * @return List<StudentInfo> 查询到的结果
    // */
    // public List<StudentInfo> getStudentInfo(Map<String, Object> map)
    // {
    // return deviceDao.getStudentInfo(map);
    // }
    //
    // public int getStudentTotal(Map<String, Object> map)
    // {
    // return deviceDao.getStudentTotal(map);
    // }
    //
    // public List<UserInfo> getUserInfo(Map<String, Object> map)
    // {
    // return deviceDao.getUserInfo(map);
    // }
    //
    // public int getUserTotal(Map<String, Object> map)
    // {
    // return deviceDao.getUserTotal(map);
    // }
    //
    // public int addDeviceStudent(List<DeviceStudentInfo> paramList)
    // {
    // return deviceDao.addDeviceStudent(paramList);
    // }
    //
    // public int deleteDeviceStudent(List<DeviceStudentInfo> paramList)
    // {
    // return deviceDao.deleteDeviceStudent(paramList);
    // }
    //
    // public int addDeviceTeacher(List<DeviceTeacherInfo> paramList)
    // {
    // return deviceDao.addDeviceTeacher(paramList);
    // }
    //
    // public int deleteDeviceTeacher(List<DeviceTeacherInfo> paramList)
    // {
    // return deviceDao.deleteDeviceTeacher(paramList);
    // }
    //
    // public int updateDeviceSchool(Map<String, String> map)
    // {
    // return deviceDao.updateDeviceSchool(map);
    // }
    //
    // public int deleteDeviceSchoolStudent(Map<String, String> map)
    // {
    // return deviceDao.deleteDeviceSchoolStudent(map);
    // }
    //
    // public int deleteDeviceSchoolTeacher(Map<String, String> map)
    // {
    // return deviceDao.deleteDeviceSchoolTeacher(map);
    // }
    //
    // public List<TaskInfo> getDeviceTask(Map<String, Object> map)
    // throws Exception
    // {
    // List<TaskInfo> taskList = deviceDao.getDeviceTask(map);
    // return taskList;
    // }
    //
    // public int getDeviceTaskTotal(Map<String, Object> map)
    // throws Exception
    // {
    // int total = deviceDao.getDeviceTaskTotal(map);
    // return total;
    // }
    //
    // public int addTask(Map<String, String> map)
    // {
    // map.put("taskName", getTaskNameByTaskVal(map.get("taskValue")));
    // map.put("taskServerUrl", getTaskUrlByTaskVal(map.get("taskValue")));
    // return deviceDao.addTask(map);
    // }
    //
    // public int addDeviceTaskMap(Map<String, String> map)
    // {
    // return deviceDao.addDeviceTaskMap(map);
    // }
    //
    // private String getTaskUrlByTaskVal(String taskVal)
    // {
    // String taskUrl = "";
    // int id = Integer.parseInt(taskVal);
    // switch (id)
    // {
    // case 1:
    // taskUrl = Env.getWebCommon().get("common/TASK/SYNC_STUDENT");
    // break;
    //
    // case 2:
    // taskUrl = Env.getWebCommon().get("common/TASK/SYNC_TEACHER");
    // break;
    //
    // case 3:
    // taskUrl = Env.getWebCommon().get("common/TASK/SYNC_ADS");
    // break;
    //
    // case 4:
    // taskUrl = Env.getWebCommon().get("common/TASK/SYS_UPGRADE");
    // break;
    // }
    // return taskUrl;
    // }
    //
    // private String getTaskNameByTaskVal(String taskVal)
    // {
    // String taskName = "";
    // int id = Integer.parseInt(taskVal);
    // switch (id)
    // {
    // case 1:
    // taskName = "拉取学生信息";
    // break;
    //
    // case 2:
    // taskName = "拉取老师信息";
    // break;
    //
    // case 3:
    // taskName = "拉取广告信息";
    // break;
    //
    // case 4:
    // taskName = "版本升级信息";
    // break;
    // }
    // return taskName;
    // }
}
