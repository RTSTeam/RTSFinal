package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.mercury.beans.Ticket;
import com.mercury.dao.TicketDao;

public class TicketDaoImpl implements TicketDao{
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Ticket ticket) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void save(Ticket ticket, boolean hasRecord) {
		Object[] params = {ticket.getDepartureStationName(), ticket.getArrivalStationName(),
					       ticket.getDepartureYear(), ticket.getDepartureMonth(), ticket.getDepartureDay(), ticket.getDepartureHour(), ticket.getDepartureMinute(), 
						   ticket.getArrivalYear(), ticket.getArrivalMonth(), ticket.getArrivalDay(), ticket.getArrivalHour(), ticket.getArrivalMinute(),
						   ticket.getPrice(), ticket.getTotalQty(), ticket.getAvaiQty()};
		String sql =null;
		if(hasRecord){
		 sql= "insert into ticket values((select Max(tickid)+1 from ticket),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		else{
			sql= "insert into ticket values(1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		template.update(sql, params);
	}
	
	@Override
	public void delete(Ticket ticket) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<Ticket> queryTickets(String departureStationName, String arrivalStationName, 
			int departureYear, int departureMonth, int departureDay, int departureHour,
			int neededQty) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ticket WHERE departureStationName=? AND arrivalStationName=?" +
						"AND departureYear=? AND departureMonth=? AND departureDay=? AND departureHour>=? AND avaiQty>=? order by departureHour";
		Object[] params = {departureStationName, arrivalStationName, departureYear, departureMonth, departureDay,
							departureHour, neededQty};	
		return template.query(sql, new RowMapper<Ticket>() {
			@Override
			public Ticket mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				Ticket ticket = new Ticket();
				ticket.setTicketID(rs.getInt("tickid"));
				ticket.setDepartureStationName(rs.getString("departureStationName"));
				ticket.setArrivalStationName(rs.getString("arrivalStationName"));
				ticket.setDepartureYear(rs.getInt("departureYear"));
				ticket.setDepartureMonth(rs.getInt("departureMonth"));
				ticket.setDepartureDay(rs.getInt("departureDay"));
				ticket.setDepartureHour(rs.getInt("departureHour"));
				ticket.setDepartureMinute(rs.getInt("departureMinute"));
				ticket.setArrivalYear(rs.getInt("arrivalYear"));
				ticket.setArrivalMonth(rs.getInt("arrivalMonth"));
				ticket.setArrivalDay(rs.getInt("arrivalDay"));
				ticket.setArrivalHour(rs.getInt("arrivalHour"));
				ticket.setArrivalMinute(rs.getInt("arrivalMinute"));
				ticket.setPrice(rs.getInt("price"));
				ticket.setTotalQty(rs.getInt("totalQty"));
				ticket.setAvaiQty(rs.getInt("avaiQty"));
				return ticket;
			}			
		}, params);
	}

	@Override
	public void updateQty(int ticketid, int qty) {
		// TODO Auto-generated method stub
		Object[] params = {qty, ticketid};
		String sql = "update ticket set avaiQty = avaiQty-? where tickid = ?";
		template.update(sql, params);
	}
	
	public List<Ticket> queryAllTickets(){
		String sql = "SELECT * FROM ticket";
		Object[] params = {};	
		return template.query(sql, new RowMapper<Ticket>() {
			@Override
			public Ticket mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				Ticket ticket = new Ticket();
				ticket.setTicketID(rs.getInt("tickid"));
				ticket.setTotalQty(rs.getInt("totalQty"));
				ticket.setAvaiQty(rs.getInt("avaiQty"));
				return ticket;
			}			
		}, params);
	}
	
	@Override
	public void adminUpdateTwoTypeQty(int ticketID, int newtotalqty, int newavailqty){
		Object[] params = {newtotalqty, newavailqty, ticketID};
		String sql = "update ticket set totalqty =?, avaiqty =? where tickid =?";
		template.update(sql, params);
	}
	
	@Override
	public boolean hasRecord() {
		Object[] params ={};
		String sql = "select count(*) from ticket";
		
		return !(0==template.queryForInt(sql, params));
	}

}
