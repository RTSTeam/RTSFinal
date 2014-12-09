package com.mercury.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ChartInfo {
	private int avaiQty;
	private int soldQty;
	
	@XmlElement(name="avaiQty")
	public int getAvaiQty() {
		return avaiQty;
	}
	public void setAvaiQty(int avaiQty) {
		this.avaiQty = avaiQty;
	}
	
	@XmlElement(name="soldQty")
	public int getSoldQty() {
		return soldQty;
	}
	public void setSoldQty(int soldQty) {
		this.soldQty = soldQty;
	}
}
