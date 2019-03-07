package com.qetch.springmvc.interceptor;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBaseAccessInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(TimeBaseAccessInterceptor.class);
	
	private int openingTime;
	private int closingTime;
	private String mappingURL;// 利用正则表达式映射到需要拦截的路径

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("--->进入 preHandle 方法--->");
		
		String url = request.getRequestURL().toString();
		if (null == mappingURL || url.matches(mappingURL)) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int now = calendar.get(Calendar.HOUR_OF_DAY);
			if (now < openingTime || now > closingTime) {
				request.setAttribute("msg", "注册开放时间：9:00-12:00");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("--->进入 postHandle 方法--->");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("--->进入 afterCompletion 方法--->");
		super.afterCompletion(request, response, handler, ex);
	}
	
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public int getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
	public String getMappingURL() {
		return mappingURL;
	}
	public void setMappingURL(String mappingURL) {
		this.mappingURL = mappingURL;
	}
}
