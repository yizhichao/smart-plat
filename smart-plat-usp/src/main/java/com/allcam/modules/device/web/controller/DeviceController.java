package com.allcam.modules.device.web.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allcam.modules.device.inf.DeviceService;
import com.allcam.modules.device.model.DeviceInfo;
import com.allcam.modules.user.inf.UserService;
import com.allcam.utils.DateUtils;
import com.allcam.utils.GV;
import com.allcam.utils.StringUtils;
import com.allcam.web.controller.BaseController;

/***
 * 设备管理
 * 
 * @author XiongJinTeng
 */
@Controller
@RequestMapping("/device")
public class DeviceController extends BaseController {

    /**
     * 请求之前向model中赋值
     * 
     * @param zoneId
     *            区域范围
     */
    @ModelAttribute(value = "")
    public void get(String zoneId, String zoneName, Model model) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(zoneId) && StringUtils.isNotBlank(zoneName)) {
            model.addAttribute("zoneId", zoneId);
            model.addAttribute("zoneName", zoneName);
        } else {
            model.addAttribute("zoneId", "");
            model.addAttribute("zoneName", "");
        }
    }

    /**
     * 设备管理首页<br />
     * <p>
     * 该控制器的作用很明显，展示左树又表的结构
     * </p>
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "")
    public String index(HttpServletRequest request) {
        // return "deviceIndex";
        return GV.VV(GV.VIEWS, "dev/deviceIndex");
    }

    @ResponseBody
    @RequestMapping(value = "/get")
    public Object get(HttpServletRequest request) {
        // return "deviceIndex";

        return deviceService.get(0);
    }

    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request) {
        // return "deviceIndex";
        return GV.VV(GV.VIEWS, "dev/list");
    }

    @Resource
    private UserService userService;

    @Resource
    private DeviceService deviceService;

    @RequestMapping(value = "/form")
    public String form(HttpServletRequest request) {
        // return "deviceIndex";
        return GV.VV(GV.VIEWS, "dev/form");
    }

    @RequestMapping(value = "/save")
    public String save(HttpServletRequest request, DeviceInfo deviceInfo) {
        // return "deviceIndex";
        int result = deviceService.insert(deviceInfo);
        System.out.println("result:\n" + result);
        return GV.VV(GV.VIEWS, "dev/form");
    }

    /**
     * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
            // @Override
            // public String getAsText() {
            // Object value = getValue();
            // return value != null ? DateUtils.formatDateTime((Date)value) :
            // "";
            // }
        });
    }
}
