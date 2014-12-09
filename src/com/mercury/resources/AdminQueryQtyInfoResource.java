package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TicketInfo;
import com.mercury.service.AdminQueryQtyInfoService;

@Path("/findallqty")
public class AdminQueryQtyInfoResource {
	private AdminQueryQtyInfoService aqqis;
	
	public AdminQueryQtyInfoResource(){
		if (aqqis==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			aqqis = (AdminQueryQtyInfoService)actx.getBean("adminQueryQtyInfoService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public  TicketInfo execute(
			) throws NoSuchAlgorithmException {
		
		return aqqis.queryQTYProcess();
	}		
}
