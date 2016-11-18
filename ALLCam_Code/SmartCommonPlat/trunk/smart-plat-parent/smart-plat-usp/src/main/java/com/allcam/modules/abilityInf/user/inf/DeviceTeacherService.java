package com.allcam.modules.abilityInf.user.inf;

import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherReq;
import com.allcam.modules.abilityInf.user.model.DeviceSyncTeacherResp;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface DeviceTeacherService
{
    DeviceSyncTeacherResp syncTeacher(DeviceSyncTeacherReq req)
        throws Exception;
    
}
