package com.allcam.modules.autoservice.inf;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.allcam.modules.autoservice.model.ReportBean;

/**
 * 
 * Push消息线程池
 * 
 * @author YiZhichao
 * @version [版本号, 2015-4-25]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ReportMsgThreadPoolInf
{
    /**
     * 发送push消息，放入到线程池
     * 
     * @param bean 短信消息实体
     * @see [类、类#方法、类#成员]
     */
    public void pushMessageProcessor(ReportBean bean);
    
}
