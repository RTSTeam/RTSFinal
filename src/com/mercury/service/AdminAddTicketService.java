package com.mercury.service;

import com.mercury.beans.Ticket;
import com.mercury.dao.TicketDao;

public class AdminAddTicketService {
	private TicketDao td;
	
	public TicketDao getHd() {
		return td;
	}
	public void setHd(TicketDao td) {
		this.td = td;
	}
	
	public void saveProcess(Ticket ticket) {
		boolean hasRecord = td.hasRecord();
		td.save(ticket, hasRecord);
		return;
	}
}
