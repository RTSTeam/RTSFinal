package com.mercury.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.mercury.beans.Card;
import com.mercury.dao.CardDao;

public class CardDaoImpl implements CardDao{
	private SimpleJdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		template = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Card card) {
		// TODO Auto-generated method stub
		Object[] params = {card.getCardnumber(), card.getUserid(), card.getExpirationyear(), card.getExpirationmonth(), card.getHoldername(), card.getCsv()};
		//Object[] params= {"guang",  "12345",  "guang", "li", "DEC 11 2014", "guang@gmail.com", 1, "ROLE_USER"};
		String sql = "insert into card values(?,?,?,?,?,?)";
		template.update(sql, params);
	}

}
