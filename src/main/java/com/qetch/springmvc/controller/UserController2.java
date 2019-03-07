package com.qetch.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qetch.springmvc.domain.User;

@Controller
@RequestMapping("/user.do")
public class UserController2 {

	@RequestMapping(params = "action=reg")
	public ModelAndView reg(User user) {
		// save user
		return new ModelAndView("profile", "user", user);
	}
}
