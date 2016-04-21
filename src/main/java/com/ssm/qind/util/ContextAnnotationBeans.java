package com.ssm.qind.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 获取spring mvc 下注解的bean
 * @author QinDong
 * @version 1.1, 2015/12/29
 */
public class ContextAnnotationBeans {
	

	/**
	 * 返回需要的注解的bean
	 *
	 * @param beanName
	 *            bean的名字
	 * @return 返回一个bean对象
	 * @author hzc
	 */
	public static Object getBean(String beanName) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(); 
		ctx.scan("com.ssm.qind.*"); 
		ctx.refresh(); 
		return ctx.getBean(beanName);
		
	}
}