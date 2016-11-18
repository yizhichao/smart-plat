package com.allcam.modules.abilityInf.device.model;

import com.allcam.modules.bean.bpm.ResponseInfo;
import com.allcam.utils.Tools;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "operations", "roles", "menus"})
public class DeviceRecvDataResp extends ResponseInfo
{
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
