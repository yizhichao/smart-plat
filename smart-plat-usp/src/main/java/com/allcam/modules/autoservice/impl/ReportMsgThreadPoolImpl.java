package com.allcam.modules.autoservice.impl;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.allcam.modules.autoservice.inf.ReportMsgThreadPoolInf;
import com.allcam.modules.autoservice.model.ReportBean;
import com.allcam.modules.autoservice.work.ReportWorker;
import com.allcam.utils.ConfigHelper;

/**
 * 
 * Push消息线程池
 * 
 * @author YiZhichao
 * @version [版本号, 2015-4-25]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class ReportMsgThreadPoolImpl implements ReportMsgThreadPoolInf
{
    private static final Log LOG = LogFactory.getLog(ReportMsgThreadPoolImpl.class);
    
    public ReportMsgThreadPoolImpl()
    {
        initTheadPool();
    }
    
    private int corePoolSize = 3;
    
    private int maxPoolSize = 3;
    
    private int keepAliveTime = 3000;
    
    protected LinkedBlockingQueue<Runnable> queue;
    
    protected int queueMaxSize = Integer.parseInt(ConfigHelper.getValueByKey("sys.message.queue.max.reportmsg"));;
    
    private final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.MILLISECONDS;
    
    protected ThreadPoolExecutor threadPool;
    
    protected void initTheadPool()
    {
        if (LOG.isInfoEnabled())
        {
            StringBuffer sb = new StringBuffer();
            sb.append("devicecorepoolsize->");
            sb.append(this.corePoolSize);
            sb.append(",maxpoolsize->");
            sb.append(this.maxPoolSize);
            sb.append(",devicekeepalivetime->");
            sb.append(this.keepAliveTime);
            sb.append(",queuemaxsize->");
            sb.append(this.queueMaxSize);
            LOG.info(sb.toString());
        }
        this.queue = new LinkedBlockingQueue<Runnable>(this.queueMaxSize);
        
        this.threadPool =
            new ThreadPoolExecutor(this.corePoolSize, this.maxPoolSize, this.keepAliveTime, this.KEEP_ALIVE_UNIT,
                this.queue, new ThreadPoolExecutor.CallerRunsPolicy());
    }
    
    /**
     * 发送push消息，放入到线程池
     * 
     * @param bean 短信消息实体
     * @see [类、类#方法、类#成员]
     */
    @Override
    public void pushMessageProcessor(ReportBean bean)
    {
        if (this.queue.size() < this.queueMaxSize)
        {
            this.threadPool.execute(new ReportWorker(bean));
        }
        else
        {
            LOG.warn("the threadPool is full ,discard bean ,this size is " + this.queue.size());
        }
    }
    
}
