package com.allcam.framework.utils;

/**
 * 系统 文件信息
 * 
 * @author  marui
 * @version  [版本号, 2015-3-4]
 */
public class SystemInfo
{
    private int id;
    
    // 系统名称
    private String title = "NVS";
    
    // 网站地址URL
    private String url = "系统的URL地址";
    
    // 网站是否开启
    private int open = 1;
    
    // 网站关闭时的文字说明
    private String closedDesc = "系统关闭时的说明文字,支持HTML";
    
    // 是否使用验证码
    private int useCaptche = 0;
    
    // 系统风格主题
    private int theme = 0;
    
    // 是否使用短信验证码
    private int userSmsCheckCode = 0;
    
    // 设置密码输错多少次，该账户被锁定，0为不锁定
    private int passworderrors = 0;
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public String getClosedDesc()
    {
        return closedDesc;
    }
    
    public void setClosedDesc(String closedDesc)
    {
        this.closedDesc = closedDesc;
    }
    
    public int getOpen()
    {
        return open;
    }
    
    public void setOpen(int open)
    {
        this.open = open;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getUseCaptche()
    {
        return useCaptche;
    }
    
    public void setUseCaptche(int useCaptche)
    {
        this.useCaptche = useCaptche;
    }
    
    public int getUserSmsCheckCode()
    {
        return userSmsCheckCode;
    }
    
    public void setUserSmsCheckCode(int userSmsCheckCode)
    {
        this.userSmsCheckCode = userSmsCheckCode;
    }
    
    public int getPassworderrors()
    {
        return passworderrors;
    }
    
    public void setPassworderrors(int passworderrors)
    {
        this.passworderrors = passworderrors;
    }
    
    public int getTheme()
    {
        return theme;
    }
    
    public void setTheme(int theme)
    {
        this.theme = theme;
    }
}
