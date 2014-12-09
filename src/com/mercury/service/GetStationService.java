package com.mercury.service;

import com.mercury.beans.StationInfo;
import com.mercury.dao.StationDao;

public class GetStationService {
	private StationDao sd;
	
	public StationDao getHd() {
		return sd;
	}
	public void setHd(StationDao sd) {
		this.sd = sd;
	}
	
	public StationInfo process() {
		StationInfo stationInfo = new StationInfo();
		stationInfo.setStation(sd.queryAll());
		return stationInfo;
	}
}
