package com.mercury.service;

import java.util.List;

import com.mercury.beans.Card;
import com.mercury.beans.CardInfo;
import com.mercury.beans.User;
import com.mercury.dao.CardDao;
import com.mercury.utils.SendJavaMail;

public class CardService {
	private CardDao cd;
	
	
	public CardDao getCd() {
		return cd;
	}
	public void setCd(CardDao cd) {
		this.cd = cd;
	}

	
	public void process(Card card) {
		cd.save(card);
		System.out.println(card.getUserid());
//		System.out.println("arrivalStationID: " + arrivalStationID);
//		System.out.println("departureYear: " + departureYear);
//		System.out.println("departureMonth: " + departureMonth);
//		System.out.println("departureDay: " + departureDay);

	}
	

}
