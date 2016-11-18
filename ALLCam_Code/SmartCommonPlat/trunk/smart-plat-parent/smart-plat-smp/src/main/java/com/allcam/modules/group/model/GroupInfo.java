package com.allcam.modules.group.model;

import java.io.Serializable;

import com.allcam.common.BaseInfo;

public class GroupInfo extends BaseInfo implements Serializable {

	/**
	 * TBL_GROUP_INFO
	 */
	private static final long serialVersionUID = -7541524133039558389L;

	private String groupId;// 组编号

	private String parentId;// 父节点编号

	private String groupName;// 组名称

	private String groupType;// 组类型

	private String groupDesc;// 组描述 2-客户/4-用户/5-设备

	private int status;// 状态

	private String clientId;// 客户编号

	private String createTime;
	private String updateTime;
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
	
}
