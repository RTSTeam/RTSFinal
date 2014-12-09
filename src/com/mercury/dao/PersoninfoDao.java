package com.mercury.dao;
import java.util.List;

import com.mercury.beans.RTSUser;


public interface PersoninfoDao {
	public List<RTSUser> queryPersoninfo(String userid);
}
