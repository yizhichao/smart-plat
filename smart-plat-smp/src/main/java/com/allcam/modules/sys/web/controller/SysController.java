package com.allcam.modules.sys.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class SysController {
	@RequestMapping(value = "sys_log")
    public String sysLogList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "sys/sysLogList");
    }
	
	@RequestMapping(value = "sys_status")
    public String sysStatusList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "sys/sysStatusList");
    }
	
	@RequestMapping(value = "sys_load")
    public String sysLoadList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "sys/sysLoadList");
    }
	
	@RequestMapping(value = "sys_env")
    public String sysEnvList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "sys/sysEnvList");
    }
	
	
}
