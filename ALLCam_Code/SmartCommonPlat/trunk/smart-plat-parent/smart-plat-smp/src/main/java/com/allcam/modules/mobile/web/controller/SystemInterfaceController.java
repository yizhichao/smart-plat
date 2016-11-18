package com.allcam.modules.mobile.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.allcam.framework.security.MyExUsernamePasswordToken;
import com.allcam.modules.bean.MsgHead;
import com.allcam.modules.mobile.model.AuthLoginReq;
import com.allcam.modules.mobile.model.AuthLoginReqBody;
import com.allcam.modules.mobile.model.AuthLoginRes;
import com.allcam.modules.mobile.model.AuthLoginResUserInfo;
import com.allcam.modules.user.inf.UserService;
import com.allcam.modules.user.web.controller.LoginCommand;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.DASASEEncryptUtil;
import com.allcam.utils.GV;
import com.allcam.utils.HttpRequestUtil;
import com.allcam.utils.JSonUtils;
import com.allcam.utils.SystemConstant;
import com.allcam.web.controller.BaseController;
import com.raising.system.framework.enums.Enums.LoginResult;
import com.raising.system.framework.enums.Enums.UserType;

/**
 * 系统接口
 * 
 * @author marui
 * @version [版本号, Aug 21, 2015]
 */
@Controller
@RequestMapping(value = "/services")
public class SystemInterfaceController extends BaseController
{
    public static final Log LOG = LogFactory.getLog(SystemInterfaceController.class);
    
    @Resource
    private UserService userService;
    
    /**
     * BPC向BDGW平台的请求接口
     * 
     * @param request
     * @param response
     */
    @RequestMapping(value = "/service", method = {RequestMethod.GET, RequestMethod.POST})
    public String interService(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        try
        {
            AuthLoginResUserInfo userInfo = (AuthLoginResUserInfo)request.getSession().getAttribute("loginUser");
            if (null == userInfo)
            {
                login(request, response);
            }
            return "redirect:/app/attend_statistics";
        }
        catch (Exception e)
        {
            LOG.error("SSO login failed", e);
            model.addAttribute("message", "抱歉，鉴权失败，请联系客服");
            return GV.VV(GV.MOBILES, "error");
        }
    }
    
    /**
     * 用户单点登录
     * 
     * @param request
     * @param response
     * @param model
     * @return
     */
    private void login(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        // String displayName = request.getParameter("displayName");
        String token = request.getParameter("token");
        String encrypt = request.getParameter("encrypt");
        String timestamp = request.getParameter("timeStamp");
        
        AuthLoginReq authLoginReq = new AuthLoginReq();
        
        MsgHead msgHead = new MsgHead();
        msgHead.setMsgType("AUTH_LOGIN_SSO");
        msgHead.setDirection(SystemConstant.DIRECTION_REQUEST);
        authLoginReq.setMsgHead(msgHead);
        
        AuthLoginReqBody msgBody = new AuthLoginReqBody();
        msgBody.setUserId(userId);
        msgBody.setUserName(userName);
        msgBody.setToken(token);
        msgBody.setEncrypt(encrypt);
        msgBody.setTimestamp(timestamp);
        
        authLoginReq.setMsgBody(msgBody);
        
        String authLoginAddress = ConfigHelper.getValueByKey("auto.user.request.address");
        
        // 向AUC发起用户单点登录请求
        String responseBody = HttpRequestUtil.httpPostWithJSON(JSonUtils.toJSon(authLoginReq), authLoginAddress);
        
        // 将字符串转换为对象
        AuthLoginRes resp = JSonUtils.readValue(responseBody, AuthLoginRes.class);
        
        if (SUCCESS_CODE.equals(resp.getResult().getResultCode()))
        {
            AuthLoginResUserInfo userInfo = resp.getUserInfo();
            String password = DASASEEncryptUtil.decryptData(userInfo.getUserAucPwd(), userInfo.getUserId());
            if (loginMethod(userName, password))
            {
                request.getSession().setAttribute("loginUser", userInfo);
            }
        }
        else
        {
            throw new Exception();
        }
    }
    
    private boolean loginMethod(String loginName, String password)
    {
        LoginCommand loginCommand = new LoginCommand();
        loginCommand.setUsername(loginName);
        
        loginCommand.setPassword(password);
        // 登录的地方这个根据内网和外网分别设置
        loginCommand.setUserType(UserType.OTHER);
        loginCommand.setRememberMe(false);
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated())
        {
            currentUser.logout();
        }
        
        LoginResult loginResult = dologin(currentUser, loginCommand);
        
        if (loginResult == LoginResult.SUCCESS)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 进行用户登录信息验证
     * 
     * @param currentUser 当前用户
     * @param loginCommand 登录command对象
     * @return 返回登录结果
     */
    private LoginResult dologin(Subject currentUser, LoginCommand loginCommand)
    {
        LoginResult loginResult = LoginResult.OTHEREXCEPTION;
        MyExUsernamePasswordToken token =
            new MyExUsernamePasswordToken(loginCommand.getUsername(), loginCommand.getPassword());
        token.setUsercode(loginCommand.getUsercode());
        token.setUserType(loginCommand.getUserType());
        token.setRememberMe(loginCommand.isRememberMe());
        
        try
        {
            currentUser.login(token);
            loginResult = LoginResult.SUCCESS;
        }
        catch (LockedAccountException lae)
        {
            loginResult = LoginResult.LOCKEDACCOUNT;
        }
        catch (UnknownAccountException uae)
        {
            loginResult = LoginResult.UNKNOWNACCOUNT;
        }
        catch (IncorrectCredentialsException ice)
        {
            loginResult = LoginResult.INCORRECTCREDENTIALS;
        }
        catch (AuthenticationException ae)
        {
            loginResult = LoginResult.AUTHENTICATION;
        }
        catch (Exception e)
        {
            loginResult = LoginResult.OTHEREXCEPTION;
        }
        return loginResult;
    }
}
