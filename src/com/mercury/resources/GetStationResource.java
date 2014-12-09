package com.mercury.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.StationInfo;
import com.mercury.service.GetStationService;

@Path("/getstation")
public class GetStationResource {
	private GetStationService gs;
	
	public GetStationResource() {
		if (gs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			gs = (GetStationService)actx.getBean("GetStationService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StationInfo execute() {
		return gs.process();
	}
}
