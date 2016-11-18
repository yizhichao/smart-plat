package com.allcam.modules.app.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class AppController {
	
	@RequestMapping(value = "app_list")
    public String appList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "app/appList");
    }
}
