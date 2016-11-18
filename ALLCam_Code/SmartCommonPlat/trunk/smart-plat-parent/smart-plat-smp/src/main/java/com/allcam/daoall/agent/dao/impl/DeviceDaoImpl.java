package com.allcam.daoall.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.DeviceDao;
import com.allcam.modules.device.model.DeviceInfo;
import com.allcam.modules.plat.model.PlatInfo;

/**
 * 设备管理
 * 
 * @author XiongJinTeng
 */
@Repository
public class DeviceDaoImpl extends BaseDao<Object> implements DeviceDao {

    public static final Log LOG = LogFactory.getLog(DeviceDaoImpl.class);

    /**
     * 通过id获取
     */
    @Override
    public DeviceInfo get(int id) {
        return getSqlSession().selectOne("DeviceInfo.get", id);
    }

    @Override
    public DeviceInfo get(DeviceInfo deviceInfo) {
        return null;
    }

    @Override
    public int insert(DeviceInfo deviceInfo) {
        int k = 0;
        try {
        	SqlSession session=getSqlSession();
            k = session.insert("DeviceInfo.insert", deviceInfo);
            k += session.insert("DeviceInfo.insertMap", deviceInfo);
        }
        catch (Exception e) {
            LOG.error("DeviceDaoImpl.addDevice Error....", e);
        }
        return k;
    }

    @Override
    public int delete(List<String> devIds) {
        return getSqlSession().update("DeviceInfo.delDeviceInfo", devIds);
    }

    @Override
    public int update(DeviceInfo deviceInfo) {
        return 0;
    }

    // @Override
    // public int addDeviceInfo(DeviceInfo deviceInfo)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().insert("DeviceInfo.addDeviceInfo", deviceInfo);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.addDeviceInfo Error....", e);
    // }
    // return k;
    // }
    //
    // @Override
    // public List<DeviceInfo> getDeviceInfo(Map<String, Object> map)
    // {
    // return getSqlSession().selectList("DeviceInfo.queryDeviceInfo", map);
    // }
    //
     @Override
     public int getDeviceTotal(Map<String, Object> map)
     {
     return getSqlSession().selectOne("DeviceInfo.queryDeviceTotal", map);
     }
    //
    // @Override
    // public List<UserInfo> getDeviceUser(DeviceInfo deviceInfo)
    // {
    // return getSqlSession().selectList("DeviceInfo.getDeviceUser",
    // deviceInfo);
    // }
    //
    // @Override
    // public List<DeviceUserInfo> getDeviceUser(Map<String, Object> map)
    // {
    // return getSqlSession().selectList("DeviceInfo.queryDeviceUser", map);
    // }
    //
    // @Override
    // public int getDeviceUserTotal(Map<String, Object> map)
    // {
    // return getSqlSession().selectOne("DeviceInfo.queryDeviceUserTotal", map);
    // }
    //
    // @Override
    // public int modDeviceInfo(DeviceInfo deviceInfo)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().update("DeviceInfo.modDeviceInfo", deviceInfo);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.updateDeviceInfo Error....", e);
    // }
    // return k;
    // }
    //
    // @Override
    // public List<StudentInfo> getStudentInfo(Map<String, Object> map)
    // {
    // List<StudentInfo> StudentInfoList = new ArrayList<StudentInfo>();
    // try
    // {
    // StudentInfoList =
    // getSqlSession().selectList("DeviceInfo.queryStudentInfo", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.getStudentInfo Error...", e);
    // }
    // return StudentInfoList;
    // }
    //
    // public int getStudentTotal(Map<String, Object> map)
    // {
    // return getSqlSession().selectOne("DeviceInfo.queryStudentTotal", map);
    // }
    //
    // @Override
    // public List<UserInfo> getUserInfo(Map<String, Object> map)
    // {
    // List<UserInfo> userInfoList = new ArrayList<UserInfo>();
    // try
    // {
    // userInfoList = getSqlSession().selectList("DeviceInfo.queryUserInfo",
    // map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.getUserInfo Error...", e);
    // }
    // return userInfoList;
    // }
    //
    // public int getUserTotal(Map<String, Object> map)
    // {
    // return getSqlSession().selectOne("DeviceInfo.queryUserTotal", map);
    // }
    //
    // public int addDeviceStudent(List<DeviceStudentInfo> paramList)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().insert("DeviceInfo.addDeviceStudent", paramList);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.addDeviceStudent Error....", e);
    // }
    // return k;
    // }
    //
    // public int deleteDeviceStudent(List<DeviceStudentInfo> paramList)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().delete("DeviceInfo.deleteDeviceStudent", paramList);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.deleteDeviceStudent Error....", e);
    // }
    // return k;
    // }
    //
    // public int addDeviceTeacher(List<DeviceTeacherInfo> paramList)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().insert("DeviceInfo.addDeviceTeacher", paramList);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.addDeviceTeacher Error....", e);
    // }
    // return k;
    // }
    //
    // public int deleteDeviceTeacher(List<DeviceTeacherInfo> paramList)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().delete("DeviceInfo.deleteDeviceTeacher", paramList);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.deleteDeviceTeacher Error....", e);
    // }
    // return k;
    // }
    //
    // public int updateDeviceSchool(Map<String, String> map)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().update("DeviceInfo.updateDeviceSchool", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.updateDeviceSchool Error....", e);
    // }
    // return k;
    // }
    //
    // public int deleteDeviceSchoolStudent(Map<String, String> map)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().delete("DeviceInfo.deleteDeviceSchoolStudent", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.deleteDeviceSchoolStudent Error....", e);
    // }
    // return k;
    // }
    //
    // public int deleteDeviceSchoolTeacher(Map<String, String> map)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().delete("DeviceInfo.deleteDeviceSchoolTeacher", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.deleteDeviceSchoolTeacher Error....", e);
    // }
    // return k;
    // }
    //
    // @Override
    // public List<TaskInfo> getDeviceTask(Map<String, Object> map)
    // {
    // return getSqlSession().selectList("DeviceInfo.queryDeviceTask", map);
    // }
    //
    // @Override
    // public int getDeviceTaskTotal(Map<String, Object> map)
    // {
    // return getSqlSession().selectOne("DeviceInfo.queryDeviceTaskTotal", map);
    // }
    //
    // public int addTask(Map<String, String> map)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().insert("DeviceInfo.addTask", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.addTask Error....", e);
    // }
    // return k;
    // }
    //
    // public int addDeviceTaskMap(Map<String, String> map)
    // {
    // int k = 0;
    // try
    // {
    // k = getSqlSession().insert("DeviceInfo.addDeviceTaskMap", map);
    // }
    // catch (Exception e)
    // {
    // LOG.error("DeviceDaoImpl.addDeviceTaskMap Error....", e);
    // }
    // return k;
    // }

	@Override
	public List<DeviceInfo> queryDeviceInfoList(Map<String, Object> map) {

		return getSqlSession().selectList("DeviceInfo.queryDeviceInfoList", map);
	}
}
