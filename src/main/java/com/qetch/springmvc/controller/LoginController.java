package com.qetch.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qetch.springmvc.controller.util.Util;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/tologin")
	public String toLogin(HttpServletRequest request, HttpServletResponse response, String username, String password, String gotoURL) {
		if (Util.checkLogin(username, password)) {
			Cookie cookie = new Cookie("ssoCookie", "sso");
			cookie.setMaxAge(1 * 24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			String url = gotoURL.replaceAll("%2", "/");
			return "redirect:" + url;
		}
		return null;
	}
}
