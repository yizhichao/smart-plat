package com.allcam.utils.exception;

import java.io.Serializable;

/**
 * 异常基类，所有平台模块子异常均需继承该基类。
 * @author marui
 */
public class SystemException extends RuntimeException
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1030123567669115158L;

    /**
     * 存储异常的数据Bean
     */
    protected ExceptionBean exceptionBean = new ExceptionBean();

    /**
     * 实例化WidgetException时传入的其他异常
     */
    private Throwable nestedThrowable = null;



    /**
     * 普通构造函数
     */
    public SystemException()
    {
        super();
    }

    /**
     * 封装其他异常为WidgetException
     *
     * @param cause
     *            异常
     */
    public SystemException(Throwable cause)
    {
        super(cause);
        this.nestedThrowable = cause;
    }

    /**
     * 带异常码的构造函数
     *
     * @param exceptionCode
     *            异常码
     */
    public SystemException(String exceptionCode)
    {
        super();
        exceptionBean.setCode(exceptionCode);
    }

    /**
     * 带异常码和异常描述的构造函数
     *
     * @param exceptionCode String
     * @param message String
     */
    public SystemException(String exceptionCode, String message)
    {
        super(message);
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setMessage(message);
    }

    /**
     * 带异常码的构造函数,封装其它异常
     *
     * @param exceptionCode
     *            异常码
     * @param cause
     *            异常
     */
    public SystemException(String exceptionCode, Throwable cause)
    {
        super(cause);
        exceptionBean.setCode(exceptionCode);
        this.nestedThrowable = cause;
    }

    /**
     * 带异常码、异常描述和异常堆栈的构造函数
     *
     * @param exceptionCode String
     * @param message String
     * @param cause Throwable
     */
    public SystemException(String exceptionCode, String message, Throwable cause)
    {
        super(message, cause);
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setMessage(message);
        this.nestedThrowable = cause;
    }

    /**
     * 带异常码和异常参数信息的构造函数
     *
     * @param exceptionCode
     *            异常码
     * @param exceptionArgs
     *            异常参数，不提供国际化
     */
    public SystemException(String exceptionCode, Object exceptionArgs)
    {
        super();
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setParameters(new Object[]
        {exceptionArgs });
    }

    /**
     * 带异常码和一组异常参数的构造函数
     *
     * @param exceptionCode
     *            异常码
     * @param exceptionArgs
     *            异常参数，不提供国际化
     */
    public SystemException(String exceptionCode, Object[] exceptionArgs)
    {
        super();
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setParameters(exceptionArgs);
    }

    /**
     * 带异常码和一组异常参数的构造函数
     *
     * @param exceptionCode
     *            异常码
     * @param exceptionArgs
     *            异常参数，不提供国际化
     * @param cause
     *            异常
     */
    public SystemException(String exceptionCode, Object[] exceptionArgs,
            Throwable cause)
    {
        super(cause);

        this.nestedThrowable = cause;
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setParameters(exceptionArgs);
    }

    /**
     * 带异常码和异常参数的构造函数
     *
     * @param exceptionCode
     *            异常码
     * @param exceptionArg
     *            异常参数，不提供国际化
     * @param cause
     *            异常
     */
    public SystemException(String exceptionCode, Object exceptionArg,
            Throwable cause)
    {
        super(cause);

        this.nestedThrowable = cause;
        exceptionBean.setCode(exceptionCode);
        exceptionBean.setParameters(new Object[]
        {exceptionArg });
    }

    /**
     * 获取异常码
     *
     * @return 返回相应的异常码
     */
    public String getExceptionCode()
    {
        return exceptionBean.getCode();
    }

    /**
     * 设置异常信息
     *
     * @param msg
     *            异常信息，不提供国际化
     */
    public void setMessage(String msg)
    {
        exceptionBean.setMessage(msg);
    }

    /**
     * 获取异常
     *
     * @return Throwable 异常
     */
    public Throwable getCause()
    {
        return this.nestedThrowable;
    }

    public Object[] getParamers()
    {
        return exceptionBean.getParameters();
    }

    /**
     * 异常属性Bean
     */
    private static class ExceptionBean implements Serializable
    {
        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = -8035309016877170717L;

        /**
         * 错误信息
         */
        private String message = "";

        /**
         * 错误码
         */
        private String code = ErrorCode.COMMON_UNKNOWN_ERROR;

        private Object[] parameters = null;

        // private Map attributes = new HashMap();

        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }

        public String getCode()
        {
            return code;
        }

        public void setCode(String code)
        {
            this.code = code;
        }

        public Object[] getParameters()
        {
            return parameters;
        }

        public void setParameters(Object[] parameters)
        {
            this.parameters = parameters;
        }
    }
}
