package com.allcam.modules.group.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.GroupDao;
import com.allcam.modules.group.inf.GroupService;
import com.allcam.modules.group.model.GroupInfo;

@Service
public class GroupServiceImpl implements GroupService {

	@Resource
	private GroupDao groupDao;

	@Override
	public int insert(GroupInfo groupInfo,Map<String,String> map) {
		return groupDao.insert(groupInfo,map);
	}

	@Override
	public int delGroupInfo(List<String> groupIds) {
		return groupDao.delGroupInfo(groupIds);
	}


}
