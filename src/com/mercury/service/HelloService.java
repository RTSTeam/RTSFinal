package com.mercury.service;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.dao.HelloDao;

public class HelloService {
	private HelloDao hd;
	
	public HelloDao getHd() {
		return hd;
	}
	public void setHd(HelloDao hd) {
		this.hd = hd;
	}
	public String sayHello1(User user) {
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h2><font color=blue>");
		sb.append("Hello " + user.getName() + " with age " + 
				user.getAge() + ", welcome to JavaEE!");
		sb.append("</font></h2>");
		sb.append("</body></html>");
		return sb.toString();
	}
	public String sayHello2(User user) {
		return "Hello " + user.getName() + "(" + user.getAge() 
				+ "), welcome to JavaEE!";
	}
	
	public UserInfo process(User user) {
		hd.save(user);
		UserInfo userInfo = new UserInfo();
		userInfo.setMsg(this.sayHello2(user));
		userInfo.setUsers(hd.queryAll());
		return userInfo;
	}
}
