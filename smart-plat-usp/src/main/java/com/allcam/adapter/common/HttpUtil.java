package com.allcam.adapter.common;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.allcam.common.ServiceContants;
import com.allcam.modules.bean.bpm.MsgheadInfo;
import com.allcam.modules.bean.bpm.ResultInfo;
import com.allcam.sys.exception.MessageCode;
import com.allcam.utils.Env;
import com.allcam.utils.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil implements ServiceContants, MessageCode
{
    public static final Log LOG = LogFactory.getLog(HttpUtil.class);
    
    public static final Map<String, String> Arrears_OpenFunction = new HashMap<String, String>();
    
    static
    {
        // 绑定 解绑 获取平台信息 获取用户信息
        Arrears_OpenFunction.put("BIND_ACCOUNT", "BIND_ACCOUNT");
        Arrears_OpenFunction.put("UNBIND_ACCOUNT", "UNBIND_ACCOUNT");
        Arrears_OpenFunction.put("GET_PLAT_INFO", "GET_PLAT_INFO");
        Arrears_OpenFunction.put("GET_USER_INFO", "GET_USER_INFO");
        Arrears_OpenFunction.put("GET_SMS_VALI_CODE", "GET_SMS_VALI_CODE");
        Arrears_OpenFunction.put("POST_PUSH_INFO", "POST_PUSH_INFO");
        
        // 套餐订购
        Arrears_OpenFunction.put("QUERY_USER_SUB_STATUS", "QUERY_USER_SUB_STATUS");
        Arrears_OpenFunction.put("QUERY_CAN_SUB_PACKAGE", "QUERY_CAN_SUB_PACKAGE");
        Arrears_OpenFunction.put("ORDER_CALC_PRICE", "ORDER_CALC_PRICE");
        Arrears_OpenFunction.put("ORDER_PACKAGE", "ORDER_PACKAGE");
        Arrears_OpenFunction.put("QRY_SERVICE_ORDER_INFO", "QRY_SERVICE_ORDER_INFO");
        Arrears_OpenFunction.put("QUERY_MY_SUB_PACKAGE", "QUERY_MY_SUB_PACKAGE");
        
        // 邀请家庭成员 获取短信通知
        Arrears_OpenFunction.put("INVITE_FAMILY_MEMBER", "INVITE_FAMILY_MEMBER");
        Arrears_OpenFunction.put("GET_FAMILY_MEMBER_LIST", "GET_FAMILY_MEMBER_LIST");
        Arrears_OpenFunction.put("MOD_FAMILY_MEMBER_INFO", "MOD_FAMILY_MEMBER_INFO");
        
        // 通用功能
        Arrears_OpenFunction.put("POST_FEEDBACK", "POST_FEEDBACK");
        Arrears_OpenFunction.put("ABOUT_INFO", "ABOUT_INFO");
        Arrears_OpenFunction.put("CHECK_VERSION_UPGRADE", "CHECK_VERSION_UPGRADE");
        // old
        Arrears_OpenFunction.put("CHECK_SYS_VERSION", "CHECK_SYS_VERSION");
        Arrears_OpenFunction.put("GET_RESOURCE", "GET_RESOURCE");
    }
    
    /**
     * 判断IP是否有访问权限
     * 
     * @param clientIp 调用者客户端IP
     * @return 返回是否有权限
     * @see [类、类#方法、类#成员]
     */
    public static boolean isRequestIpRightful(String clientIp)
    {
        boolean mcuIpRightFul = false;
        try
        {
            LOG.info("the request requetIp Ip is[" + clientIp + "]");
            
            String supportType = Env.getWebCommon().get("allowRefuseIpConf/supportType");
            
            LOG.info("the supportType configed in the web_common.xml is [" + supportType + "]");
            if ("1".equals(supportType))
            {
                mcuIpRightFul = true;
            }
            else if ("2".equals(supportType))
            {
                mcuIpRightFul = checkAllowIp(clientIp);
            }
            else if ("3".equals(supportType))
            {
                mcuIpRightFul = checkRefuseIp(clientIp);
            }
            else
            {
                LOG.error("the supportType configed in the web_common.xml [" + supportType + "] is wrong");
            }
            LOG.info("the request requetIp Ip isRightful=" + mcuIpRightFul);
        }
        catch (Exception ex)
        {
            LOG.error("Occur an Exception when checkReqiestIpIsRightful");
        }
        return mcuIpRightFul;
    }
    
    private static boolean checkRefuseIp(String requetIp)
    {
        boolean ipRightFul = true;
        
        String supportIP = Env.getWebCommon().get("allowRefuseIpConf/refuseIP");
        LOG.info("the refuse configed in the web_common.xml is [" + supportIP + "]");
        if (!StringUtil.isNull(supportIP))
        {
            String[] supportIpArr = supportIP.split(",");
            String configIp = null;
            for (int i = 0; i < supportIpArr.length; i++)
            {
                configIp = supportIpArr[i];
                if (isRequetIpConfiged(requetIp, configIp))
                {
                    ipRightFul = false;
                    break;
                }
            }
        }
        return ipRightFul;
    }
    
    private static boolean checkAllowIp(String requetIp)
    {
        boolean ipRightFul = false;
        
        String supportIP = Env.getWebCommon().get("allowRefuseIpConf/supportIP");
        LOG.info("the supportIP configed in the web_common.xml is [" + supportIP + "]");
        if (!StringUtil.isNull(supportIP))
        {
            String[] supportIpArr = supportIP.split(",");
            String configIp = null;
            for (int i = 0; i < supportIpArr.length; i++)
            {
                configIp = supportIpArr[i];
                if (isRequetIpConfiged(requetIp, configIp))
                {
                    ipRightFul = true;
                    break;
                }
            }
        }
        return ipRightFul;
    }
    
    private static boolean isRequetIpConfiged(String requetIp, String configIp)
    {
        boolean requestIpSupported = false;
        if ((!StringUtil.isNull(requetIp)) && (!StringUtil.isNull(configIp)))
        {
            int matchStrLocation = configIp.indexOf("*");
            if (-1 != matchStrLocation)
            {
                configIp = configIp.substring(0, matchStrLocation);
            }
            requestIpSupported = requetIp.startsWith(configIp);
        }
        return requestIpSupported;
    }
    
    /**
     * 获取客户端IP地址.<br>
     * 支持多级反向代理
     * 
     * @param request HttpServletRequest
     * @return 客户端真实IP地址
     */
    public static String getRemoteAddr(final HttpServletRequest request)
    {
        try
        {
            String remoteAddr = request.getHeader("X-Forwarded-For");
            // 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
            if (isEffective(remoteAddr) && (remoteAddr.indexOf(",") > -1))
            {
                String[] array = remoteAddr.split(",");
                for (String element : array)
                {
                    if (isEffective(element))
                    {
                        remoteAddr = element;
                        break;
                    }
                }
            }
            if (!isEffective(remoteAddr))
            {
                remoteAddr = request.getHeader("X-Real-IP");
            }
            if (!isEffective(remoteAddr))
            {
                remoteAddr = request.getRemoteAddr();
            }
            return remoteAddr;
        }
        catch (Exception e)
        {
            LOG.error("get romote ip error,error message:" + e.getMessage());
            return "";
        }
    }
    
    /**
     * 远程地址是否有效.
     * 
     * @param remoteAddr 远程地址
     * @return true代表远程地址有效，false代表远程地址无效
     */
    public static boolean isEffective(final String remoteAddr)
    {
        boolean isEffective = false;
        if ((null != remoteAddr) && (!"".equals(remoteAddr.trim())) && (!"unknown".equalsIgnoreCase(remoteAddr.trim())))
        {
            isEffective = true;
        }
        return isEffective;
    }
    
    public static boolean isDevType(String devType)
    {
        Pattern pattern = Pattern.compile("[0|1|2|3|4|5]");
        Matcher match = pattern.matcher(devType);
        return match.matches();
    }
    
    public static boolean isConMsgType(String conType)
    {
        Pattern pattern = Pattern.compile("[0|1]");
        Matcher match = pattern.matcher(conType);
        return match.matches();
    }
    
    /**
     * 构建鉴权失败的响应Json
     * 
     * @param respInfo
     * @return
     * @throws JsonProcessingException 自定义异常
     * @see [类、类#方法、类#成员]
     */
    public static String buildAuthFailRespJson(MsgheadInfo msg)
        throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        MsgheadInfo headInfo = new MsgheadInfo();
        headInfo.setDirection(HTTP_RESPONSE);
        headInfo.setMsgType(msg.getMsgType());
        headInfo.setVersion(msg.getVersion());
        ResultInfo info = new ResultInfo();
        info.setResultCode(AUTH_FAIL_CODE);
        info.setResultDesc(AUTH_FAIL_DES);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(JSON_MSG_HEAD_KEY, headInfo);
        map.put(JSON_RESULT_KEY, info);
        String jsonResult = mapper.writeValueAsString(map);
        return jsonResult;
    }
    
    /**
     * 构建用户名或密码错误的响应Json
     * 
     * @param respInfo
     * @return
     * @throws JsonProcessingException 自定义异常
     * @see [类、类#方法、类#成员]
     */
    public static String buildLoginFailRespJson(MsgheadInfo msg)
        throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        MsgheadInfo headInfo = new MsgheadInfo();
        headInfo.setDirection(HTTP_RESPONSE);
        headInfo.setMsgType(msg.getMsgType());
        headInfo.setVersion(msg.getVersion());
        ResultInfo info = new ResultInfo();
        info.setResultCode(USERNAME_OR_PWD_ERROR);
        info.setResultDesc(USERNAME_OR_PWD_ERROR_DES);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(JSON_MSG_HEAD_KEY, headInfo);
        map.put(JSON_RESULT_KEY, info);
        String jsonResult = mapper.writeValueAsString(map);
        return jsonResult;
    }
    
    /**
     * 构建用户套餐欠费的响应Json
     * 
     * @param respInfo
     * @return
     * @throws JsonProcessingException 自定义异常
     * @see [类、类#方法、类#成员]
     */
    public static String buildUserDeficitRespJson(MsgheadInfo msg)
        throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        MsgheadInfo headInfo = new MsgheadInfo();
        headInfo.setDirection(HTTP_RESPONSE);
        headInfo.setMsgType(msg.getMsgType());
        headInfo.setVersion(msg.getVersion());
        ResultInfo info = new ResultInfo();
        info.setResultCode(USER_IN_DEFICIT);
        info.setResultDesc(USER_IN_DEFICIT_DES);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(JSON_MSG_HEAD_KEY, headInfo);
        map.put(JSON_RESULT_KEY, info);
        String jsonResult = mapper.writeValueAsString(map);
        return jsonResult;
    }
    
    /**
     * 构建用户被停用的响应Json
     * 
     * @param respInfo
     * @return
     * @throws JsonProcessingException 自定义异常
     * @see [类、类#方法、类#成员]
     */
    public static String buildUserDisabledRespJson(MsgheadInfo msg)
        throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        MsgheadInfo headInfo = new MsgheadInfo();
        headInfo.setDirection(HTTP_RESPONSE);
        headInfo.setMsgType(msg.getMsgType());
        headInfo.setVersion(msg.getVersion());
        ResultInfo info = new ResultInfo();
        info.setResultCode(USER_DISABLED);
        info.setResultDesc(USER_DISABLED_DES);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(JSON_MSG_HEAD_KEY, headInfo);
        map.put(JSON_RESULT_KEY, info);
        String jsonResult = mapper.writeValueAsString(map);
        return jsonResult;
    }
    
    /**
     * 构建鉴权成功的响应Json
     * 
     * @param respInfo
     * @return
     * @throws JsonProcessingException 自定义异常
     * @see [类、类#方法、类#成员]
     */
    // public static String buildAuthSuccRespJson(MsgheadInfo msg)
    // throws JsonProcessingException
    // {
    // ObjectMapper mapper = new ObjectMapper();
    // MsgheadInfo headInfo = new MsgheadInfo();
    // headInfo.setDirection(HTTP_RESPONSE);
    // headInfo.setMsgType(msg.getMsgType());
    // headInfo.setVersion(msg.getVersion());
    // ResultInfo info = new ResultInfo();
    // info.setResultCode(SUCCESS_CODE);
    // info.setResultDesc(SUCCESS_DES);
    // Map<String, Object> map = new HashMap<String, Object>();
    // map.put(JSON_MSG_HEAD_KEY, headInfo);
    // map.put(JSON_RESULT_KEY, info);
    // String jsonResult = mapper.writeValueAsString(map);
    // return jsonResult;
    // }
    
    // /**
    // * 构造返回的result对象
    // *
    // * @param object
    // * @return
    // */
    // public static ResultInfo bulidMap(Object object)
    // {
    // ResultInfo resultInfo = new ResultInfo();
    // if (object != null)
    // {
    // resultInfo.setResultCode(SUCCESS_CODE);
    // resultInfo.setResultDesc(SUCCESS_DES);
    // }
    // else
    // {
    // resultInfo.setResultCode(FAIL_CODE);
    // resultInfo.setResultDesc(FAIL_DES);
    // }
    // return resultInfo;
    // }
    
    public static String inputStreamToString(InputStream is, String encoding)
    {
        try
        {
            byte[] b = new byte[1024];
            String res = "";
            if (is == null)
            {
                return "";
            }
            
            int bytesRead = 0;
            while (true)
            {
                bytesRead = is.read(b, 0, 1024); // return final read bytes
                // counts
                if (bytesRead == -1)
                {// end of InputStream
                    return res;
                }
                res += new String(b, 0, bytesRead, encoding); // convert to
                // string using
                // bytes
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Exception: " + e);
            LOG.error("inputStreamToString Exception", e);
            return "";
        }
    }
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object parseJsonToBean(Map map, String classType)
        throws Exception
    {
        Object objClass = null;
        try
        {
            
            ObjectMapper mapper = new ObjectMapper();
            Class<?> clazz = Class.forName(classType);
            objClass = clazz.newInstance();
            Class<?> fatherClazz = clazz.getSuperclass();
            Field field[] = clazz.getDeclaredFields();
            Field fatherField[] = fatherClazz.getDeclaredFields();
            field = (Field[])ArrayUtils.addAll(field, fatherField);
            Map<String, String> headMap = new LinkedHashMap<String, String>();
            headMap = mapper.readValue(mapper.writeValueAsString(map.get(JSON_MSG_HEAD_KEY)), LinkedHashMap.class);
            Map<String, String> bodyMap = new LinkedHashMap<String, String>();
            bodyMap = mapper.readValue(mapper.writeValueAsString(map.get(JSON_MSG_BODY_KEY)), LinkedHashMap.class);
            int length = field.length;
            for (int i = 0; i < length; i++)
            {
                Field f = field[i];
                String fieldName = f.getName();
                if (headMap.containsKey(fieldName))
                {
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method setMethod = clazz.getMethod(setMethodName, new Class[] {f.getType()});
                    setMethod.invoke(objClass,
                        new Object[] {null == headMap.get(fieldName) ? null : String.valueOf(headMap.get(fieldName))});
                }
                else if (bodyMap.containsKey(fieldName))
                {
                    String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Method setMethod = clazz.getMethod(setMethodName, new Class[] {f.getType()});
                    setMethod.invoke(objClass,
                        new Object[] {null == bodyMap.get(fieldName) ? null : String.valueOf(bodyMap.get(fieldName))});
                }
            }
        }
        catch (Exception e)
        {
            throw new Exception("HttpServer.parseJsonToBean() Error!");
        }
        return objClass;
    }
    
    // /**
    // * 记录用户操作日志
    // *
    // * @param req
    // * @param resultCode
    // * @param response
    // * @param sourceIp
    // */
    // public static void recordUserOperLog(RequestInfo req, String resultCode, String response, String sourceIp)
    // {
    // Connection conn = null;
    // String sql =
    // "INSERT INTO tbl_user_logs(USERID,SOURCEIP,USERLAN,CUTYPE,CUVERSION,SYSTEMVERSION,MSGTYPE,RESULTCODE,RESPONSE,OPERATETIME,USERNAME,MOBILE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    // try
    // {
    // conn = DBConnFactory.getSmsDbConnection();
    // Object[] obj = new Object[12];
    // obj[0] = req.getUserId();
    // obj[1] = sourceIp;
    // obj[2] = req.getUserLan();
    // obj[3] = req.getCuType();
    // obj[4] = req.getCuVersion();
    // obj[5] = req.getSystemVersion();
    // obj[6] = req.getMsgType();
    // obj[7] = resultCode;
    // obj[8] = response;
    // obj[9] = DateUtil.formatTime(new Date(), DateUtil.DATE_14);
    // obj[10] = req.getUserName();
    // obj[11] = req.getUserNameAuth();
    // DBProc.update(sql, obj, conn, true, false);
    // }
    // catch (Exception e)
    // {
    // LOG.error("HttpUtil.recordUserOperLog().Exception", e);
    // }
    // finally
    // {
    // DBProc.closeConnection(conn);
    // }
    // }
}
