package com.allcam.modules.logs.model;

import java.io.Serializable;

public class User implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 408913039107463252L;
    private String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return "User [name=" + name + "]";
    }
}
