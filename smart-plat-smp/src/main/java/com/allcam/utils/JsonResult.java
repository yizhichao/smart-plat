package com.allcam.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlRootElement;

import com.allcam.common.BaseInfo;
import com.thoughtworks.xstream.annotations.XStreamAliasType;

/**
 * 请求返回的JSON对象
 * 
 * @author  marui
 * @version  [版本号, 2015-3-4]
 */
@XStreamAliasType(value = "jsonResult")
@XmlRootElement(name = "jsonResult")
public class JsonResult
{
    public final static String SUCCESS = "SUCCESS";
    
    public final static String ERROR = "ERROR";
    
    public final static String CUSTOM_ERROR = "1001";
    
    public final static String ExceptionMessage = "服务异常,请联系管理员.";
    
    private String resultCode;
    
    private String resultMessage;
    
    private String act = "reload";
    
    private String nextUrl;
    
    private BaseInfo baseInfo;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultMessage()
    {
        return resultMessage;
    }
    
    public void setResultMessage(String resultMessage)
    {
        this.resultMessage = resultMessage;
    }
    
    public String getNextUrl()
    {
        return nextUrl;
    }
    
    public void setNextUrl(String nextUrl)
    {
        this.nextUrl = nextUrl;
    }
    
    public String getAct()
    {
        return act;
    }
    
    public void setAct(String act)
    {
        this.act = act;
    }

    public BaseInfo getBaseInfo()
    {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo)
    {
        this.baseInfo = baseInfo;
    }
    
    public static void jsonResult(JsonResult jr,HttpServletResponse response,String code) throws IOException{
    	if(code.equals(JsonResult.SUCCESS)){
    		jr.setResultCode(JsonResult.SUCCESS);
            jr.setResultMessage("操作成功");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
    	}else if(code.equals(JsonResult.ERROR)){
    		jr.setResultCode(JsonResult.CUSTOM_ERROR);
            jr.setResultMessage("操作失败");
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(JSonUtils.toJSon(jr));
    	}
    }
}
