package com.mercury.resources;

import java.security.NoSuchAlgorithmException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.beans.Card;
import com.mercury.service.CardService;


@Path("/card")
public class CardResource {
	private CardService cs;
	
	public CardResource() {
		if (cs==null) {
			ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
			cs = (CardService)actx.getBean("cardService");
		}
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void execute(
			@FormParam("cardnumber") int cardnumber,
			@FormParam("userid") String userid,
			@FormParam("expirationyear") int expirationyear,
			@FormParam("expirationmonth") int expirationmonth,
			@FormParam("holdername") String holdername,
			@FormParam("csv") int csv) throws NoSuchAlgorithmException {
		Card card = new Card();
		System.out.println(cardnumber);
		card.setCardnumber(cardnumber);
		card.setUserid(userid);
		card.setExpirationyear(expirationyear);
		card.setExpirationmonth(expirationmonth);
		card.setHoldername(holdername);
		card.setCsv(csv);
		cs.process(card);
	}
	
}
