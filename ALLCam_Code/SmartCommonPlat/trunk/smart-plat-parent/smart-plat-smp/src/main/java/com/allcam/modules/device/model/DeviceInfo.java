package com.allcam.modules.device.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 对应tbl_dev_info表
 * 
 * @author XiongJinTeng
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceInfo extends BaseInfo implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 3996922987561090474L;
    
     private int id;
    private String zoneId;// 所属园区编号
    
    private String clientId;// 客户编号
     private String devSn;// 设备SN号
     private String devId;// 设备编号
     private String devName;// 主设备名称
     private int devType;// 设备类型
     private String loginName;// 设备登录账号
     private String passwd;// 设备登录密码
     private int storageVolume;// 存储容量
     private int accessMode; // 有线接入方式
     private String deviceModelId;
     private int devAccessMode;// 设备接入方式
     private String simNum;// SIM卡号
     private int wireLessMode;// 无限网络控制
     private String staticIp;// 静态ip地址
     private String netMask;// 掩码
     private String gateWay;// 网关地址
     private String dns;// DNS地址
     private String installLocate;// 安装位置扫描
     private int status;// 状态
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
	public String getDevSn() {
		return devSn;
	}
	public void setDevSn(String devSn) {
		this.devSn = devSn;
	}
	public String getDevId() {
		return devId;
	}
	public void setDevId(String devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public int getDevType() {
		return devType;
	}
	public void setDevType(int devType) {
		this.devType = devType;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getStorageVolume() {
		return storageVolume;
	}
	public void setStorageVolume(int storageVolume) {
		this.storageVolume = storageVolume;
	}
	public int getAccessMode() {
		return accessMode;
	}
	public void setAccessMode(int accessMode) {
		this.accessMode = accessMode;
	}
	public String getDeviceModelId() {
		return deviceModelId;
	}
	public void setDeviceModelId(String deviceModelId) {
		this.deviceModelId = deviceModelId;
	}
	public int getDevAccessMode() {
		return devAccessMode;
	}
	public void setDevAccessMode(int devAccessMode) {
		this.devAccessMode = devAccessMode;
	}
	public String getSimNum() {
		return simNum;
	}
	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}
	public int getWireLessMode() {
		return wireLessMode;
	}
	public void setWireLessMode(int wireLessMode) {
		this.wireLessMode = wireLessMode;
	}
	public String getStaticIp() {
		return staticIp;
	}
	public void setStaticIp(String staticIp) {
		this.staticIp = staticIp;
	}
	public String getNetMask() {
		return netMask;
	}
	public void setNetMask(String netMask) {
		this.netMask = netMask;
	}
	public String getGateWay() {
		return gateWay;
	}
	public void setGateWay(String gateWay) {
		this.gateWay = gateWay;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	public String getInstallLocate() {
		return installLocate;
	}
	public void setInstallLocate(String installLocate) {
		this.installLocate = installLocate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getupdateTime() {
		return updateTime;
	}
	public void setupdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	
	public DeviceInfo(String clientId, String devId, String devName) {
		this.clientId = clientId;
		this.devId = devId;
		this.devName = devName;
	}
	public DeviceInfo() {
		
	}
	public String[] values()
	{
	        String[] arr =
	            {this.devId,this.devName, String.valueOf(this.devType), String.valueOf(this.status),
	                 this.createTime,this.updateTime};
	        return arr;
	}

   
    
}
