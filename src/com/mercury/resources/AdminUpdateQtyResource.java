package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.service.AdminUpdateQtyService;

@Path("/adminupdateqty")
public class AdminUpdateQtyResource {
	private AdminUpdateQtyService auqs;
	
	public AdminUpdateQtyResource(){
		if (auqs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			auqs = (AdminUpdateQtyService)actx.getBean("adminUpdateQtyService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public  void execute(
			@FormParam("ticketID") int ticketID,
			@FormParam("newtotalqty") int newtotalqty,
			@FormParam("newavailqty") int newavailqty
			) throws NoSuchAlgorithmException {
		auqs.updateTwoTypeQtyProcess(ticketID, newtotalqty, newavailqty);
		return;
	}	
}
