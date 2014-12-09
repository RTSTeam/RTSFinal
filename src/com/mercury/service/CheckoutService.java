package com.mercury.service;

import com.mercury.beans.Transaction;
import com.mercury.dao.TransactionDao;

public class CheckoutService {
	private TransactionDao td;

	public TransactionDao getTd() {
		return td;
	}

	public void setTd(TransactionDao td) {
		this.td = td;
	}
	
	public void processCheckout(Transaction transaction) {
		boolean hasRecord = td.hasRecord();
		td.save(transaction, hasRecord);
		
	}
}
