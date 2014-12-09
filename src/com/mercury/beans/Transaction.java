package com.mercury.beans;

public class Transaction {
	private int tranID;
	private String userID;
	private int ticketID;
	private double price;
	private int qty;
	private String tranType;
	
	public int getTranID() {
		return tranID;
	}
	public void setTranID(int tranID) {
		this.tranID = tranID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qyt) {
		this.qty = qyt;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	
	
}
