package com.allcam.modules.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class AdminController {

	@RequestMapping(value = "admin_list")
    public String index(HttpServletRequest request)
    {
        // return "deviceIndex";
        return GV.VV(GV.VIEWS, "admin/adminList");
    }
}
