package com.allcam.modules.ability.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allcam.utils.GV;

@Controller
public class AbilityController {

	@RequestMapping(value = "open_ability_list")
    public String index(HttpServletRequest request)
    {
        return GV.VV(GV.VIEWS, "ability/openAbilityList");
    }
}
