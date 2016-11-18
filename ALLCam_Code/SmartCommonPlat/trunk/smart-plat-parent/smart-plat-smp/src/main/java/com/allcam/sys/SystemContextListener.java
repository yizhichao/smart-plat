package com.allcam.sys;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.allcam.common.ServiceContants;
import com.allcam.modules.autoservice.impl.MessageQueueJobImpl;
import com.allcam.modules.autoservice.inf.MessageQueueJobInf;
import com.allcam.utils.ConfigHelper;
import com.allcam.utils.Env;
import com.allcam.utils.Resource;
import com.allcam.utils.StringUtil;

/**
 * 
 * 初始化类
 * 
 * @author yizhichao
 * 
 */
public class SystemContextListener extends ContextLoaderListener implements ServiceContants
{
    
    public static ApplicationContext applicationContext;
    
    /** 启动日志 */
    private Log log = null;
    
    /** web服务主目录 */
    public static final String WEB_HOME_TEMPDIR = "javax.servlet.context.tempdir";
    
    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        super.contextDestroyed(event);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        boolean rst = true;
        
        try
        {
            
            applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
            
            ServletContext context = event.getServletContext();
            
            // 获取工程路径
            String webPath = (String)context.getAttribute("webPath");
            
            if (isNull(webPath))
            {
                webPath = context.getRealPath("/");
            }
            
            context.setAttribute("webPath", webPath);
            
            Env.setWebPath(webPath);
            
            log = LogFactory.getLog(SystemContextListener.class);
            
            String sysConDir = webPath + "WEB-INF" + FILE_SEAPRATOR + "conf" + FILE_SEAPRATOR;
            
            // 初始化webcommon配置文件
            rst = rst && webCommonInit(sysConDir + "web_common");
            
            if (!rst)
            {
                System.out.println("init fail.");
                quit();
            }
        }
        catch (Exception e)
        {
            System.out.println("init fail.");
            quit();
        }
        
        // 服务启动信息日志
        Date startTime = new Date();
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(LOG_DATE_PATTERN);
        System.out.println("Internet Media Platform is starting at " + fastDateFormat.format(startTime));
        log.info("Internet Media Platform is starting at " + fastDateFormat.format(startTime));
    }
    
    public static Object getObject(String name)
    {
        
        return applicationContext.getBean(name);
    }
    
    /**
     * 系统管理参数配置文件
     * 
     * @param path 路径-文件名不包含xml后缀
     * @throws IOException IOException
     */
    protected boolean webCommonInit(String path)
    {
        if (log.isInfoEnabled())
        {
            log.info("init webCommon....");
        }
        
        if (StringUtil.isNull(path))
        {
            log.error("null config file for webCommon");
            return false;
        }
        
        // 系统管理参数配置
        try
        {
            Env.setWebCommon(new Resource(path, false));
        }
        catch (IOException e)
        {
            log.error("IOException", e);
            return false;
        }
        if (log.isInfoEnabled())
        {
            log.info("init webCommon ok.");
        }
        
        return true;
        
    }
    
    /** 出现异常强行退出 */
    public static void quit()
    {
        // 系统强行退出
        
        System.exit(INT_1);
    }
    
    /**
     * 检查字符串是否为空，字符串为null，或者长度为0都认为为空
     * 
     * 
     * @param str 字符串
     * 
     * @return boolean
     */
    public static boolean isNull(String str)
    {
        if (null == str)
        {
            return true;
        }
        
        if (0 == str.trim().length())
        {
            return true;
        }
        
        return false;
    }
    
}
