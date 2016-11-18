package com.allcam.daoall.agent.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.allcam.daoall.BaseDao;
import com.allcam.daoall.agent.dao.GroupDao;
import com.allcam.modules.group.model.GroupInfo;

@Repository
public class GroupDaoImpl extends BaseDao<Object> implements GroupDao{
	
	public static final Log LOG = LogFactory.getLog(GroupDaoImpl.class);
	
	@Override
	public int insert(GroupInfo groupInfo,Map<String,String> map) {
		int k = 0;
		SqlSession session=getSqlSession();
		k=session.insert("GroupInfo.insert",groupInfo);
		k+=session.insert("GroupInfo.insertMap",map);
		return k;
	}

	@Override
	public int delGroupInfo(List<String> groupIds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
