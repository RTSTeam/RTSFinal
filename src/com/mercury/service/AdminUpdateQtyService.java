package com.mercury.service;

import com.mercury.dao.TicketDao;

public class AdminUpdateQtyService {
	private TicketDao td;
	
	public TicketDao getHd() {
		return td;
	}
	public void setHd(TicketDao td) {
		this.td = td;
	}
	
	public void updateTwoTypeQtyProcess(int ticketID, int newtotalqty, int newavailqty) {
		td.adminUpdateTwoTypeQty(ticketID, newtotalqty, newavailqty);
		return;
	}
}
