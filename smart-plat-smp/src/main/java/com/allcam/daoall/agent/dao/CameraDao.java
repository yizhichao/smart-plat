package com.allcam.daoall.agent.dao;

import java.util.List;


import com.allcam.modules.camera.model.CameraInfo;
public interface CameraDao {
	public CameraInfo get(int id);


    public int insert(CameraInfo cameraInfo);

    public int delete(CameraInfo cameraInfo);

    public int update(CameraInfo cameraInfo);


	int insert(List<CameraInfo> CameraInfoList);
}
