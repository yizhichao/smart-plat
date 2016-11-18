package com.allcam.modules.abilityInf.sysversion.inf;

import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionReq;
import com.allcam.modules.abilityInf.sysversion.model.CheckSysVersionResp;

/**
 * 用户相关业务处理层的接口
 * 
 * @author marui
 * @version [版本号, 2015-3-6]
 */
public interface CheckSysVersionService
{
    CheckSysVersionResp checkSysVersion(CheckSysVersionReq req)
        throws Exception;
    
}
