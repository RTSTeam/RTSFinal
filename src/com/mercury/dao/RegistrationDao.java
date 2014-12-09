package com.mercury.dao;

import java.util.List;

import com.mercury.beans.RTSUser;

public interface RegistrationDao {
	public void save(RTSUser user);
	public RTSUser findByName(String userid);
	public List<String> queryAllUserID();
}
