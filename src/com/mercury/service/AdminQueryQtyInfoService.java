package com.mercury.service;

import com.mercury.beans.TicketInfo;
import com.mercury.dao.TicketDao;

public class AdminQueryQtyInfoService {
	private TicketDao td;
	
	public TicketDao getHd() {
		return td;
	}
	public void setHd(TicketDao td) {
		this.td = td;
	}
	
	public TicketInfo queryQTYProcess() {
		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setTickets(td.queryAllTickets());
		return ticketInfo;
	}
}
