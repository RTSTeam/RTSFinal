package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.service.AdminRefundService;

@Path("/admindorefund")
public class AdminRefundResource {
	private AdminRefundService ars;
	
	public AdminRefundResource(){
		if (ars==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			ars = (AdminRefundService)actx.getBean("adminRefundService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void execute(
			@FormParam("tranID") int tranID,
			@FormParam("ticketID") int ticketID,
			@FormParam("qty") int qty
			) throws NoSuchAlgorithmException {
		ars.processRefund(tranID, ticketID, qty);
	}
}
