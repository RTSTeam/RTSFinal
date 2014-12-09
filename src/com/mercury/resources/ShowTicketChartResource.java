package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.ChartInfo;
import com.mercury.service.ShowTicketChartService;

@Path("/ticketChart")
public class ShowTicketChartResource {
	private ShowTicketChartService stcs;
	
	public ShowTicketChartResource() {
		if (stcs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			stcs = (ShowTicketChartService)actx.getBean("ShowTicketChartService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ChartInfo execute(
			@FormParam("departureStationID") int departureStationID,
			@FormParam("arrivalStationID") int arrivalStationID,
			@FormParam("departureDate") String departureDate) throws NoSuchAlgorithmException {
		// MM/DD/YY
		String[] contentDate = departureDate.split("/");
		int departureYear = Integer.parseInt(contentDate[2]) + 2000;
		int departureMonth = Integer.parseInt(contentDate[0]);
		int departureDay = Integer.parseInt(contentDate[1]);
		
		//System.out.println("departureStationID: " + departureStationID);
		//System.out.println("arrivalStationID: " + arrivalStationID);
		//System.out.println("departureYear: " + departureYear);
		//System.out.println("departureMonth: " + departureMonth);
		//System.out.println("departureDay: " + departureDay);
		return stcs.process(departureStationID, arrivalStationID, departureYear, departureMonth, departureDay);
	}
}





