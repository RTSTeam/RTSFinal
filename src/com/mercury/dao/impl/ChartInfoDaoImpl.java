package com.mercury.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import com.mercury.dao.ChartInfoDao;

public class ChartInfoDaoImpl implements ChartInfoDao {

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}

	@Override
	public int querySoldTickets(int departureStationID, int arrivalStationID,
			int departureYear, int departureMonth, int departureDay) {
		// TODO Auto-generated method stub
		String sql1 = "SELECT stationFullName FROM stations WHERE sid=?";
		String departureStationName = template.queryForObject(sql1, String.class, departureStationID);
		String arrivalStationName = template.queryForObject(sql1, String.class, arrivalStationID);	
		
		Object[] params2 ={departureStationName, arrivalStationName, departureYear, departureMonth, departureDay};
		String sql2 = "SELECT SUM(totalQty) FROM ticket WHERE departureStationName=? AND arrivalStationName=?" +
						"AND departureYear=? AND departureMonth=? AND departureDay=?";
		int totalQty = template.queryForInt(sql2, params2);
		int avaiQty = queryAvaiTickets(departureStationID, arrivalStationID, departureYear, departureMonth, departureDay);
		return totalQty - avaiQty;
	}

	@Override
	public int queryAvaiTickets(int departureStationID, int arrivalStationID,
			int departureYear, int departureMonth, int departureDay) {
		// TODO Auto-generated method stub
		String sql1 = "SELECT stationFullName FROM stations WHERE sid=?";
		String departureStationName = template.queryForObject(sql1, String.class, departureStationID);
		String arrivalStationName = template.queryForObject(sql1, String.class, arrivalStationID);	
		
		Object[] params2 ={departureStationName, arrivalStationName, departureYear, departureMonth, departureDay};
		String sql2 = "SELECT SUM(avaiQty) FROM ticket WHERE departureStationName=? AND arrivalStationName=?" +
						"AND departureYear=? AND departureMonth=? AND departureDay=?";
		int avaiQty = template.queryForInt(sql2, params2);
		return avaiQty;
	}
	
	
}
