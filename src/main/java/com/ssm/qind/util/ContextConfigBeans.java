package com.ssm.qind.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取spring注册bean 
 * @author QinDong
 * @version 1.1, 2015/12/29
 */
public class ContextConfigBeans implements ApplicationContextAware {
	
	private static ApplicationContext appCtx;

	/**
	 * 此方法可以把ApplicationContext对象inject到当前类中作为一个静态成员变量。
	 *
	 * @param applicationContext
	 *            ApplicationContext 对象.
	 * @throws BeansException
	 * @author hzc
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appCtx = applicationContext;
	}

	/**
	 * 获取ApplicationContext
	 *
	 * @return
	 * @author hzc
	 */
	public static ApplicationContext getApplicationContext() {
		return appCtx;
	}

	/**
	 * 这是一个便利的方法，帮助我们快速得到一个BEAN
	 *
	 * @param beanName
	 *            bean的名字
	 * @return 返回一个bean对象
	 * @author hzc
	 */
	public static Object getBean(String beanName) {
		return appCtx.getBean(beanName);
	}
}