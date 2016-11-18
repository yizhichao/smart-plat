package com.allcam.modules.zone.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.util.StringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.modules.tree.model.State;
import com.allcam.modules.tree.model.TreeNode;
import com.allcam.modules.tree.util.Tree;
import com.allcam.modules.zone.inf.ZoneService;
import com.allcam.modules.zone.model.ZoneInfo;
import com.allcam.pojo.PageBean;
import com.allcam.utils.GV;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.SysCodeBuilderUtil;
import com.allcam.web.controller.BaseController;

@Controller
public class ZoneController extends BaseController
{
    
    @Resource
    ZoneService zoneService;
    
    @RequestMapping(value = "zoneList", method = {RequestMethod.POST, RequestMethod.GET})
    public String zoneList(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        return GV.VV(GV.VIEWS, "zone/zoneList");
    }
    
    @ResponseBody
    @RequestMapping(value = "addZone.json", produces = "application/json", method = {RequestMethod.POST,
        RequestMethod.GET})
    public void addZoneJson(@RequestBody
    final ZoneInfo zoneInfo, HttpServletResponse response)
        throws Exception
    {
        JsonResult jr = new JsonResult();
        try
        {
            zoneInfo.setZoneId(SysCodeBuilderUtil.codeBuilder(SYS_ID, ID_CODE_RESOURCEID));
            if (zoneService.addArea(zoneInfo))
            {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("添加区域失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e)
        {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "modZone.json", produces = "application/json", method = {RequestMethod.POST,
        RequestMethod.GET})
    public void modZoneJson(@RequestBody
    final ZoneInfo zoneInfo, HttpServletResponse response)
        throws Exception
    {
        JsonResult jr = new JsonResult();
        try
        {
            if (zoneService.modArea(zoneInfo))
            {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("添加区域失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e)
        {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "delZone.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void delZoneJson(@RequestParam String zoneId, HttpServletResponse response)
        throws Exception
    {
        
        JsonResult jr = new JsonResult();
        try
        {
            ZoneInfo zoneInfo = new ZoneInfo();
            zoneInfo.setZoneId(zoneId);
            if (zoneService.delArea(zoneInfo))
            {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除区域失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e)
        {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
        
    }
    
    @ResponseBody
    @RequestMapping(value = "getZone.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void getZoneInfoJson(@RequestParam String zoneId, HttpServletResponse response)
        throws Exception
    {
        
        JsonResult jr = new JsonResult();
        try
        {
            ZoneInfo zoneInfo = zoneService.queryZoneInfoByZoneId(zoneId);
            if (null != zoneInfo)
            {
                zoneInfo.setCreateDate(zoneInfo.getCreateDate().substring(0, 19));
                zoneInfo.setLastDate(zoneInfo.getLastDate().substring(0, 19));
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                jr.setBaseInfo(zoneInfo);
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除区域失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e)
        {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
        
    }
    
    @ResponseBody
    @RequestMapping(value = "getZones.json", method = {RequestMethod.POST})
    public void getZoneJson(HttpServletRequest request, HttpServletResponse response, ModelMap model)
        throws Exception
    {
        Tree tree = new Tree();
        State state = new State(0, 0, 0);
        TreeNode root = new TreeNode("0", "", "root", "root", new State(1, 0, 0));
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(1000);
        Map<String, Object> map = new HashMap<String, Object>();
        ZoneInfo zoneInfo = new ZoneInfo();
        map.put("zoneInfo", zoneInfo);
        map.put("pageBean", pageBean);
        List<ZoneInfo> zoneList = zoneService.queryZoneInfoListByPage(map);
        for (ZoneInfo zone : zoneList)
        {
            if (StringUtil.isAllBlank(zone.getParentId()))
            {
                zone.setParentId("root");
            }
            zone.setCreateDate(zone.getCreateDate().substring(0, 19));
            zone.setLastDate(zone.getLastDate().substring(0, 19));
            TreeNode treeNode = new TreeNode(zone.getZoneId(), zone.getParentId(), zone.getZoneName(), "zone", state);
            tree.addNode(treeNode);
        }
        String treeJson = tree.getTreeJson(tree, root);
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(treeJson);
    }
    
}
