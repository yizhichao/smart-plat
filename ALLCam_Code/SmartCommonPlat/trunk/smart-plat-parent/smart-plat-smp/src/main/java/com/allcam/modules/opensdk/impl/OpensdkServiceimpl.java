package com.allcam.modules.opensdk.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.OpensdkDao;
import com.allcam.modules.opensdk.inf.OpensdkService;

@Service
public class OpensdkServiceimpl implements OpensdkService{

	@Resource
	private OpensdkDao opensdkDao;
}
