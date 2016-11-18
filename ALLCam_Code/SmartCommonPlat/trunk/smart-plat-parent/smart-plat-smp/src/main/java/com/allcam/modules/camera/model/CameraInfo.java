package com.allcam.modules.camera.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;

/**
 * 对应tbl_camera_info表
 * 
 * @author 
 */
public class CameraInfo extends BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6858290808662034068L;
	private int id;
	private String zoneId;// 所属园区编号
	private String clientId;
    private String devId;// 主设备编号
    private String cameraId;//镜头设备编号
    private String cameraName;//镜头名称
    private String cameraType;//设备类型
    private String cameraModel;//设备型号
    private String vendorId;//设备厂家
    private String locationDesc;//设备安装地点
    private String locGps;//安装地点的GPS位置信息
    private int status;// 状态
    private int storeageVolume;//IPC存储空间
    private int dataFormat;//媒体流数据格式
    private String remark;
    private String createTime;
    private String updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getCameraId() {
		return cameraId;
	}
	public void setCameraId(String cameraId) {
		this.cameraId = cameraId;
	}
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getCameraType() {
		return cameraType;
	}
	public void setCameraType(String cameraType) {
		this.cameraType = cameraType;
	}
	public String getCameraModel() {
		return cameraModel;
	}
	public void setCameraModel(String cameraModel) {
		this.cameraModel = cameraModel;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getLocationDesc() {
		return locationDesc;
	}
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	public String getLocGps() {
		return locGps;
	}
	public void setLocGps(String locGps) {
		this.locGps = locGps;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStoreageVolume() {
		return storeageVolume;
	}
	public void setStoreageVolume(int storeageVolume) {
		this.storeageVolume = storeageVolume;
	}
	public int getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(int dataFormat) {
		this.dataFormat = dataFormat;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	
	public CameraInfo(String zoneId, String devId, String cameraId,
			String cameraName, String cameraType, int status) {
		this.zoneId = zoneId;
		this.devId = devId;
		this.cameraId = cameraId;
		this.cameraName = cameraName;
		this.cameraType = cameraType;
		this.status = status;
	}

	
}
