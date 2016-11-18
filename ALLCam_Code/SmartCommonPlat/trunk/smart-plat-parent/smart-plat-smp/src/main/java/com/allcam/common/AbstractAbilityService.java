package com.allcam.common;

import com.allcam.modules.bean.bpm.RequestInfo;
import com.allcam.modules.bean.bpm.ResponseInfo;

public abstract class AbstractAbilityService implements ServiceContants
{
    /**
     * 抽象出操作,进行操作.
     * 
     * @return 返回通用返回对象
     */
    public abstract ResponseInfo exec(RequestInfo info);
    
}
