package com.allcam.utils;

/**
 * 
 配置模块异常。
 * 
 * @author YiZhichao
 * @version [版本号, 2015-7-15]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConfigException extends Exception
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8860339221179350905L;
    
    /**
     * 封装其他异常为ConfigException
     * 
     * @param cause 异常
     */
    public ConfigException(Throwable cause)
    {
        super(cause);
    }
    
    /**
     * 封装其他异常为WidgetException
     * 
     * @param message 异常
     */
    public ConfigException(String message)
    {
        super(message);
    }
    
    /**
     * 带异常码的构造函数,封装其它异常
     * 
     * @param message String 异常码
     * @param cause Throwable 异常
     */
    public ConfigException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
