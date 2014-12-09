package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.service.RefundService;



@Path("/userrefund")
public class RefundResource {
	private RefundService rs;
	
	public RefundResource(){
		if (rs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			rs = (RefundService)actx.getBean("RefundService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void execute(
			@FormParam("tranID") String tranID
			) throws NoSuchAlgorithmException {
		
		rs.processRefund(tranID);

	}
}
