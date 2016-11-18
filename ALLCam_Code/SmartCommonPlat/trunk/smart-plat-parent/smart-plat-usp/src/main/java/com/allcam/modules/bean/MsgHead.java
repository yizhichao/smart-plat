package com.allcam.modules.bean;

import com.allcam.utils.ConfigHelper;

/**
 * 消息体的头信息
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class MsgHead
{
    /**
     * 消息版本号，默认1.0
     */
    private String version = ConfigHelper.getValueByKey("interface.msgHead.version");
    
    /**
     * 消息方向：request,response
     */
    private String direction;
    
    /**
     * 消息类型
     */
    private String msgType;

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
}
