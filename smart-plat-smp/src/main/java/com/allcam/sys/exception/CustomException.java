package com.allcam.sys.exception;

public class CustomException extends Exception
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 6944861861674941345L;

    public CustomException()
    {
        super();
    }
    
    public CustomException(String msg)
    {
        super(msg);
    }
    
    public CustomException(String msg, Throwable cause)
    {
        super(msg, cause);
    }
    
    public CustomException(Throwable cause)
    {
        super(cause);
    }
}
