package com.allcam.modules.device.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.device.model.DeviceInfo;
import com.allcam.modules.plat.model.PlatInfo;

/**
 * 设备相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-10-15]
 */
public interface DeviceService {

    public DeviceInfo get(int id);

    public int insert(DeviceInfo deviceInfo);
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
    public int getDeviceTotal(Map<String, Object> map) throws Exception;
    

	public List<DeviceInfo> queryDeviceInfoList(Map<String, Object> map);
	
	public int delDeviceInfo(List<String> devIds) ;
}
