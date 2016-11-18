package com.allcam.modules.group.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.modules.group.inf.GroupService;
import com.allcam.modules.group.model.GroupInfo;
import com.allcam.utils.GV;
import com.allcam.utils.JsonResult;
import com.allcam.web.controller.BaseController;

@Controller
public class GroupController extends BaseController{

	@Resource
	GroupService groupService;
	
	@RequestMapping(value = "groupGroup")
	public String groupGroup(HttpServletRequest request) {
		// return "groupIndex";
		return GV.VV(GV.VIEWS, "dev/groupGroup");
	}
	
	@RequestMapping(value = "preAddDevGroup", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String allocate(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("clientId", request.getParameter("clientId"));
		return GV.VV(GV.VIEWS, "group/addDevGroup");
	}
	
	@RequestMapping(value = "addDevGroup", produces = "application/json", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void addDevGroup(@ModelAttribute final GroupInfo groupInfo,
			HttpServletRequest request) throws Exception {
		JsonResult jr = new JsonResult();
		Map<String,String>map=new HashMap<String, String>();
		try {
			if (groupService.insert(groupInfo,map)>0) {
				JsonResult.jsonResult(jr, response, JsonResult.SUCCESS);
			} else {
				JsonResult.jsonResult(jr, response, JsonResult.CUSTOM_ERROR);
			}
		} catch (Exception e) {
			JsonResult.jsonResult(jr, response, JsonResult.CUSTOM_ERROR);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "delGroup", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void delGroupJson(@RequestParam String Id,
			HttpServletResponse response) throws Exception {

		JsonResult jr = new JsonResult();
		try {
			List<String> ids = Arrays.asList(Id.split(","));
			if (groupService.delGroupInfo(ids)> 0) {
				JsonResult.jsonResult(jr, response, JsonResult.SUCCESS);
			} else {
				JsonResult.jsonResult(jr, response, JsonResult.ERROR);
			}
		} catch (Exception e) {
			JsonResult.jsonResult(jr, response, JsonResult.ERROR);
		}

	}
}
