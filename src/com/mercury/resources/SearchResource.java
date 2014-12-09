package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TicketInfo;
import com.mercury.service.SearchService;

@Path("/search")
public class SearchResource {
	private SearchService ss;
	
	public SearchResource() {
		if (ss==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			ss = (SearchService)actx.getBean("SearchService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public TicketInfo execute(
			@FormParam("tripType") String tripType,
			@FormParam("departureStationValue") String departureStationName,
			@FormParam("arrivalStationValue") String arrivalStationName,
			@FormParam("departureDate") String departureDate,
			@FormParam("departureTime") String departureTime,
			@FormParam("adultsValue") String adultsValue,
			@FormParam("seniorsValue") String seniorsValue,
			@FormParam("childrenValue") String childrenValue) throws NoSuchAlgorithmException {
		//Sun Dec 14 2014 00:00:00 GMT-0500 (Eastern Standard Time)
		String[] contentDate = departureDate.split(" ");
		String[] contentTime = departureTime.split(" ");
		int departureYear = Integer.parseInt(contentDate[3]);
		String departureMonthStr = contentDate[1];
		
		int departureMonth = 0;
		if(departureMonthStr.equals("Jan")){
			departureMonth = 1;
		}else if(departureMonthStr.equals("Feb")){
			departureMonth = 2;
		}else if(departureMonthStr.equals("Mar")){
			departureMonth = 3;
		}else if(departureMonthStr.equals("Apr")){
			departureMonth = 4;
		}else if(departureMonthStr.equals("May")){
			departureMonth = 5;
		}else if(departureMonthStr.equals("Jun")){
			departureMonth = 6;
		}else if(departureMonthStr.equals("Jul")){
			departureMonth = 7;
		}else if(departureMonthStr.equals("Aug")){
			departureMonth = 8;
		}else if(departureMonthStr.equals("Sep")){
			departureMonth = 9;
		}else if(departureMonthStr.equals("Oct")){
			departureMonth = 10;
		}else if(departureMonthStr.equals("Nov")){
			departureMonth = 11;
		}else if(departureMonthStr.equals("Dec")){
			departureMonth = 12;
		}
		
		int departureDay = Integer.parseInt(contentDate[2]);
		String[] departureTimeStr = contentTime[4].split(":");
		int departureHour = Integer.parseInt(departureTimeStr[0]);
		//int departureMinute = Integer.parseInt(departureTimeStr[1]);
		
		int neededQty = Integer.parseInt(adultsValue) + Integer.parseInt(seniorsValue) + Integer.parseInt(childrenValue);
		
		System.out.println(departureStationName);
		System.out.println(arrivalStationName);
		System.out.println(departureYear);
		System.out.println(departureMonth);
		System.out.println(departureDay);
		System.out.println(departureHour);
		System.out.println(neededQty);
		
		return ss.process(departureStationName, arrivalStationName, departureYear, departureMonth, departureDay, departureHour, neededQty);
	}
}





