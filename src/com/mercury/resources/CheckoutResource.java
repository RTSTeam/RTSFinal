package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.Transaction;
import com.mercury.service.CheckoutService;

@Path("/checkout")
public class CheckoutResource {
	private CheckoutService cs;
	
	public CheckoutResource() {
		if (cs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			cs = (CheckoutService)actx.getBean("CheckoutService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void execute(
			@FormParam("userid") String userid,
			@FormParam("ticketid") int ticketid,
			@FormParam("price") int price,
			@FormParam("qty") int qty) throws NoSuchAlgorithmException {
		Transaction transaction = new Transaction();
		transaction.setUserID(userid);
		transaction.setTicketID(ticketid);
		transaction.setPrice(price);
		transaction.setQty(qty);
		transaction.setTranType("Ordered");
		cs.processCheckout(transaction);
	}
}
