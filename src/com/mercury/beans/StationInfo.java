package com.mercury.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StationInfo {

	private String msg;
	private List<Station> station;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@XmlElement(name="station")
	public List<Station> getStation() {
		return station;
	}
	public void setStation(List<Station> station) {
		this.station = station;
	}

}
