package com.allcam.log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class LogAspect
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(com.allcam.log.SystemServiceLog)")
    public void serviceAspect()
    {
    }

    @Around("serviceAspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        // 读取session中的用户
//        UserInfo user = (UserInfo) session.getAttribute("UserInfo");
        Object ret = null;
//        LogInfo logInfo = new LogInfo();
        try
        {
            ret = proceedingJoinPoint.proceed();
//            Object[] arguments = proceedingJoinPoint.getArgs();
//            String description = getServiceMethodDescription(proceedingJoinPoint);
//            ret = proceedingJoinPoint.proceed();
//            String params = Arrays.toString(arguments);
//            if (params.length() >= 2048)
//            {
//                params = params.substring(0, 2048);
//            }
//            logInfo.setReqParams(params);
//            logInfo.setDescription(description);
//            logInfo.setIp(request.getRemoteAddr());
//            logInfo.setUserId(user.getUserId());
//            logInfo.setUserName(user.getUserName());
//            logInfo.setOperateDate(DateUtil.formatTime(new Date(), DateUtil.DATE_19));
//            if (ret != null)
//            {
//                String res = JsonParseUtil.obj2Json(ret);
//                if (res.length() >= 2048)
//                {
//                    logInfo.setResultMsg(res.substring(0, 2048));
//                }
//                else
//                {
//                    logInfo.setResultMsg(res);
//                }
//            }
//            logInfo.setOperateResult("成功");
        }
        catch (Exception e)
        {
            LOGGER.error("Operate Error...", e);
//            logInfo.setOperateResult("失败");
//            logInfo.setResultMsg(e.getMessage());
        }
        catch (Throwable e)
        {
            LOGGER.error("Operate Error...", e);
//            logInfo.setOperateResult("失败");
//            logInfo.setResultMsg(e.getMessage());
        }
//        logDao.saveLog(logInfo);
        return ret;
    }

    public static String getServiceMethodDescription(ProceedingJoinPoint joinPoint)
            throws Exception
    {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods)
        {
            if (method.getName().equals(methodName))
            {
                Class<?>[] clazzs = method.getParameterTypes();
                // 可能有方法重载
                if (clazzs.length == arguments.length)
                {
                    Annotation[] annotations = method.getAnnotations();
                    if (ArrayUtils.isNotEmpty(annotations))
                    {
                        for (Annotation annotation : annotations)
                        {
                            if (annotation instanceof SystemServiceLog)
                            {
                                description = ((SystemServiceLog) annotation).description();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return description;
    }

}
