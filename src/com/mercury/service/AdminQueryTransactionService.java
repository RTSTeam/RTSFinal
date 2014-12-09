package com.mercury.service;

import com.mercury.beans.TransactionInfo;
import com.mercury.dao.TransactionDao;

public class AdminQueryTransactionService {
	private TransactionDao td;

	public TransactionDao getTd() {
		return td;
	}

	public void setTd(TransactionDao td) {
		this.td = td;
	}
	
	public TransactionInfo queryRefundingProcess() {
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setTransactions(td.queryRefundingTransactions());
		return transactionInfo;
	}
}
