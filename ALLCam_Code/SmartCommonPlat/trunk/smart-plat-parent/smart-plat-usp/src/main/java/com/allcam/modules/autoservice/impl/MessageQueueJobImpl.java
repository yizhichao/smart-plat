package com.allcam.modules.autoservice.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.allcam.common.ServiceContants;
import com.allcam.modules.abilityInf.device.model.DeviceRecvDataReq;
import com.allcam.modules.autoservice.inf.MessageQueueJobInf;
import com.allcam.utils.ConfigHelper;

/**
 * 
 * 打卡工具类
 * 
 * @author YiZhichao
 * @version [版本号, 2015-6-29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class MessageQueueJobImpl implements MessageQueueJobInf, ServiceContants, Runnable {
    public static int noDataLoopTime = 3000;

    /** 定义日志对象 */
    public static final Log LOG = LogFactory.getLog(MessageQueueJobImpl.class);

    // 容量为30000的缓存队列
    protected static final int queueMaxSize = Integer.parseInt(ConfigHelper.getValueByKey("sys.message.queue.max"));

    // 声明一个固定容量的缓存队列
    private static BlockingQueue<DeviceRecvDataReq> queue = new LinkedBlockingQueue<DeviceRecvDataReq>(queueMaxSize);

    public MessageQueueJobImpl() {
        // 打卡类对象实例
        noDataLoopTime = Integer.parseInt(ConfigHelper.getValueByKey("sys.nodata.loop.time"));
        Thread threadMessageQueueJob = new Thread(this);
        threadMessageQueueJob.start();
    }

    /**
     * 将用户上报来的内容放到内存中
     * 
     * @param userId
     * @param nurId
     * @param title
     * @param content
     */
    @Override
    public boolean putMessageContent(DeviceRecvDataReq req) {

        if (queue.size() < queueMaxSize) {
            queue.add(req);
            return true;
        } else {
            LOG.error("the messageQueue is full ,discard bean ,this size is" + queueMaxSize);
            return false;
        }
    }

    /**
     * 推送消息工作查询方法
     * 
     * @param bean
     * @see [类、类#方法、类#成员]
     */
    public void workService(DeviceRecvDataReq req) {

        // 入口日志记录
        if (LOG.isInfoEnabled()) {
            LOG.info("Enter BarrierFreeChannelJobUtil.workService()");
        }
        // 记录方法的参数日志
        if (LOG.isDebugEnabled()) {
            StringBuffer messageBuf = new StringBuffer();
            messageBuf.append("DeviceRecvDataReq= req[").append(req).append("]");
            LOG.debug(messageBuf.toString());
        }
    }

    public void run() {
        while (true) {
            try {
                DeviceRecvDataReq data = queue.poll();
                // data = new DeviceRecvDataReq(); //test
                // System.out.println("dddd");
                if (null != data) {

                    workService(data);
                } else {
                    // 没有数据的情况休息一段时间
                    Thread.sleep(noDataLoopTime);
                }
            }
            catch (InterruptedException e) {
                LOG.error("InterruptedException", e);
            }
            catch (Exception e) {
                LOG.error("Exception", e);
            }
        }
    }
}
