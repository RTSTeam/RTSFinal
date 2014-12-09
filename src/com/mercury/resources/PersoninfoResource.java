package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.mercury.beans.RTSUserInfo;
import com.mercury.service.PersoninfoService;


@Path("/userpersoninfo")
public class PersoninfoResource {
	private PersoninfoService ps;
	
	public PersoninfoResource(){
		if (ps==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			ps = (PersoninfoService)actx.getBean("personinfoService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RTSUserInfo execute(
			@FormParam("userID") String userid
			) throws NoSuchAlgorithmException {
		
		return ps.process(userid);
	}
}
