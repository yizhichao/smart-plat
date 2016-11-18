package com.allcam.modules.client.web.controller;

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

import com.allcam.modules.client.inf.ClientService;
import com.allcam.modules.client.model.ClientInfo;
import com.allcam.pojo.PageBean;
import com.allcam.utils.GV;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.SysCodeBuilderUtil;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.web.controller.BaseController;

@Controller
public class ClientController extends BaseController
{
    @Resource
    ClientService clientService;
    
    @RequestMapping(value = "clientList", method = {RequestMethod.POST, RequestMethod.GET})
    public String device_allocate(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        return GV.VV(GV.VIEWS, "client/clientList");
    }
    
    @RequestMapping(value = "preAddClient", method = {RequestMethod.POST, RequestMethod.GET})
    public String preAddClient(@RequestParam String zoneId, @RequestParam String zoneName, HttpServletRequest request,
        HttpServletResponse response, ModelMap model)
    {
        request.setAttribute("zoneId", zoneId);
        request.setAttribute("zoneName", zoneName);
        return GV.VV(GV.VIEWS, "client/addClient");
    }
    
    @ResponseBody
    @RequestMapping(value = "getZoneClientList.json", method = {RequestMethod.POST, RequestMethod.GET})
    public String getZoneClientJson(@RequestParam String aoData, String sEcho)
        throws Exception
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aoData", new AoData(aoData));
        List<ClientInfo> list = clientService.queryClientInfoList(map);
        int size = list.size();
        String[][] data = new String[size][];
        for (int i = 0; i < size; i++)
        {
            ClientInfo info = list.get(i);
            info.setCreateDate(info.getCreateDate().substring(0, 19));
            info.setLastDate(info.getLastDate().substring(0, 19));
            data[i] = info.values();
        }
        int total = clientService.queryClientInfoTotal(map);
        return JSonUtils.toJSon(new DataTableReturnObject(total, total, sEcho, data));
    }
    
    @RequestMapping(value = "addClient", method = {RequestMethod.POST, RequestMethod.GET})
    public String addClient(@ModelAttribute
    final ClientInfo clientInfo, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        try
        {
            clientInfo.setClientId(SysCodeBuilderUtil.codeBuilder(SYS_ID, ID_CODE_RESOURCEID));
            if (clientService.addClient(clientInfo))
            {
                response.setContentType("text/html; charset=utf-8");
            }
            else
            {
                response.setContentType("text/html; charset=utf-8");
            }
        }
        catch (Exception e)
        {
            response.setContentType("text/html; charset=utf-8");
        }
        return GV.VV(GV.VIEWS, "client/clientList");
    }
    
    @ResponseBody
    @RequestMapping(value = "modClient.json", produces = "application/json", method = {RequestMethod.POST,
        RequestMethod.GET})
    public void modClientJson(@ModelAttribute
    final ClientInfo clientInfo, HttpServletResponse response)
        throws Exception
    {
        JsonResult jr = new JsonResult();
        try
        {
            if (clientService.modClient(clientInfo))
            {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("添加客户失败");
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
    @RequestMapping(value = "delClient.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void delClientJson(@RequestParam String clientId, HttpServletResponse response)
        throws Exception
    {
        
        JsonResult jr = new JsonResult();
        try
        {
            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setClientId(clientId);
            if (clientService.delClient(clientInfo))
            {
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除客户失败");
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
    @RequestMapping(value = "getClient.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void getClientInfoJson(@RequestParam String clientId, HttpServletResponse response)
        throws Exception
    {
        
        JsonResult jr = new JsonResult();
        try
        {
            ClientInfo clientInfo = clientService.queryClientInfoByClientId(clientId);
            if (null != clientInfo)
            {
                clientInfo.setCreateDate(clientInfo.getCreateDate().substring(0, 19));
                clientInfo.setLastDate(clientInfo.getLastDate().substring(0, 19));
                jr.setResultCode(JsonResult.SUCCESS);
                jr.setResultMessage("操作成功");
                jr.setBaseInfo(clientInfo);
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write(JSonUtils.toJSon(jr));
            }
            else
            {
                jr.setResultCode(JsonResult.CUSTOM_ERROR);
                jr.setResultMessage("删除客户失败");
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
    @RequestMapping(value = "getClients.json", method = {RequestMethod.POST})
    public void getClientJson(HttpServletRequest request, HttpServletResponse response, ModelMap model)
        throws Exception
    {
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(1000);
        Map<String, Object> map = new HashMap<String, Object>();
        ClientInfo clientInfo = new ClientInfo();
        map.put("clientInfo", clientInfo);
        map.put("pageBean", pageBean);
        List<ClientInfo> clientList = clientService.queryClientInfoListByPage(map);
        for (ClientInfo client : clientList)
        {
            client.setCreateDate(client.getCreateDate().substring(0, 19));
            client.setLastDate(client.getLastDate().substring(0, 19));
        }
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSonUtils.toJSon(clientList));
    }
}
