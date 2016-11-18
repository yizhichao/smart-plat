package com.allcam.modules.bean.bpm;

import com.allcam.utils.Tools;


public class MsgheadInfo
{
    private String version;
    
    private String direction = "request";
    
    private String msgType;
    
    private String deviceSys;
    
    /** 语言环境 */
    private String userLan;
    
    public String getUserLan()
    {
        return userLan;
    }

    public void setUserLan(String userLan)
    {
        this.userLan = userLan;
    }

    public String getVersion()
    {
        return version;
    }
    
    public void setVersion(String version)
    {
        this.version = version;
    }
    
    public String getDirection()
    {
        return direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public String getMsgType()
    {
        return msgType;
    }
    
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    
    public String getDeviceSys()
    {
        return deviceSys;
    }

    public void setDeviceSys(String deviceSys)
    {
        this.deviceSys = deviceSys;
    }

    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
