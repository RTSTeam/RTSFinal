package com.mercury.dao;

public interface ChartInfoDao {
	public int queryAvaiTickets(int departureStationID, int arrivalStationID,
			int departureYear, int departureMonth, int departureDay);
	public int querySoldTickets(int departureStationID, int arrivalStationID,
			int departureYear, int departureMonth, int departureDay);
}
