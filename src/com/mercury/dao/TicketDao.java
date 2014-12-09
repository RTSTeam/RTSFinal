package com.mercury.dao;

import java.util.List;

import com.mercury.beans.Ticket;

public interface TicketDao {
	public void save(Ticket ticket);
	public void save(Ticket ticket, boolean hasRecord);
	public void delete(Ticket ticket);
	public List<Ticket> queryTickets(String departureStationName, String arrivalStationName, 
			int departureYear, int departureMonth, int departureDay, int departureHour,
			int neededQty);
	
	public void updateQty(int ticketid, int qty);
	
	public List<Ticket> queryAllTickets();
	public void adminUpdateTwoTypeQty(int ticketID, int newtotalqty, int newavailqty);
	public boolean hasRecord();
}
