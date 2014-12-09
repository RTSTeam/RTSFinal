package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.service.UpdateQtyService;

@Path("/updateQty")
public class UpdateQtyResource {
	private UpdateQtyService uqs;
	
	public UpdateQtyResource() {
		if (uqs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			uqs = (UpdateQtyService)actx.getBean("UpdateQtyService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void execute(
			@FormParam("ticketid") int ticketid,
			@FormParam("qty") int qty) throws NoSuchAlgorithmException {
		uqs.process(ticketid, qty);
	}
}
