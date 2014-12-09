package com.mercury.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
//	@RequestMapping(value="/main", method = RequestMethod.GET)
//	public ModelAndView mainPage() {	
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("hello");
//		mav.addObject("title", "Sample06: Spring Security + Spring 3 MVC ~ Hibernate");
//		return mav;
//	}
}
