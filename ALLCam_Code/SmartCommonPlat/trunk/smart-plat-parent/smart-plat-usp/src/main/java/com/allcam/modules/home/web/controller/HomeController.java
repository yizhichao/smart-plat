package com.allcam.modules.home.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allcam.utils.GV;
import com.allcam.web.controller.BaseController;

@Controller
public class HomeController extends BaseController
{
    
    @RequestMapping(value = "home", method = {RequestMethod.POST, RequestMethod.GET})
    public String zoneList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        return GV.VV(GV.HOME, "index.html");
    }
}
