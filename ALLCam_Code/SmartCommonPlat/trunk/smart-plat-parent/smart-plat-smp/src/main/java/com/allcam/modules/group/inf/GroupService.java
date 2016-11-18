package com.allcam.modules.group.inf;

import java.util.List;
import java.util.Map;

import com.allcam.modules.group.model.GroupInfo;

public interface GroupService {
	
	public int insert(GroupInfo groupInfo,Map<String,String> map);
	
	public int delGroupInfo(List<String> groupIds) ;

}
