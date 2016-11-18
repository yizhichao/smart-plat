package com.allcam.modules.ability.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.allcam.daoall.agent.dao.AbilityDao;
import com.allcam.modules.ability.inf.AbilityService;

@Service
public class AbilityServiceImpl implements AbilityService{

	@Resource
	private AbilityDao abilityDao;
}
