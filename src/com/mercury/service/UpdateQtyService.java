package com.mercury.service;

import com.mercury.dao.TicketDao;

public class UpdateQtyService {
	private TicketDao td;
	
	public TicketDao getHd() {
		return td;
	}
	public void setHd(TicketDao td) {
		this.td = td;
	}
	
	public void process(int ticketid, int qty) {
		td.updateQty(ticketid, qty);
	}
}
