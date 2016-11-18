package com.allcam.modules.abilityInf.device.inf;

import com.allcam.modules.abilityInf.device.model.DeviceRegReq;
import com.allcam.modules.abilityInf.device.model.DeviceRegResp;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface DeviceRegService
{
    /**
     * 用户登录
     * 
     * @param userName 用户名
     * @param passWord 密码
     * 
     * @return AuthLoginResponse 返回登录接口响应的对象
     */
    DeviceRegResp devReg(DeviceRegReq req)
        throws Exception;
    
}
