package com.allcam.modules.abilityInf.student.inf;

import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentReq;
import com.allcam.modules.abilityInf.student.model.DeviceSyncStudentResp;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface DeviceStudentService
{
    DeviceSyncStudentResp syncStudent(DeviceSyncStudentReq req)
        throws Exception;
    
}
