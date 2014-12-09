package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.TransactionInfo;
import com.mercury.service.AdminQueryTransactionService;

@Path("/adminqueryrefund")
public class AdminQueryTransactionResource {
	
	private AdminQueryTransactionService atrs;
	
	public AdminQueryTransactionResource(){
		if (atrs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			atrs = (AdminQueryTransactionService)actx.getBean("adminQueryTransactionService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public TransactionInfo execute(
			) throws NoSuchAlgorithmException {
		
		return atrs.queryRefundingProcess();
	}
}
