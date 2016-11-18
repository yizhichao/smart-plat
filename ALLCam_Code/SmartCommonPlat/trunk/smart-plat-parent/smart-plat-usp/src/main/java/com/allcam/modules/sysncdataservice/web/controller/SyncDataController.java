package com.allcam.modules.sysncdataservice.web.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.web.controller.BaseController;

@Controller
public class SyncDataController extends BaseController
{
    public static final Log LOG = LogFactory.getLog(SyncDataController.class);
    
    public static final Map<String, String> TOKEN_MAP = new ConcurrentHashMap<String, String>();
    
    @Resource
    private SyncDataService syncDataService;
    
    // 同步数据管理
    // 1.同步学校
    // 2.同步老师
    // 3.同步学生
    
    @RequestMapping(value = "SYNC_SCHOOL_BPM", method = {RequestMethod.POST, RequestMethod.GET})
    // 用来处理前台的login请求 //@ResponseBody
    private String syncSchool(@RequestParam(value = "schoolId", required = false)
    String schoolId, @RequestParam(value = "schoolName", required = false)
    String schoolName)
    {
        // return "Hello " + userName + ",Your password is: " + passWord;
        try
        {
            String sessionId = request.getParameter("sessionId");
            syncDataService.syncSchool(sessionId, schoolId, schoolName);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "main";
        
        // return "redirect:/main.jsp";
    }
    
    @RequestMapping(value = "SYNC_TEACHER_BPM", method = {RequestMethod.POST, RequestMethod.GET})
    // 用来处理前台的login请求 //@ResponseBody
    private String syncTeacher(@RequestParam(value = "schoolId", required = false)
    String schoolId)
    {
        // return "Hello " + userName + ",Your password is: " + passWord;
        try
        {
            syncDataService.syncTeacher("",schoolId);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "main";
        
        // return "redirect:/main.jsp";
    }
    
    @RequestMapping(value = "SYNC_STUDENT_BPM", method = {RequestMethod.POST, RequestMethod.GET})
    // 用来处理前台的login请求 //@ResponseBody
    private String syncStudent(@RequestParam(value = "schoolId", required = false)
    String schoolId)
    {
        // return "Hello " + userName + ",Your password is: " + passWord;
        try
        {
            syncDataService.syncStudent("", schoolId);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "main";
        
        // return "redirect:/main.jsp";
    }
}
