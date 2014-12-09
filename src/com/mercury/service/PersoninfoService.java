package com.mercury.service;

import com.mercury.beans.RTSUserInfo;
import com.mercury.dao.PersoninfoDao;

public class PersoninfoService {
	private PersoninfoDao pd;

	public PersoninfoDao getPd() {
		return pd;
	}
	public void setPd(PersoninfoDao pd) {
		this.pd = pd;
	}

	public RTSUserInfo process(String userID) {
		
		RTSUserInfo personinfo = new RTSUserInfo();
		personinfo.setPersoninfos(pd.queryPersoninfo(userID));
		return personinfo;
	}
}
