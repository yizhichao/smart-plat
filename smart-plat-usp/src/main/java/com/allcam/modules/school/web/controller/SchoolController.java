package com.allcam.modules.school.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.modules.school.inf.SchoolService;
import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.pojo.SchoolInfo;
import com.allcam.utils.GV;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.web.controller.BaseController;

@Controller
public class SchoolController extends BaseController
{
    public static final Log LOG = LogFactory.getLog(SchoolController.class);
    
    @Resource
    SchoolService schoolService;
    
    @Resource
    private SyncDataService syncDataService;
    
    @RequestMapping(value = "school_manage", method = {RequestMethod.POST, RequestMethod.GET})
    public String school_manage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        return GV.VV(GV.VIEWS, "school_manage");
    }
    
    @ResponseBody
    @RequestMapping(value = "getSchoolList.json", method = {RequestMethod.POST, RequestMethod.GET})
    public String getSchoolListJson(@RequestParam
    String aoData, String sEcho)
        throws Exception
    {
        List<SchoolInfo> schoolList = new ArrayList<SchoolInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aoData", new AoData(aoData));
        schoolList = schoolService.getSchoolInfo(map);
        
        int size = schoolList.size();
        String[][] data = new String[size][];
        for (int i = 0; i < size; i++)
        {
            SchoolInfo school = schoolList.get(i);
            data[i] = school.values();
        }
        int total = schoolService.getSchoolTotal(map);
        return JSonUtils.toJSon(new DataTableReturnObject(total, total, sEcho, data));
    }
    
    @ResponseBody
    @RequestMapping(value = "syncSchoolData.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void syncSchoolDataJson(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        JsonResult jr = new JsonResult();
        try
        {
            String sessionId = request.getParameter("sessionId");
            syncDataService.syncSchool(sessionId,"", "");
            jr.setResultCode(JsonResult.SUCCESS);
            jr.setResultMessage("操作成功");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
        catch (Exception e)
        {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
    }
}
