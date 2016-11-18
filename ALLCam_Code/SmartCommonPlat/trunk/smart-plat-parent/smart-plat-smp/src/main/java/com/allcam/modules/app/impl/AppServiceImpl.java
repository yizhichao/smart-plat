package com.allcam.modules.app.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.AppDao;
import com.allcam.modules.app.inf.AppService;


@Service
public class AppServiceImpl implements AppService{
	@Resource
	AppDao appDao;
}
