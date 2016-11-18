package com.allcam.utils.filelog;

import org.aspectj.lang.ProceedingJoinPoint;

public interface LogAspectAdvice
{
	/**
	 * 
	 * @Title: aroundAdvice
	 * @Description: 环绕通知
	 * 
	 * @param pjp
	 *            连接点
	 * @return
	 * @throws Throwable
	 * @return: Object
	 * @Author: yizhichao
	 * @date: 2015年4月7日 上午11:57:13
	 */
	public abstract Object aroundAdvice(ProceedingJoinPoint pjp)
			throws Throwable;

}