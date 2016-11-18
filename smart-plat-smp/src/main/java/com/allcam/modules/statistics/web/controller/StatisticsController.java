package com.allcam.modules.statistics.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class StatisticsController {

	
	@RequestMapping(value = "app_statistics")
    public String appStatistics(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "statistics/appStatistics");
    }
	
	@RequestMapping(value = "operate_statistics")
    public String operateStatistics(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "statistics/operateStatistics");
    }
}
