package com.mercury.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
	private String viewPage;

	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
//	@RequestMapping("/registration")
//	public ModelAndView change(){
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:" + viewPage); //redirect is key word for redirect
//		return mav;
//	} 
	
	 @RequestMapping(value ="/registration", method = RequestMethod.GET)
	    public ModelAndView method() {
		 		ModelAndView mav = new ModelAndView();
		 		mav.setViewName("registration");
	            return mav;

	    }
	 @RequestMapping(value ="/checkusernameunique", method = RequestMethod.GET)
	    public ModelAndView checkUniqueUserName() {
		 		ModelAndView mav = new ModelAndView();
		 		mav.setViewName("checkusernameunique");
	            return mav;

	    }

}
