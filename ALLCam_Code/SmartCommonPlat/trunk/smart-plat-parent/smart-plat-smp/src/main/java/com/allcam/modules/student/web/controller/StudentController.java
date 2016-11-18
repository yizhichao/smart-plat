package com.allcam.modules.student.web.controller;

import com.allcam.adapter.common.HttpUtil;
import com.allcam.common.ServiceContants;
import com.allcam.modules.abilityInf.student.inf.DeviceStudentService;
import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentReq;
import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentResp;
import com.allcam.modules.bean.bpm.MsgheadInfo;
import com.allcam.modules.bean.bpm.ResultInfo;
import com.allcam.modules.student.inf.StudentService;
import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.pojo.StudentInfo;
import com.allcam.sys.exception.CustomException;
import com.allcam.utils.*;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.web.controller.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登录控制器
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class StudentController extends BaseController implements ServiceContants
{
    public static final Log LOG = LogFactory.getLog(StudentController.class);
    
    public static final Map<String, String> TOKEN_MAP = new ConcurrentHashMap<String, String>();
    
    @Resource
    DeviceStudentService deviceStudentService;
    
    @Resource
    StudentService studentService;
    
    @Resource
    private SyncDataService syncDataService;
    
    @ResponseBody
    @RequestMapping(value = "SYNC_STUDENT", method = {RequestMethod.POST, RequestMethod.GET})
    public void syncStudent(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String sourceIp = HttpUtil.getRemoteAddr(request);
        InputStream requestInputStream = request.getInputStream();
        String requestJson = IOUtils.toString(requestInputStream, "UTF-8");
        LOG.info("HttpServer.doPost requestJson:[" + requestJson + "]");
        String responseJson = null;
        DeviceSyncStudentResp resp = new DeviceSyncStudentResp();
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            // mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
            Map<String, Object> map = mapper.readValue(requestJson, Map.class);
            Object head = map.get(JSON_MSG_HEAD_KEY);
            MsgheadInfo msgHead = mapper.readValue(mapper.writeValueAsString(head), MsgheadInfo.class);
            String msgType = msgHead.getMsgType();
            String direction = msgHead.getDirection();
            // String version = msgHead.getVersion();
            // Object body = map.get(JSON_MSG_BODY_KEY);
            // RequestInfo requestInfo = mapper.readValue(mapper.writeValueAsString(body), RequestInfo.class);
            
            if (StringUtil.isNull(msgType))
            {
                LOG.error("MsgType Is Null.");
                throw new CustomException("MsgType Is Null.");
            }
            if (!HTTP_REQUEST.equals(direction))
            {
                LOG.error("Direction Is Not Correct.");
                throw new CustomException("Direction Is Not Correct.");
            }
            if (SYNC_STUDENT.equalsIgnoreCase(msgType))
            {
                DeviceSyncStudentReq req =
                    (DeviceSyncStudentReq)HttpUtil.parseJsonToBean(map, DeviceSyncStudentReq.class.getName());
                System.out.println(req);
                resp = deviceStudentService.syncStudent(req);
                msgHead.setDirection(HTTP_RESPONSE);
                ResultInfo info = new ResultInfo();
                info.setResultCode(resp.getErrorCode());
                info.setResultDesc(resp.getErrorDes());
                Map<String, Object> respMap = new HashMap<String, Object>();
                respMap.put(JSON_MSG_HEAD_KEY, msgHead);
                respMap.put(JSON_RESULT_KEY, info);
                respMap.put(JSON_MSG_BODY_KEY, resp);
                responseJson = mapper.writeValueAsString(respMap);
                response.setStatus(200);
                String nextnonce = RandomUtil.randomStringa(NONCE_LENGTH);
                response.setHeader("Authentication-Info", "Digest realm=realm@host.com,nextnonce=" + nextnonce + "");
            }
            else
            {
                throw new CustomException("Invalid MsgType");
            }
        }
        catch (CustomException e)
        {
            response.setStatus(500);
            LOG.error("HttpServer CustomException");
            String nonce = RandomUtil.randomStringa(NONCE_LENGTH);
            String opaque = RandomUtil.randomStringa(OPAQUE_LENGTH);
            response.setHeader("WWW-Authenticate", "Digest realm=realm@host.com,qop=auth,nonce=" + nonce + ",opaque="
                + opaque + "");
            responseJson =
                "{\"MsgHead\":{\"version\":\"1.0\",\"direction\":\"response\",\"msgType\":\"COMMON\"},\"Result\":{\"resultCode\":\"1002\",\"resultDesc\":\""
                    + e.getMessage() + "\"}}";
        }
        catch (Exception e)
        {
            response.setStatus(500);
            LOG.error("HttpServer Exception");
            String nonce = RandomUtil.randomStringa(NONCE_LENGTH);
            String opaque = RandomUtil.randomStringa(OPAQUE_LENGTH);
            response.setHeader("WWW-Authenticate", "Digest realm=realm@host.com,qop=auth,nonce=" + nonce + ",opaque="
                + opaque + "");
            responseJson =
                "{\"MsgHead\":{\"version\":\"1.0\",\"direction\":\"response\",\"msgType\":\"COMMON\"},\"Result\":{\"resultCode\":\"1002\",\"resultDesc\":\""
                    + e.getMessage() + "\"}}";
        }
        LOG.info("HttpServer.doPost responseJson:[" + responseJson + "]");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(responseJson);
        out.flush();
        out.close();
    }
    
    @RequestMapping(value = "student_manage", method = {RequestMethod.POST, RequestMethod.GET})
    public String student_manage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        return GV.VV(GV.VIEWS, "student_manage");
    }
    
    @ResponseBody
    @RequestMapping(value = "getStudentList.json", method = {RequestMethod.POST, RequestMethod.GET})
    public String getStudentListJson(@RequestParam
    String aoData, String sEcho)
        throws Exception
    {
        List<StudentInfo> studentList = new ArrayList<StudentInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aoData", new AoData(aoData));
        studentList = studentService.getStudentInfo(map);
        
        int size = studentList.size();
        String[][] data = new String[size][];
        for (int i = 0; i < size; i++)
        {
            StudentInfo student = studentList.get(i);
            if (StringUtils.isNotBlank(student.getLastDate()))
            {
                student.setLastDate(DateUtil.formatTime(DateUtil.timeStr2Date(student.getLastDate(), DateUtil.DATE_14),
                    DateUtil.DATE_19));
            }
            data[i] = student.values();
        }
        int total = studentService.getStudentTotal(map);
        return JSonUtils.toJSon(new DataTableReturnObject(total, total, sEcho, data));
    }
    
    @ResponseBody
    @RequestMapping(value = "syncStudentData.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void syncStudentDataJson(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        JsonResult jr = new JsonResult();
        try
        {
            String sessionId = request.getParameter("sessionId");
            syncDataService.syncStudent(sessionId, "");
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
