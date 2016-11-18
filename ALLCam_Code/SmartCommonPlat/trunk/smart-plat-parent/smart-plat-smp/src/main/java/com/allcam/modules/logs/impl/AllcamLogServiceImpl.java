package com.allcam.modules.logs.impl;

import org.springframework.stereotype.Service;

import com.allcam.modules.logs.inf.AllcamLogService;
import com.allcam.modules.logs.model.Log;

@Service
public class AllcamLogServiceImpl implements AllcamLogService
{
    
    @Override
    public void save(Log log)
    {
        System.out.println("LogServiceImpl.save()" + log);
    }
    
}
