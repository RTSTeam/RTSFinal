package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.StationInfo;
import com.mercury.service.FindStationService;

@Path("/findallstation")
public class FindAllStationResource {
private FindStationService fss;
	
	public FindAllStationResource() {
		if (fss==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			fss = (FindStationService)actx.getBean("findStationService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StationInfo execute(
			) throws NoSuchAlgorithmException {
		return fss.findAllProcess();
	}
}
