package com.allcam.modules.camera.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.CameraDao;
import com.allcam.modules.camera.inf.CameraService;
import com.allcam.modules.camera.model.CameraInfo;

@Service
public class CameraServiceImpl implements CameraService{
	@Resource
	private CameraDao cameraDao;
	
	public CameraInfo get(int id){
		return cameraDao.get(id);
	}
    public int insert(CameraInfo cameraInfo){
    	return cameraDao.insert(cameraInfo);
    }
    
    public int insert(List<CameraInfo> cameraInfoList){
    	return cameraDao.insert(cameraInfoList);
    }
}
