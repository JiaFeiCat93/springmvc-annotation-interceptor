package com.qetch.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qetch.springmvc.annotation.CheckLogin;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(CheckLoginInterceptor.class);
	
	/**
	 * 预处理
	 * 可以进行编码、安全控制等处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("--->进入 preHandle 方法--->");
		boolean bool = false;
		// 配合自定义注解使用
		Class<? extends Object> clazz = handler.getClass();
		CheckLogin checkLogin = clazz.getAnnotation(CheckLogin.class);
		if (checkLogin != null) {
			String value = checkLogin.value();
			// 判断是否前台登录
			if (value.equals(CheckLogin.WEB)) {
				Object obj = request.getSession().getAttribute("login");
				if (null == obj) {
					String basePath = request.getScheme() + "://" + request.getServerName() + ":" 
							+ request.getServerPort() + request.getContextPath() + "/";
					// 跳转到登录页面
					response.sendRedirect(basePath + "index/gotopage");
				} else {
					bool = true;
				}
			}
		} else {
			bool = true;
		}
		return bool;
	}
	
	/**
	 * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染）
	 * 有机会修改ModelAndView
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("--->进入 postHandle 方法--->");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 返回处理（已经渲染了页面）
	 * 可以根据ex是否为null判断是否发生了异常，进行日志记录
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("--->进入 afterCompletion 方法--->");
		super.afterCompletion(request, response, handler, ex);
	}
}
