package com.mercury.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	private String viewPage;

	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	@RequestMapping(value ="/main", method = RequestMethod.GET)
    public ModelAndView method() {
	 		ModelAndView mav = new ModelAndView();
	 		mav.setViewName("main");
	 		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 		String name = auth.getName();
	 		mav.addObject("userid", name);
            return mav;

    }
}	
