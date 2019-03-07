package com.qetch.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qetch.springmvc.controller.util.Util;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping("/gotopage")
	public String index(HttpServletRequest request) {
		if (Util.checkCookie(request)) {
			request.getSession().setAttribute("login", "userLogin");
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("/gotopage2")
	public String index2(HttpServletRequest request) {
		if (Util.checkCookie(request)) {
			return "index2";
		}
		return "login2";
	}
}
