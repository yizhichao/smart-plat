package com.allcam.modules.sysversion.web.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.adapter.common.HttpUtil;
import com.allcam.common.ServiceContants;
import com.allcam.modules.abilityInf.sysversion.inf.CheckSysVersionService;
import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionReq;
import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionResp;
import com.allcam.modules.bean.bpm.MsgheadInfo;
import com.allcam.modules.bean.bpm.ResultInfo;
import com.allcam.modules.student.web.controller.StudentController;
import com.allcam.sys.exception.CustomException;
import com.allcam.utils.RandomUtil;
import com.allcam.utils.StringUtil;
import com.allcam.web.controller.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登录控制器
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class SysVersionController extends BaseController implements ServiceContants
{
    public static final Log LOG = LogFactory.getLog(StudentController.class);
    
    public static final Map<String, String> TOKEN_MAP = new ConcurrentHashMap<String, String>();
    
    @Resource
    private CheckSysVersionService checkSysVersionService;
    
    @ResponseBody
    @RequestMapping(value = "CHECK_VERSION_UPGRADE", method = {RequestMethod.POST, RequestMethod.GET})
    public void checkVersionUpgrade(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String sourceIp = HttpUtil.getRemoteAddr(request);
        InputStream requestInputStream = request.getInputStream();
        String requestJson = IOUtils.toString(requestInputStream, "UTF-8");
        LOG.info("HttpServer.doPost requestJson:[" + requestJson + "]");
        String responseJson = null;
        CheckSysVersionResp resp = new CheckSysVersionResp();
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
            if (CHECK_VERSION_UPGRADE.equalsIgnoreCase(msgType))
            {
                CheckSysVersionReq req =
                    (CheckSysVersionReq)HttpUtil.parseJsonToBean(map, CheckSysVersionReq.class.getName());
                System.out.println(req);
                resp = checkSysVersionService.checkSysVersion(req);
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
        // MsgHeadResp msgHeadResp = new MsgHeadResp();
        // msgHeadResp.setMsgType("DEV_REG");
        // ResultInfo resultInfo = new ResultInfo();
        // resultInfo.setResultCode(ServiceContants.SUCCESS_CODE);
        // resultInfo.setResultDesc(ServiceContants.SUCCESS_DES);
        // resp.setMsgHeadResp(msgHeadResp);
        // resp.setResultInfo(resultInfo);
    }
    
}
