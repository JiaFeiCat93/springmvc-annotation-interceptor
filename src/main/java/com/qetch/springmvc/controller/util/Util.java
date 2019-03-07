package com.qetch.springmvc.controller.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Util {
	
	/**
	 * 模拟数据库
	 */
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "123";
	
	/**
	 * 判断登录是否有效
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean checkLogin(String username, String password) {
		if (username.equals(USERNAME) && password.equals(PASSWORD)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断cookie是否有效
	 * @param request
	 * @return
	 */
	public static boolean checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("ssoCookie".equals(cookie.getName()) && "sso".equals(cookie.getValue())) {
					return true;
				}
			}
		}
		return false;
	}
}
