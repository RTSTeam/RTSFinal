package com.mercury.service;

import com.mercury.beans.TicketInfo;
import com.mercury.dao.TicketDao;

public class SearchService {
	private TicketDao td;
	
	public TicketDao getHd() {
		return td;
	}
	public void setHd(TicketDao td) {
		this.td = td;
	}
	
	public TicketInfo process(String departureStationName, String arrivalStationName, 
			int departureYear, int departureMonth, int departureDay, int departureHour,
			int neededQty) {
		//td.save(rtsuser);
		//RTSUserInfo rtsuserInfo = new RTSUserInfo();
		//rtsuserInfo.setMsg(this.sayHello2(rtsuser));
		//rtsuserInfo.setRtsusers(rd.queryAll());
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setTickets(td.queryTickets(departureStationName, arrivalStationName, departureYear, departureMonth, departureDay, departureHour, neededQty));
		return ticketInfo;
	}
}
