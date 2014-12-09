package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.mercury.beans.RTSUser;
import com.mercury.dao.RegistrationDao;

public class RegistrationDaoImpl implements RegistrationDao{
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void save(RTSUser rtsuser) {
		// TODO Auto-generated method stub
		Object[] params = {rtsuser.getUserID(), rtsuser.getPassword(), rtsuser.getFname(), rtsuser.getLname(), rtsuser.getBirthday(), rtsuser.getEmail(), rtsuser.getStatus()
		,rtsuser.getAuthority()};
		//Object[] params= {"guang",  "12345",  "guang", "li", "DEC 11 2014", "guang@gmail.com", 1, "ROLE_USER"};
		String sql = "insert into RTSUsers values(?,?,?,?,?,?,?,?)";
		template.update(sql, params);
	}
	@Override
	public RTSUser findByName(String userid) {

		String sql = "select * from rtsusers where userid=?";
		Object[] params = {userid};
		return template.queryForObject(sql, new RowMapper<RTSUser>() {
			@Override
			public RTSUser mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				RTSUser user = new RTSUser();
				user.setUserID(rs.getString("userid"));
				return user;
			}		
		}, params);
	}
	
	@Override
	public List<String> queryAllUserID(){
		String sql = "select userid from rtsusers";
		Object[] params = {};

		return template.query(sql, new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				//RTSUser rtsuser = new RTSUser();
				//rtsuser.setUserID(rs.getString("userid"));
				String userid = rs.getString("userid");
				//System.out.println(userid);
				return userid;
			}		
		}, params);
		
	}
}
