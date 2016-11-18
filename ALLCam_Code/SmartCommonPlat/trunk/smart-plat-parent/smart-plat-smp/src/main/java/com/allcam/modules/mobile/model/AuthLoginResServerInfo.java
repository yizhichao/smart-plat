package com.allcam.modules.mobile.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 单点登录接口返回的ServerInfo节点参数
 * 
 * @author  marui
 * @version  [版本号, Aug 25, 2015]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthLoginResServerInfo
{
    /**
     * 业务平台服务地址
     */
    private String bpcServerUrl;

    public String getBpcServerUrl()
    {
        return bpcServerUrl;
    }

    public void setBpcServerUrl(String bpcServerUrl)
    {
        this.bpcServerUrl = bpcServerUrl;
    }

}
