package com.allcam.modules.user.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.allcam.adapter.common.HttpUtil;
import com.allcam.common.ServiceContants;
import com.allcam.framework.security.MyExUsernamePasswordToken;
import com.allcam.log.SystemControllerLog;
import com.allcam.modules.abilityInf.user.inf.DeviceTeacherService;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherReq;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherResp;
import com.allcam.modules.admin.inf.AdminService;
import com.allcam.modules.admin.model.AdminInfo;
import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.bean.bpm.MsgheadInfo;
import com.allcam.modules.bean.bpm.ResultInfo;
import com.allcam.modules.demo.inf.DemoService;
import com.allcam.modules.menu.inf.MenuService;
import com.allcam.modules.menu.model.MenuInfo;
import com.allcam.modules.mobile.model.AuthLoginReq;
import com.allcam.modules.mobile.model.AuthLoginReqBody;
import com.allcam.modules.mobile.model.AuthLoginRes;
import com.allcam.modules.mobile.model.AuthLoginResUserInfo;
import com.allcam.modules.mobile.model.GetSchoolsReq;
import com.allcam.modules.mobile.model.GetSchoolsReqBody;
import com.allcam.modules.mobile.model.GetSchoolsRes;
import com.allcam.modules.mobile.model.GetSchoolsResSchooInfo;
import com.allcam.modules.sysncdataservice.inf.SyncDataService;
import com.allcam.modules.user.inf.UserService;
import com.allcam.sys.exception.CustomException;
import com.allcam.utils.Base64;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.DASASEEncryptUtil;
import com.allcam.utils.DateUtil;
import com.allcam.utils.Des3Util;
import com.allcam.utils.GV;
import com.allcam.utils.HttpRequestDeviceUtils;
import com.allcam.utils.HttpRequestUtil;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.JsonResult;
import com.allcam.utils.RandomUtil;
import com.allcam.utils.StringUtil;
import com.allcam.utils.SystemConstant;
import com.allcam.utils.datatable.AoData;
import com.allcam.utils.datatable.DataTableReturnObject;
import com.allcam.web.controller.BaseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raising.framework.exception.ServiceException;
import com.raising.system.framework.enums.Enums.LoginResult;
import com.raising.system.framework.enums.Enums.UserType;

/**
 * 登录控制器
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
public class UserController extends BaseController implements ServiceContants {
    public static final Log LOG = LogFactory.getLog(UserController.class);

    public static final Map<String, String> TOKEN_MAP = new ConcurrentHashMap<String, String>();

    @Resource
    private DeviceTeacherService deviceTeacherService;

    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Resource
    private MenuService menuService;

    @Resource
    private SyncDataService syncDataService;

    @RequestMapping(value = "user_manage", method = {RequestMethod.POST, RequestMethod.GET})
    public String user_manage(HttpServletRequest request,
                              HttpServletResponse response,
                              ModelMap model) {
        return GV.VV(GV.VIEWS, "user_manage");
    }

    @ResponseBody
    @RequestMapping(value = "getUserList.json", method = {RequestMethod.POST, RequestMethod.GET})
    public String getUserListJson(@RequestParam String aoData, String sEcho) throws Exception {
        List<com.allcam.pojo.UserInfo> userList = new ArrayList<com.allcam.pojo.UserInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("aoData", new AoData(aoData));
        userList = userService.getUserInfo(map);

        int size = userList.size();
        String[][] data = new String[size][];
        for (int i = 0; i < size; i++) {
            com.allcam.pojo.UserInfo user = userList.get(i);
            data[i] = user.values();
        }
        int total = userService.getUserTotal(map);
        return JSonUtils.toJSon(new DataTableReturnObject(total, total, sEcho, data));
    }

    @ResponseBody
    @RequestMapping(value = "syncUserData.json", method = {RequestMethod.POST, RequestMethod.GET})
    public void syncUserDataJson(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JsonResult jr = new JsonResult();
        try {
            String sessionId = request.getParameter("sessionId");
            syncDataService.syncTeacher(sessionId, "");
            jr.setResultCode(JsonResult.SUCCESS);
            jr.setResultMessage("操作成功");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
        catch (Exception e) {
            jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
        }
    }

    @ResponseBody
    @RequestMapping(value = "SYNC_TEACHER", method = {RequestMethod.POST, RequestMethod.GET})
    public void syncTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // String sourceIp = HttpUtil.getRemoteAddr(request);
        InputStream requestInputStream = request.getInputStream();
        String requestJson = IOUtils.toString(requestInputStream, "UTF-8");
        LOG.info("HttpServer.doPost requestJson:[" + requestJson + "]");
        String responseJson = null;
        DeviceSyncTeacherResp resp = new DeviceSyncTeacherResp();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
            @SuppressWarnings("unchecked")
            Map<String, Object> map = mapper.readValue(requestJson, Map.class);
            Object head = map.get(JSON_MSG_HEAD_KEY);
            MsgheadInfo msgHead = mapper.readValue(mapper.writeValueAsString(head),
                                                   MsgheadInfo.class);
            String msgType = msgHead.getMsgType();
            String direction = msgHead.getDirection();
            // String version = msgHead.getVersion();
            // Object body = map.get(JSON_MSG_BODY_KEY);
            // RequestInfo requestInfo =
            // mapper.readValue(mapper.writeValueAsString(body),
            // RequestInfo.class);
            if (StringUtil.isNull(msgType)) {
                LOG.error("MsgType Is Null.");
                throw new CustomException("MsgType Is Null.");
            }
            if (!HTTP_REQUEST.equals(direction)) {
                LOG.error("Direction Is Not Correct.");
                throw new CustomException("Direction Is Not Correct.");
            }
            if (SYNC_TEACHER.equalsIgnoreCase(msgType)) {
                DeviceSyncTeacherReq req = (DeviceSyncTeacherReq) HttpUtil.parseJsonToBean(map,
                                                                                           DeviceSyncTeacherReq.class.getName());
                System.out.println(req);
                resp = deviceTeacherService.syncTeacher(req);
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
                response.setHeader("Authentication-Info",
                                   "Digest realm=realm@host.com,nextnonce=" + nextnonce + "");
            } else {
                throw new CustomException("Invalid MsgType");
            }
        }
        catch (CustomException e) {
            response.setStatus(500);
            LOG.error("HttpServer CustomException");
            String nonce = RandomUtil.randomStringa(NONCE_LENGTH);
            String opaque = RandomUtil.randomStringa(OPAQUE_LENGTH);
            response.setHeader("WWW-Authenticate",
                               "Digest realm=realm@host.com,qop=auth,nonce="
                                                   + nonce
                                                   + ",opaque="
                                                   + opaque
                                                   + "");
            responseJson = "{\"MsgHead\":{\"version\":\"1.0\",\"direction\":\"response\",\"msgType\":\"COMMON\"},\"Result\":{\"resultCode\":\"1002\",\"resultDesc\":\""
                           + e.getMessage()
                           + "\"}}";
        }
        catch (Exception e) {
            response.setStatus(500);
            LOG.error("HttpServer Exception");
            String nonce = RandomUtil.randomStringa(NONCE_LENGTH);
            String opaque = RandomUtil.randomStringa(OPAQUE_LENGTH);
            response.setHeader("WWW-Authenticate",
                               "Digest realm=realm@host.com,qop=auth,nonce="
                                                   + nonce
                                                   + ",opaque="
                                                   + opaque
                                                   + "");
            responseJson = "{\"MsgHead\":{\"version\":\"1.0\",\"direction\":\"response\",\"msgType\":\"COMMON\"},\"Result\":{\"resultCode\":\"1002\",\"resultDesc\":\""
                           + e.getMessage()
                           + "\"}}";
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

    /**
     * 跳转到用户登录页面
     * 
     * @param request
     * @param response
     * @param model
     * @throws ServiceException
     *             [参数说明]
     * 
     * @return String [返回类型说明]
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws ServiceException {
        String timeoutFlag = (String) request.getSession().getAttribute("timeoutFlag");

        // 获取是否是通过手机终端访问的
        boolean isMobileDevice = HttpRequestDeviceUtils.isMobileDevice(request);

        if ("1".equals(timeoutFlag) || isMobileDevice) {
            return GV.VV(GV.MOBILES, "login");
        } else {
            return GV.VV(GV.VIEWS, "login");
        }
    }

    /**
     * 用户登录超时
     * 
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/login_timeout", method = RequestMethod.GET)
    public String timeout(HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap model) {
        String referer = request.getHeader("referer");

        if (StringUtils.isNotBlank(referer)) {
            if (referer.indexOf("/app") != -1) {
                request.getSession().setAttribute("timeoutFlag", "1");
            }
        }
        return "/timeout";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws Exception {
        AuthLoginResUserInfo userInfo = (AuthLoginResUserInfo) request.getSession()
                                                                      .getAttribute("loginUser");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("schoolId", userInfo.getSchoolId());
        // List<ReceiveStudentInfo> list =
        // attendService.getRecentReceiveStudentInfo(map);
        // for (ReceiveStudentInfo receiveStudentInfo : list)
        // {
        // receiveStudentInfo.setPhotoUrl(OSSUtil.generatePresignedUrl(receiveStudentInfo.getPhotoUrl()));
        // receiveStudentInfo.setReceiveTime(DateUtil.formatTime(DateUtil.timeStr2Date(receiveStudentInfo.getReceiveTime(),
        // DateUtil.DATE_14),
        // DateUtil.DATE_19));
        // }
        // model.addAttribute("recvList", list);
        return GV.VV(GV.VIEWS, "index");
    }

    @ResponseBody
    @RequestMapping(value = "list_school.json", method = {RequestMethod.POST, RequestMethod.GET})
    private JsonResult listSchool(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam(value = "username",
                                          required = true) String username) {
        JsonResult lr = new JsonResult();
        if (StringUtils.isBlank(username)) {
            lr.setResultCode(JsonResult.CUSTOM_ERROR);
            lr.setResultMessage("用户名不能为空");
        } else if ("admin".equals(username)) {
            lr.setResultCode(JsonResult.SUCCESS);
            lr.setResultMessage("");
        } else {
            try {
                String authLoginAddress = ConfigHelper.getValueByKey("auto.user.request.address");
                GetSchoolsRes res = getSchoolListByMobile(username, authLoginAddress);
                if (SUCCESS_CODE.equals(res.getResult().getResultCode())) {
                    List<GetSchoolsResSchooInfo> schoolList = res.getSchoolList();
                    if (CollectionUtils.isEmpty(schoolList)) {
                        throw new Exception("School not found!");
                    } else {
                        lr.setResultCode(JsonResult.SUCCESS);
                        lr.setResultMessage(JSonUtils.toJSon(schoolList));
                    }
                } else {
                    throw new Exception("Get schools fail!");
                }
            }
            catch (Exception e) {
                LOG.error("listSchool().Exception", e);
                lr.setResultCode(JsonResult.CUSTOM_ERROR);
                lr.setResultMessage("登录失败");
            }
        }
        return lr;
    }

    @ResponseBody
    @RequestMapping(value = "login.json", method = {RequestMethod.POST, RequestMethod.GET})
    @SystemControllerLog(description = "登录")
    private JsonResult loginMethod(HttpServletRequest request,
                                   HttpServletResponse response,
                                   @RequestParam(value = "username",
                                           required = true) String username,
                                   @RequestParam(value = "password",
                                           required = true) String password,
                                   @RequestParam(value = "rememberMe",
                                           required = false) String rememberMe,
                                   @RequestParam(value = "schoolId",
                                           required = false) String schoolId,
                                   @RequestParam(value = "bpcServerUrl",
                                           required = false) String bpcServerUrl) {
        //WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        //DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
        //for (int i = 0; i < 1; i++) {
        //    String hello = demoService.sayHello("world"); // 执行远程方法
        //    System.out.println(hello + "2" + i);
        //}
        JsonResult lr = new JsonResult();
        if (StringUtils.isBlank(username)) {
            lr.setResultCode(JsonResult.CUSTOM_ERROR);
            lr.setResultMessage("用户名不能为空");
        } else if (StringUtils.isBlank(password)) {
            lr.setResultCode(JsonResult.CUSTOM_ERROR);
            lr.setResultMessage("密码不能为空");
        } else {
            if ("admin".equals(username)) {
                try {
                    String pass = DASASEEncryptUtil.encryptData(password,
                                                                DASASEEncryptUtil.SECRETKEY);
                    AdminInfo adminInfo = adminService.getAdminInfo(username, pass);
                    if (null == adminInfo || StringUtils.isBlank(adminInfo.getAdminId())) {
                        lr.setResultCode(JsonResult.CUSTOM_ERROR);
                        lr.setResultMessage("用户名或密码错误");
                    } else {
                        LoginResult loginResult = dologin(username, password, rememberMe);
                        if (loginResult == LoginResult.SUCCESS) {
                            AuthLoginResUserInfo userInfo = new AuthLoginResUserInfo();
                            userInfo.setLoginName("admin");
                            userInfo.setUserName(adminInfo.getAdminDesc());
                            userInfo.setUserType("0");
                            request.getSession().setAttribute("loginUser", userInfo);
                            lr.setResultCode(JsonResult.SUCCESS);
                            lr.setResultMessage("登录成功");
                            lr.setNextUrl("index");
                            List<MenuInfo> menuList = menuService.queryAllMenuInfo();
                            request.getSession().setAttribute("menuList", menuList);
                        } else {
                            throw new Exception();
                        }
                    }
                }
                catch (Exception e) {
                    LOG.error("loginMethod().Exception", e);
                    lr.setResultCode(JsonResult.CUSTOM_ERROR);
                    lr.setResultMessage("登录失败");
                }
            } else {
                try {
                    String authLoginAddress = ConfigHelper.getValueByKey("auto.user.request.address");
                    AuthLoginReq authLoginReq = new AuthLoginReq();
                    MsgHead msgHead = new MsgHead();
                    msgHead.setMsgType("AUTH_LOGIN_PWD");
                    msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
                    authLoginReq.setMsgHead(msgHead);

                    AuthLoginReqBody msgBody = new AuthLoginReqBody();
                    msgBody.setSchoolId(schoolId);
                    msgBody.setUserName(username);
                    Des3Util des3Util = new Des3Util("2015bdgw");
                    String des3Pwd = des3Util.encode(password);
                    msgBody.setPassword(des3Pwd);

                    msgBody.setToken(RandomUtil.randomStringa(32));
                    msgBody.setEncrypt(Base64.encode(bpcServerUrl.getBytes("UTF-8")));
                    msgBody.setTimestamp(DateUtil.formatTime(new Date(), DateUtil.DATE_14));

                    authLoginReq.setMsgBody(msgBody);

                    // 发送用户登录请求
                    String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(authLoginReq),
                                                                           authLoginAddress);

                    // 将字符串转换为对象
                    AuthLoginRes resp = JSonUtils.readValue(responseBody, AuthLoginRes.class);

                    // 如果登录成功则展示登录后的页面，否则展示登录失败页面
                    if (SUCCESS_CODE.equals(resp.getResult().getResultCode())) {
                        LoginResult loginResult = dologin(username, password, rememberMe);
                        if (loginResult == LoginResult.SUCCESS) {
                            request.getSession().setAttribute("loginUser", resp.getUserInfo());
                            lr.setResultCode(JsonResult.SUCCESS);
                            lr.setResultMessage("登录成功");
                            lr.setNextUrl("index");
                            Map<String, String> paramMap = new HashMap<String, String>();
                            paramMap.put("userType", resp.getUserInfo().getUserType());
                            List<MenuInfo> menuList = menuService.queryUserMenu(paramMap);
                            request.getSession().setAttribute("menuList", menuList);
                        } else {
                            throw new Exception("Shiro login fail");
                        }
                    } else {
                        lr.setResultCode(JsonResult.CUSTOM_ERROR);
                        lr.setResultMessage("用户名或密码错误");
                    }
                }
                catch (Exception e) {
                    LOG.error("loginMethod().Exception", e);
                    lr.setResultCode(JsonResult.CUSTOM_ERROR);
                    lr.setResultMessage("登录失败");
                }
            }
        }
        return lr;
    }

    /**
     * 进行用户登录信息验证
     * 
     * @param username
     * @param password
     * @param rememberMe
     * @return
     */
    private LoginResult dologin(String username, String password, String rememberMe) {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.setUsername(username);
        loginCommand.setPassword(password);
        // 登录的地方这个根据内网和外网分别设置
        loginCommand.setUserType(UserType.OTHER);
        if ("on".equals(rememberMe)) {
            loginCommand.setRememberMe(true);
        } else {
            loginCommand.setRememberMe(false);
        }
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
        }
        LoginResult loginResult = LoginResult.OTHEREXCEPTION;
        MyExUsernamePasswordToken token = new MyExUsernamePasswordToken(loginCommand.getUsername(),
                                                                        loginCommand.getPassword());
        token.setUsercode(loginCommand.getUsercode());
        token.setUserType(loginCommand.getUserType());
        token.setRememberMe(loginCommand.isRememberMe());

        try {
            currentUser.login(token);
            loginResult = LoginResult.SUCCESS;
        }
        catch (LockedAccountException lae) {
            loginResult = LoginResult.LOCKEDACCOUNT;
        }
        catch (UnknownAccountException uae) {
            loginResult = LoginResult.UNKNOWNACCOUNT;
        }
        catch (IncorrectCredentialsException ice) {
            loginResult = LoginResult.INCORRECTCREDENTIALS;
        }
        catch (AuthenticationException ae) {
            loginResult = LoginResult.AUTHENTICATION;
        }
        catch (Exception e) {
            loginResult = LoginResult.OTHEREXCEPTION;
        }
        return loginResult;
    }

    /**
     * 退出
     * 
     * @param request
     * @param response
     * @param type
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, String type) {
        try {
            // String token =
            // String.valueOf(request.getSession().getAttribute("token"));
            // userService.loginout(token);
            SecurityUtils.getSubject().logout();
            request.getSession().invalidate();
        }
        catch (Exception e) {
            LOG.error("logout().Exception", e);
        }
        return "redirect:/login";
    }

    private GetSchoolsRes getSchoolListByMobile(String mobile, String address) throws Exception {
        GetSchoolsReq req = new GetSchoolsReq();
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("GET_SCHOOL_LIST");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        req.setMsgHead(msgHead);
        GetSchoolsReqBody msgBody = new GetSchoolsReqBody();
        msgBody.setMobile(mobile);
        req.setMsgBody(msgBody);
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(req), address);
        GetSchoolsRes res = JSonUtils.readValue(responseBody, GetSchoolsRes.class);
        return res;
    }
}
