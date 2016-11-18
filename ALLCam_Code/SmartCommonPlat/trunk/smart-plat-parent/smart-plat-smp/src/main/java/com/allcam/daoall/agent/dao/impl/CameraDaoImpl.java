package com.allcam.daoall.agent.dao.impl;

import java.util.List;

import javafx.scene.Camera;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.CameraDao;
import com.allcam.modules.camera.model.CameraInfo;

@Repository
public class CameraDaoImpl extends BaseDao<Object> implements CameraDao{
	public static final Log LOG = LogFactory.getLog(CameraDaoImpl.class);
	
	
	/**
     * 通过id获取
     */
    @Override
    public CameraInfo get(int id) {
        return getSqlSession().selectOne("CameraInfo.get", id);
    }
    
    @Override
    public int insert(CameraInfo CameraInfo) {
        int k = 0;
        try {
            k = getSqlSession().insert("CameraInfo.insert", CameraInfo);
        }
        catch (Exception e) {
            LOG.error("CameraDaoImpl.addCameraTeacher Error....", e);
        }
        return k;
    }
    
    @Override
    public int insert(List<CameraInfo> CameraInfoList) {
        int k = 0;
        try {
        	SqlSession session=getSqlSession();
            k = session.insert("CameraInfo.insertList", CameraInfoList);
        }
        catch (Exception e) {
            LOG.error("CameraDaoImpl.addCameraTeacher Error....", e);
        }
        return k;
    }
    
    @Override
    public int delete(CameraInfo cameraInfo) {
        return 0;
    }

    @Override
    public int update(CameraInfo cameraInfo) {
        return 0;
    }
}
