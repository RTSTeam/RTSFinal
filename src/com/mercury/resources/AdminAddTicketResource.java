package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.Ticket;
import com.mercury.service.AdminAddTicketService;

@Path("/adminaddticket")
public class AdminAddTicketResource {

	private AdminAddTicketService aats;
	
	public AdminAddTicketResource(){
		if (aats==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			aats = (AdminAddTicketService)actx.getBean("adminAddTicketService");
		}
	}
	@POST
	@Produces({MediaType.TEXT_HTML})
	public String execute(
			@FormParam("departureStationValue") String departureStationName,
			@FormParam("arrivalStationValue") String arrivalStationName,
			@FormParam("departureDate") String departureDate,
			@FormParam("departureTime") String departureTime,
			@FormParam("arrivalDate") String arrivalDate,
			@FormParam("arrivalTime") String arrivalTime,
			@FormParam("price") String price,
			@FormParam("totalqty") String totalqty,
			@FormParam("avalqty") String avalqty
			) throws NoSuchAlgorithmException {
		//Sun Dec 14 2014 00:00:00 GMT-0500 (Eastern Standard Time)
		String[] contentDateD = departureDate.split(" ");
		String[] contentTimeD = departureTime.split(" ");
		int departureYear = Integer.parseInt(contentDateD[3]);
		String departureMonthStr = contentDateD[1];
		
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
		
		int departureDay = Integer.parseInt(contentDateD[2]);
		String[] departureTimeStr = contentTimeD[4].split(":");
		int departureHour = Integer.parseInt(departureTimeStr[0]);
		int departureMinute = Integer.parseInt(departureTimeStr[1]);
		
		
		//Sun Dec 14 2014 00:00:00 GMT-0500 (Eastern Standard Time)
				String[] contentDateA = arrivalDate.split(" ");
				String[] contentTimeA = arrivalTime.split(" ");
				int arrivalYear = Integer.parseInt(contentDateA[3]);
				String arrivalMonthStr = contentDateA[1];
				
				int arrivalMonth = 0;
				if(arrivalMonthStr.equals("Jan")){
					arrivalMonth = 1;
				}else if(arrivalMonthStr.equals("Feb")){
					arrivalMonth = 2;
				}else if(arrivalMonthStr.equals("Mar")){
					arrivalMonth = 3;
				}else if(arrivalMonthStr.equals("Apr")){
					arrivalMonth = 4;
				}else if(arrivalMonthStr.equals("May")){
					arrivalMonth = 5;
				}else if(arrivalMonthStr.equals("Jun")){
					arrivalMonth = 6;
				}else if(arrivalMonthStr.equals("Jul")){
					arrivalMonth = 7;
				}else if(arrivalMonthStr.equals("Aug")){
					arrivalMonth = 8;
				}else if(arrivalMonthStr.equals("Sep")){
					arrivalMonth = 9;
				}else if(arrivalMonthStr.equals("Oct")){
					arrivalMonth = 10;
				}else if(arrivalMonthStr.equals("Nov")){
					arrivalMonth = 11;
				}else if(arrivalMonthStr.equals("Dec")){
					arrivalMonth = 12;
				}
				
				int arrivalDay = Integer.parseInt(contentDateA[2]);
				String[] arrivalTimeStr = contentTimeA[4].split(":");
				int arrivalHour = Integer.parseInt(arrivalTimeStr[0]);
				int arrivalMinute = Integer.parseInt(arrivalTimeStr[1]);
		//int neededQty = Integer.parseInt(adultsValue) + Integer.parseInt(seniorsValue) + Integer.parseInt(childrenValue);
		int intPrice = Integer.parseInt(price);
		int intTotalqty = Integer.parseInt(totalqty);
		int intAvalqty = Integer.parseInt(avalqty);
		System.out.println(departureStationName);
		System.out.println(arrivalStationName);
		System.out.println(departureYear);
		System.out.println(departureMonth);
		System.out.println(departureDay);
		System.out.println(departureHour);
		//System.out.println(neededQty);
		Ticket ticket = new Ticket();
		ticket.setDepartureStationName(departureStationName);
		ticket.setArrivalStationName(arrivalStationName);
		ticket.setDepartureYear(departureYear);
		ticket.setDepartureMonth(departureMonth);
		ticket.setDepartureDay(departureDay);
		ticket.setDepartureHour(departureHour);
		ticket.setDepartureMinute(departureMinute);
		
		ticket.setArrivalYear(arrivalYear);
		ticket.setArrivalMonth(arrivalMonth);
		ticket.setArrivalDay(arrivalDay);
		ticket.setArrivalHour(arrivalHour);
		ticket.setArrivalMinute(arrivalMinute);
		
		ticket.setPrice(intPrice);
		ticket.setTotalQty(intTotalqty);
		ticket.setAvaiQty(intAvalqty);
		aats.saveProcess(ticket);
		return "Successfully insert a new ticket";
	}
}
