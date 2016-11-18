package com.allcam.modules.autoservice.inf;

import com.allcam.modules.abilityInf.device.model.DeviceRecvDataReq;

/**
 * 
 * 彩虹桥打卡工具类
 * 
 * @author YiZhichao
 * @version [版本号, 2015-6-29]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface MessageQueueJobInf
{
    /**
     * 将用户上报来的内容放到内存中
     * 
     * @param userId
     * @param nurId
     * @param title
     * @param content
     */
    public boolean putMessageContent(DeviceRecvDataReq req);
    
}
