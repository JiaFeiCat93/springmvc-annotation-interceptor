package com.qetch.springmvc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author ZCW
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckLogin {
	
	/**
	 * 前台登录value 
	 */
	public static final String WEB = "WEB";
	
	/**
	 * 后台登录value
	 */
	public static final String ADMIN = "ADMIN";
	
	/**
	 * 默认前台登录
	 * @return
	 */
	String value() default WEB;
}
