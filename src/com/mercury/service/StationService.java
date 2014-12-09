package com.mercury.service;

import com.mercury.beans.Station;
import com.mercury.beans.StationInfo;
import com.mercury.dao.StationDao;

public class StationService {
	private StationDao sd;

	public StationDao getSd() {
		return sd;
	}

	public void setSd(StationDao sd) {
		this.sd = sd;
	}
	
	public StationInfo saveProcess(Station station) {
		sd.save(station);
		StationInfo stationIDInfo = new StationInfo();
		//userIDInfo.setUserids(rnd.queryAllUserID());
		stationIDInfo.setStation(sd.queryAll());
		return stationIDInfo;
	}
}
