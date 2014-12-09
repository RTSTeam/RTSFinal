package com.mercury.service;

import com.mercury.beans.Station;
import com.mercury.dao.StationDao;

public class InsertStationService {
	private StationDao sd;

	public StationDao getSd() {
		return sd;
	}

	public void setSd(StationDao sd) {
		this.sd = sd;
	}
	
	public void saveProcess(Station station) {
		boolean hasRecord = sd.hasRecord();
		sd.save(station, hasRecord);
		return;
	}
}
