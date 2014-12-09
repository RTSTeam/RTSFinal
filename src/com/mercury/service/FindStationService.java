package com.mercury.service;

import com.mercury.beans.StationInfo;
import com.mercury.dao.StationDao;

public class FindStationService {
	private StationDao sd;

	public StationDao getSd() {
		return sd;
	}

	public void setSd(StationDao sd) {
		this.sd = sd;
	}
	
	public StationInfo findAllProcess() {
		StationInfo stationIDInfo = new StationInfo();
		//userIDInfo.setUserids(rnd.queryAllUserID());
		stationIDInfo.setStation(sd.queryAll());
		return stationIDInfo;
	}
}
