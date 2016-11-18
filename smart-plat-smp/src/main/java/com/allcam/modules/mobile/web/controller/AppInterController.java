package com.allcam.modules.mobile.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allcam.modules.user.inf.UserService;
import com.allcam.utils.GV;
import com.allcam.web.controller.BaseController;

/**
 * app相关功能
 * 
 * @author  marui
 * @version  [版本号, Aug 21, 2015]
 */
@Controller
@RequestMapping(value = "/app")
public class AppInterController extends BaseController
{
    public static final Log LOG = LogFactory.getLog(AppInterController.class);
    
    @Resource
    private UserService userService;
    
    /**
     * 跳转到用户登录页面
     * 
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        return GV.VV(GV.MOBILES, "login");
    }
    
    /**
     * 点击下方应用菜单的跳转页面
     * 
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/attend_statistics", method = { RequestMethod.GET,
            RequestMethod.POST })
    public String applicationList(HttpServletRequest request,
            HttpServletResponse response, ModelMap model)
    {
        model.addAttribute("footerFlag", "application");
        return GV.VV(GV.MOBILES, "attend_statistics");
    }
    
//    /**
//     * 显示通知列表
//     * 
//     * @param request
//     * @param response
//     * @param model
//     */
//    @RequestMapping(value = "/noticeList", method = { RequestMethod.GET,
//            RequestMethod.POST })
//    public String noticeList(HttpServletRequest request,
//            HttpServletResponse response, ModelMap model)
//    {
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//        
//        map.put("noticeInfo", new NoticeInfo());
//        
//        NoticeStatusInfo noticeStatusInfo = new NoticeStatusInfo();
//        noticeStatusInfo.setReceiverUserId(super.getLoginUserInfo(request)
//                .getUserId());
//        
//        map.put("noticeStatusInfo", noticeStatusInfo);
//        List<NoticeInfo> noticeInfoList = noticeService.queryLoginUserNoticeInfoByCer(map);
//        
//        model.addAttribute("noticeInfoList", noticeInfoList);
//        model.addAttribute("footerFlag", "application");
//        return GV.VV(GV.MOBILES, "noticeList");
//    }
//    
//    /**
//     * 显示某通知的详情
//     * 
//     * @param request
//     * @param response
//     * @param model
//     */
//    @RequestMapping(value = "/noticeDetail", method = { RequestMethod.GET,
//            RequestMethod.POST })
//    public String noticeDetail(HttpServletRequest request,
//            HttpServletResponse response, ModelMap model)
//    {
//        String noticeId = request.getParameter("noticeId");
//        NoticeInfo noticeInfo = noticeService.getNoticeInfoById(noticeId);
//        
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(noticeInfo.getUserId());
//        map.put("userInfo", userInfo);
//        
//        List<UserInfo> pubUserInfoList = userService.queryUserInfoListByCer(map);
//        
//        if (CollectionUtils.isNotEmpty(pubUserInfoList))
//        {
//            model.addAttribute("userInfo", pubUserInfoList.get(0));
//        }
//        
//        noticeInfo.setPostTime(DateUtil.str2strDate(noticeInfo.getPostTime(),
//                DateUtil.DATE_14,
//                DateUtil.DATE_19));
//        
//        NoticeStatusInfo noticeStatusInfo = new NoticeStatusInfo();
//        noticeStatusInfo.setNoticeId(noticeId);
//        noticeStatusInfo.setReceiverUserId(super.getLoginUserInfo(request).getUserId());
//        
//        map = new LinkedHashMap<String, Object>();
//        map.put("noticeStatusInfo", noticeStatusInfo);
//        
//        List<NoticeStatusInfo> queryNoticeStatusInfoList = noticeService.queryNoticeStatusInfoByCer(map);
//        
//        if (CollectionUtils.isNotEmpty(queryNoticeStatusInfoList))
//        {
//            noticeStatusInfo = queryNoticeStatusInfoList.get(0);
//            noticeStatusInfo.setNoticeStatus("2");
//            noticeService.updateNoticeStatusInfo(noticeStatusInfo);
//        }
//        
//        model.addAttribute("noticeInfo", noticeInfo);
//        model.addAttribute("footerFlag", "application");
//        return GV.VV(GV.MOBILES, "noticeDetail");
//    }
}
