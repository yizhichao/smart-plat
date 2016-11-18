package com.allcam.datasource;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置通知
 * 
 * @author Administrator
 * 
 */
public class DaoAdviser implements MethodBeforeAdvice
{
    
    private static final Logger LOGGER = Logger.getLogger(DaoAdviser.class);
    
    private Map<String, String> map;
    
    /**
     * 切点进行数据库的路由 method:要执行的目标方法 eg:public void com.allcam.smartEdu.dao.impl.LoginDaoImpl.getUser() objects:目标方法的参数
     * eg:[] obj:目标方法的类名地址 eg:com.allcam.smartEdu.dao.impl.LoginDaoImpl@65d587
     */
    @Override
    public void before(Method method, Object[] objects, Object obj)
        throws Throwable
    {
        String daoPackageName = obj.getClass().getPackage().getName();
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext();)
        {
            String key = it.next();
            String definePackageName = map.get(key);
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("Key Is:" + key);
            }
            if (daoPackageName.startsWith(definePackageName))
            {
                CustomerContextHolder.setCustomerType(key);
            }
        }
        
    }
    
    public Map<String, String> getMap()
    {
        return map;
    }
    
    public void setMap(Map<String, String> map)
    {
        this.map = map;
    }
    
}
