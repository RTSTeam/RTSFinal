package com.mercury.service;

import com.mercury.beans.TransactionInfo;
import com.mercury.dao.TransactionDao;

public class TransactionService {
	private TransactionDao td;

	public TransactionDao getTd() {
		return td;
	}

	public void setTd(TransactionDao td) {
		this.td = td;
	}
	
	public TransactionInfo process(String userid) {
		//td.save(rtsuser);
		//RTSUserInfo rtsuserInfo = new RTSUserInfo();
		//rtsuserInfo.setMsg(this.sayHello2(rtsuser));
		//rtsuserInfo.setRtsusers(rd.queryAll());
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setTransactions(td.queryTransactions(userid));
		return transactionInfo;
	}
	
	
}
