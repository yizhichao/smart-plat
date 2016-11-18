package com.allcam.modules.abilityInf.device.inf;

import com.allcam.modules.abilityInf.device.model.DeviceRecvDataReq;
import com.allcam.modules.abilityInf.device.model.DeviceRecvDataResp;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface DeviceRecvDataService
{
    DeviceRecvDataResp recvData(DeviceRecvDataReq req)
        throws Exception;
    
}
