package com.allcam.modules.plat.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.modules.plat.inf.PlatService;
import com.allcam.modules.plat.model.PlatInfo;
import com.allcam.pojo.PageBean;
import com.allcam.utils.GV;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.SysCodeBuilderUtil;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.web.controller.BaseController;

@Controller
public class PlatController extends BaseController {

    @Resource
    PlatService platService;

    @RequestMapping(value = "platList", method = {RequestMethod.POST, RequestMethod.GET})
    public String platList(HttpServletRequest request,
                           HttpServletResponse response,
                           ModelMap model) {
        return GV.VV(GV.VIEWS, "plat/platList");
    }

    @RequestMapping(value = "preAddPlat", method = {RequestMethod.POST, RequestMethod.GET})
    public String preAddPlat(@RequestParam String zoneId,
                             @RequestParam String zoneName,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             ModelMap model) {
        request.setAttribute("zoneId", zoneId);
        request.setAttribute("zoneName", zoneName);
        return GV.VV(GV.VIEWS, "plat/addPlat");
    }

    @ResponseBody
    @RequestMapping(value = "getZonePlatList.json",
            method = {RequestMethod.POST, RequestMethod.GET})
    public String getZonePlatJson(@RequestParam String aoData, String sEcho) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aoData", new AoData(aoData));
        List<PlatInfo> list = platService.queryPlatInfoList(map);
        int size = list.size();
        String[][] data = new String[size][];
        for (int i = 0; i < size; i++) {
            PlatInfo info = list.get(i);
            info.setCreateDate(info.getCreateDate().substring(0, 19));
            info.setLastDate(info.getLastDate().substring(0, 19));
            data[i] = info.values();
        }
        int total = platService.queryPlatInfoTotal(map);
        return JSonUtils.toJSon(new DataTableReturnObject(total, total, sEcho, data));
    }

    @RequestMapping(value = "addPlat", method = {RequestMethod.POST, RequestMethod.GET})
    public String addPlat(@ModelAttribute final PlatInfo platInfo,
                          HttpServletRequest request,
                          HttpServletResponse response)
            throws Exception {
        try {
            // PlatInfo platInfo = new PlatInfo();
            platInfo.setPlatId(SysCodeBuilderUtil.codeBuilder(SYS_ID, ID_CODE_RESOURCEID));
            if (platService.addPlat(platInfo)) {
                response.setContentType("text/html; charset=utf-8");
            } else {
                response.setContentType("text/html; charset=utf-8");
            }
        }
        catch (Exception e) {
            response.setContentType("text/html; charset=utf-8");
        }
        return GV.VV(GV.VIEWS, "plat/platList");
    }

    @ResponseBody
    @RequestMapping(value = "modPlat.json", produces = "application/json",
            method = {RequestMethod.POST, RequestMethod.GET})
    public void modPlatJson(@ModelAttribute final PlatInfo platInfo, HttpServletResponse response)
            throws Exception {
        JsonResult jr = new JsonResult();
        try {
            if (platService.modPlat(platInfo)) {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            } else {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("添加平台失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e) {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
    }

    @ResponseBody
    @RequestMapping(value = "delPlat.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void delPlatJson(@RequestParam String platId, HttpServletResponse response)
            throws Exception {

        JsonResult jr = new JsonResult();
        try {
            PlatInfo platInfo = new PlatInfo();
            platInfo.setPlatId(platId);
            if (platService.delPlat(platInfo)) {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            } else {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除平台失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e) {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }

    }

    @ResponseBody
    @RequestMapping(value = "getPlat.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void getPlatInfoJson(@RequestParam String PlatId, HttpServletResponse response)
            throws Exception {

        JsonResult jr = new JsonResult();
        try {
            PlatInfo platInfo = platService.queryPlatInfoByPlatId(PlatId);
            if (null != platInfo) {
                platInfo.setCreateDate(platInfo.getCreateDate().substring(0, 19));
                platInfo.setLastDate(platInfo.getLastDate().substring(0, 19));
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                jr.setBaseInfo(platInfo);
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            } else {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除平台失败");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
        }
        catch (Exception e) {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }

    }

    @ResponseBody
    @RequestMapping(value = "getPlats.json", method = {RequestMethod.POST})
    public void getPlatJson(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model)
            throws Exception {
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(1000);
        Map<String, Object> map = new HashMap<String, Object>();
        PlatInfo platInfo = new PlatInfo();
        map.put("platInfo", platInfo);
        map.put("pageBean", pageBean);
        List<PlatInfo> platList = platService.queryPlatInfoListByPage(map);
        for (PlatInfo plat : platList) {
            plat.setCreateDate(plat.getCreateDate().substring(0, 19));
            plat.setLastDate(plat.getLastDate().substring(0, 19));
        }
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSonUtils.toJSon(platList));
    }
}
