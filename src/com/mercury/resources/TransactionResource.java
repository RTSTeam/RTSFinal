package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TransactionInfo;
import com.mercury.service.TransactionService;


@Path("/usertransaction")
public class TransactionResource {
	private TransactionService ts;
	
	public TransactionResource(){
		if (ts==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			ts = (TransactionService)actx.getBean("transactionService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public TransactionInfo execute(
			@FormParam("userid") String userid
			) throws NoSuchAlgorithmException {
		
		return ts.process(userid);
	}
}
