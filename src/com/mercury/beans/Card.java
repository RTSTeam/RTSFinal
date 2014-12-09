package com.mercury.beans;

public class Card {
	private int cardnumer;
	private String userid;
	private int expirationyear;
	private int expirationmonth;
	private String holdername;
	private int csv;
	public int getCardnumber() {
		return cardnumer;
	}
	public void setCardnumber(int cardnumer) {
		this.cardnumer = cardnumer;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getExpirationyear() {
		return expirationyear;
	}
	public void setExpirationyear(int expirationyear) {
		this.expirationyear = expirationyear;
	}
	public int getExpirationmonth() {
		return expirationmonth;
	}
	public void setExpirationmonth(int expirationmonth) {
		this.expirationmonth = expirationmonth;
	}
	public String getHoldername() {
		return holdername;
	}
	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}
	public int getCsv() {
		return csv;
	}
	public void setCsv(int csv) {
		this.csv = csv;
	}
	
	
}
