package com.allcam.modules.bean;

/**
 * 消息响应的结果码
 * 
 * @author  marui
 * @version  [版本号, 2015-3-6]
 */
public class Result
{
    /**
     * 成功
     */
    public static final String SUCCESS = "1000";
    
    /**
     * 鉴权失败
     */
    public static final String AUTHLOGINFAIL = "401";
    
    /**
     * 服务器错误
     */
    public static final String SYSTEMERROR = "5500";
    
    /**
     * 用户密码或密码错误
     */
    public static final String LOGIN_ACCOUNT_ERROR = "5501";
    
    /**
     * 无效的用户名
     */
    public static final String USERNAME_INVALID = "5502";
    
    /**
     * 用户不存在
     */
    public static final String USER_IS_NOT_EXISTS = "5503";
    
    /**
     * 程序定义错误信息
     */
    public static final String MYSELF_ERROR = "5504";
    
    /**
     * 缺少必要的字段
     */
    public static final String PARAM_ERROR = "5505";
    
    /**
     * 结果码
     */
    private String resultCode;
    
    /**
     * 结果描述
     */
    private String resultDesc;
    
    public String getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }
    
    public String getResultDesc()
    {
        return resultDesc;
    }
    
    public void setResultDesc(String resultDesc)
    {
        this.resultDesc = resultDesc;
    }
}
