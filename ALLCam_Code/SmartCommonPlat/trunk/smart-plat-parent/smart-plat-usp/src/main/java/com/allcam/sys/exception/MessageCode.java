package com.allcam.sys.exception;

public interface MessageCode
{
    /** 成功 */
    public String SUCCESS = "0";
    
    public String FAIL = "1";
    
    /** 成功码 */
    String SUCCESS_CODE = "200";
    
    /** 成功描述 */
    String SUCCESS_DES = "OK";
    
    /** 失败码 */
    String FAIL_CODE = "500";
    
    /** 失败描述 */
    String FAIL_DES = "FAIL";
    
    // 1-1000 系统
    
    // add by yizhichao ErrorCode 1001 - 2100 登录功能 start
    // 登录用户不存在
    public String LOGIN_USER_IS_NOT_EXISTS = "1001";
    
    // 登录用户密码错误
    public String LOGIN_USER_PASS_IS_ERROR = "1002";
    
    // add by yizhichao ErrorCode 1001 - 2100 登录功能 end
    
    /** 其他错误 */
    String OTHER_EXCEPTION = "1003";
    
    /** 用户名或密码错误 */
    String USERNAME_OR_PWD_ERROR = "1008";
    
    /** 用户停用 */
    String USER_DISABLED = "1100";
    
    /** 用户套餐欠费 */
    String USER_IN_DEFICIT = "1101";
}
