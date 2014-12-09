package com.mercury.service;

import com.mercury.beans.TransactionInfo;
import com.mercury.dao.TransactionDao;

public class QueryOrderedService {
	private TransactionDao td;

	public TransactionDao getTd() {
		return td;
	}

	public void setTd(TransactionDao td) {
		this.td = td;
	}
	
	public TransactionInfo process(String userid) {
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setTransactions(td.findOrdered(userid));
		return transactionInfo;
	}
	
	
}
