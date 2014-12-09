package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.mercury.beans.RTSUser;
import com.mercury.dao.PersoninfoDao;


public class PersoninfoDaoImpl implements PersoninfoDao {

	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public List<RTSUser> queryPersoninfo(String userID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM rtsusers where userid=?";
		Object[] params = {userID};
		
		return template.query(sql, new RowMapper<RTSUser>() {
			@Override
			public RTSUser mapRow(ResultSet rs, int line) throws SQLException {
				// TODO Auto-generated method stub
				RTSUser personinfo = new RTSUser();
				personinfo.setUserID(rs.getString("userID"));
				personinfo.setFname(rs.getString("fname"));
				personinfo.setLname(rs.getString("lname"));
				personinfo.setBirthday(rs.getString("birthday"));
				personinfo.setEmail(rs.getString("email"));
				return personinfo;
			}			
		}, params);
	}

}
