package com.allcam.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.allcam.common.ServiceContants;

public class BaseController implements ServiceContants {

    public final static Logger log = LoggerFactory.getLogger(BaseController.class);

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    protected String getMsgResultContent(HttpServletRequest request) {
        return (String) request.getAttribute(ServiceContants.JSON_RESULT_KEY);
    }

    protected String getMsgHeadContent(HttpServletRequest request) {
        return (String) request.getAttribute(ServiceContants.JSON_MSG_HEAD_KEY);
    }

    protected String getMsgBodyContent(HttpServletRequest request) {
        return (String) request.getAttribute(ServiceContants.JSON_MSG_BODY_KEY);
    }
}
