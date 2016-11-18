package com.allcam.modules.opensdk.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class OpensdkController {
	
	
	@RequestMapping(value = "open_api_sdk")
    public String openapiList(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "opensdk/opensdkList");
    }
}
