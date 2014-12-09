package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.mercury.beans.Station;
import com.mercury.service.InsertStationService;


@Path("/insertstation")
public class InsertStationResource {
	private InsertStationService iss;
	
	public InsertStationResource() {
		if (iss==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			iss = (InsertStationService)actx.getBean("insertStationService");
		}
	}
	
	@POST
	@Produces({MediaType.TEXT_HTML})
	public String execute(
			@FormParam("stationabbrevation") String stationAbbr,
			@FormParam("stationfullname") String stationFullName
			) throws NoSuchAlgorithmException {
		Station station = new Station();
		station.setStationAbbr(stationAbbr);
		station.setStationFullName(stationFullName);
		iss.saveProcess(station);
		StringBuilder result = new StringBuilder();
		result.append("You insert a new record: ").append(stationAbbr).append(stationFullName);
		return  result.toString();
	} 
	
	/*@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public StationInfo execute(
			@FormParam("stationabbrevation") String stationAbbr,
			@FormParam("stationfullname") String stationFullName
			) throws NoSuchAlgorithmException {
		Station station = new Station();
		station.setStationAbbr(stationAbbr);
		station.setStationFullName(stationFullName);
		return ss.saveProcess(station);
	}*/
}
