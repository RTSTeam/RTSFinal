package com.mercury.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.User;
import com.mercury.beans.UserInfo;
import com.mercury.service.HelloService;

@Path("/hello")
public class HelloResource {
	private HelloService hs;
	
	public HelloResource() {
		if (hs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			hs = (HelloService)actx.getBean("helloService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public UserInfo execute(
			@FormParam("name") String name,
			@FormParam("age") int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return hs.process(user);
	}
}
