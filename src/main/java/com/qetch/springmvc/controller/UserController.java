package com.qetch.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qetch.springmvc.annotation.CheckLogin;

@Controller
@RequestMapping("/user")
@CheckLogin(value = CheckLogin.WEB)
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/login")
	public String login() {
		logger.info("--->login--->");
		return "userLogin";
	}
}
