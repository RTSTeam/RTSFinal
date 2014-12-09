package com.mercury.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RTSUserInfo {
	private List<RTSUser> personinfos;
	
	@XmlElement(name="personinfo")
	public List<RTSUser> getPersoninfos() {
		return personinfos;
	}

	public void setPersoninfos(List<RTSUser> personinfos) {
		this.personinfos = personinfos;
	}
	
}
