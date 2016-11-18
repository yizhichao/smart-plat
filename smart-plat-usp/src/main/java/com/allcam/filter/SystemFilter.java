package com.allcam.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.allcam.modules.mobile.model.AuthLoginResUserInfo;
import com.allcam.utils.SystemConstant;

public class SystemFilter implements Filter {

    private static final List<String> STRINGS = new ArrayList<String>();

    static {
        STRINGS.add("jsp");
        STRINGS.add("js");
        STRINGS.add("css");
        STRINGS.add("images");
        STRINGS.add("bmp");
        STRINGS.add("gif");
        STRINGS.add("jpg");
        STRINGS.add("jpeg");
        STRINGS.add("png");
        STRINGS.add("ico");
        STRINGS.add("woff");
        STRINGS.add("woff2");
        STRINGS.add("anon");
        STRINGS.add("services/service");
        STRINGS.add("app/");
        STRINGS.add("DEV_REG");
        STRINGS.add("SYNC_TEACHER");
        STRINGS.add("SYNC_STUDENT");
        STRINGS.add("SYNC_ADS");
        STRINGS.add("CHECK_VERSION_UPGRADE");
        STRINGS.add("ENTRY_EXIT_NOTIFY");
        STRINGS.add("home");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(SystemConstant.UTF8_CODE);
        response.setCharacterEncoding(SystemConstant.UTF8_CODE);
        // String url = request.getRequestURI();
        // url = url.substring(request.getContextPath().length());
        // if (!isAuth(url))
        // {
        // UserInfo userInfo = (UserInfo)
        // request.getSession().getAttribute("UserInfo");
        // if (userInfo == null)
        // {
        // response.sendRedirect("index.jsp");
        // }
        // else
        // {
        // chain.doFilter(request, response);
        // }
        // }
        // else
        // {
        // chain.doFilter(request, response);
        // }
        String url = request.getRequestURI();
        String path = request.getContextPath();
        AuthLoginResUserInfo userInfo = (AuthLoginResUserInfo) request.getSession()
                                                                      .getAttribute("loginUser");
        if (!url.contains("login")
            && !url.contains("list_school")
            && (!isAuth(url) || url.contains(".json"))) {
            // alert(\"访问超时，请重新登录\");
            if (null == userInfo || StringUtils.isBlank(userInfo.getLoginName())) {
                String tip = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><script language='javascript'>window.parent.location.href='"
                             + path
                             + "/login'</script></head><body></body></html>";
                PrintWriter outprint = response.getWriter();
                outprint.write(tip);
                outprint.flush();
                return;
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    public boolean isAuth(String url) {
        for (String string : STRINGS) {
            if (url.contains(string)) {
                return true;
            }
        }
        return false;
    }
}
