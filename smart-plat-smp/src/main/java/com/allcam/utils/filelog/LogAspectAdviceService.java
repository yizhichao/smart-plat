package com.allcam.utils.filelog;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.allcam.utils.BeanTools;

public class LogAspectAdviceService implements LogAspectAdvice
{
	/** 日志  */
    private static final Logger log = LoggerFactory.getLogger(LogAspectAdviceService.class);
    
    @Override
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
	{
		String wholeName = pjp.getSignature().toLongString();
		String methodName = wholeName.substring(wholeName.indexOf(pjp
				.getSignature().getName()));
		String className = pjp.getTarget().getClass().getName();

		// 记录入口日志
		if (log.isInfoEnabled())
		{
			StringBuilder sbfEnter = new StringBuilder();
			sbfEnter.append("Enter " + className + "." + methodName);
			log.info(sbfEnter.toString());
		}

		// 记录参数日志
		if (log.isDebugEnabled())
		{
			// 获取调用方法的参数，记录参数日志
		    StringBuilder sbfArgs = new StringBuilder();
			sbfArgs.append("  Parameters:[");
			Object[] args = pjp.getArgs();
			if (null != args && args.length != 0)
			{
				constructString(sbfArgs, args);
			}
			sbfArgs.append("]");
			log.debug(sbfArgs.toString());
		}

		// 执行切入点方法
		Object returnObj = null;
		try
		{
			returnObj = pjp.proceed();
		}
		catch (Exception e)
		{
			// 记录异常日志
			StringBuilder sbe = new StringBuilder();
			sbe.append("Exception Infomation[" + e.getMessage() + "]");
			log.error(sbe.toString(), e);
			throw e;
		}

		// 记录返回值日志
		if (null != returnObj && log.isDebugEnabled())
		{
		    StringBuilder sbfReturn = new StringBuilder();
			sbfReturn.append("  Return Value[ ");
			constructString(sbfReturn, new Object[]{returnObj});
			sbfReturn.append("]");
			log.debug(sbfReturn.toString());
		}

		// 记录出口日志
		if (log.isInfoEnabled())
		{
			StringBuilder sbfExit = new StringBuilder();
			sbfExit.append("Exit " + className + "." + methodName);
			log.info(sbfExit.toString());
		}
		
		return returnObj;
	}

	/**
	 * @Title: constructString
	 * @Description: 拼接參數，用于日志參數的記錄。
	 *
	 * @param sbfArgs
	 * @param args
	 * @return: void
	 * @Author: yizhichao
	 * @date: 2015年4月7日 上午11:58:26
	 */
	private void constructString(StringBuilder sbfArgs, Object[] args) 
	{
		for (int i = 0; i < args.length; i++)
		{
			String classType = null;
			if(null == args[i]) 
			{
				sbfArgs.append("[Type: null ");
			}
			else
			{
				classType = args[i].getClass().getName();
				sbfArgs.append("[Type: " + classType);
			}

			if (null == args[i]) 
			{
				sbfArgs.append(", Value: null ], ");
			} 
			else if (args[i] instanceof String
					|| args[i] instanceof Number
					|| args[i] instanceof Boolean
					|| args[i] instanceof Character) 
			{
				sbfArgs.append(", Value:" + args[i] + "], ");
			} 
			else if (args[i] instanceof Object[]) 
			{
				sbfArgs.append(", Value:" + Arrays.deepToString(new Object[]{args[i]}) + "], ");
			} 
			else
			{
				sbfArgs.append(", Value:"
						+ BeanTools.beanToString(args[i]) + "], ");
			}
		}
		
		if (sbfArgs.length() > 0)
		{
			sbfArgs.delete(sbfArgs.lastIndexOf(","), sbfArgs.length());
		}
	}
}
