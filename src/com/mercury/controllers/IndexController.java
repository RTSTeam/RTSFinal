package com.mercury.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private String viewPage;

	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	@RequestMapping(value ="/index", method = RequestMethod.GET)
    public ModelAndView method() {
	 		ModelAndView mav = new ModelAndView();
	 		mav.setViewName("index");
            return mav;

    }
}	
