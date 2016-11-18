package com.allcam.common;

public class BaseInfo
{
    private String clientIp;
    
    private String clientPort;
    
    public String getClientIp()
    {
        return clientIp;
    }
    
    public void setClientIp(String clientIp)
    {
        this.clientIp = clientIp;
    }
    
    public String getClientPort()
    {
        return clientPort;
    }
    
    public void setClientPort(String clientPort)
    {
        this.clientPort = clientPort;
    }
    
    @Override
    public String toString()
    {
        return "BaseInfo [clientIp=" + clientIp + ", clientPort=" + clientPort + "]";
    }
}
