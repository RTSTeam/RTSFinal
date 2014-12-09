package com.mercury.dao;

import java.util.List;

import com.mercury.beans.Station;

public interface StationDao {
	public void save(Station station);
	public void save(Station station,  boolean hasRecord);
	public void delete(Station station);
	public List<Station> queryAll();
	public boolean hasRecord();
}
