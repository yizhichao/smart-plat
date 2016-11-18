package com.allcam.modules.autoservice.model;

import com.allcam.pojo.ReceiveStudentInfo;
import com.allcam.pojo.ReceiveUserInfo;
import com.allcam.utils.Tools;

/**
 * 
 推送工作bean
 * 
 * @author Administrator
 * @version [版本号, 2015-4-25]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ReportBean
{
    private String msgType;
    
    private String userType;
    
    private boolean isModPhoto;
    
    private ReceiveUserInfo receiveUserInfo;
    
    private ReceiveStudentInfo receiveStudentInfo;
    
    public boolean getIsModPhoto()
    {
        return isModPhoto;
    }
    
    public void setIsModPhoto(boolean isModPhoto)
    {
        this.isModPhoto = isModPhoto;
    }
    
    public String getMsgType()
    {
        return msgType;
    }
    
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
    
    public String getUserType()
    {
        return userType;
    }
    
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    
    public ReceiveUserInfo getReceiveUserInfo()
    {
        return receiveUserInfo;
    }
    
    public void setReceiveUserInfo(ReceiveUserInfo receiveUserInfo)
    {
        this.receiveUserInfo = receiveUserInfo;
    }
    
    public ReceiveStudentInfo getReceiveStudentInfo()
    {
        return receiveStudentInfo;
    }
    
    public void setReceiveStudentInfo(ReceiveStudentInfo receiveStudentInfo)
    {
        this.receiveStudentInfo = receiveStudentInfo;
    }
    
    /**
     * 重新toString
     */
    public String toString()
    {
        return Tools.beanToString(this);
    }
}
