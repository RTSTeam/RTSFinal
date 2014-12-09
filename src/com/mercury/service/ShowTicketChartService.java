package com.mercury.service;

import com.mercury.beans.ChartInfo;
import com.mercury.dao.ChartInfoDao;

public class ShowTicketChartService {
	private ChartInfoDao cid;
	
	public ChartInfoDao getHd() {
		return cid;
	}
	public void setHd(ChartInfoDao cid) {
		this.cid = cid;
	}
	
	public ChartInfo process(int departureStationID, int arrivalStationID, 
		int departureYear, int departureMonth, int departureDay) {
		ChartInfo chartInfo = new ChartInfo();
		chartInfo.setAvaiQty(cid.queryAvaiTickets(departureStationID, arrivalStationID, departureYear, departureMonth, departureDay));
		chartInfo.setSoldQty(cid.querySoldTickets(departureStationID, arrivalStationID, departureYear, departureMonth, departureDay));
		System.out.println("avaiQty: " + chartInfo.getAvaiQty());
		System.out.println("soldQty: " + chartInfo.getSoldQty());
		return chartInfo;
	}
}
