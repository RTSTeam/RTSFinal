package com.mercury.dao;

import java.util.List;
import com.mercury.beans.Transaction;

public interface TransactionDao {
	public boolean hasRecord();
	public List<Transaction> findOrdered(String userid);
	public void update(String tranID);
	public void save(Transaction transaction, boolean hasRecord);
	public List<Transaction> queryTransactions(String userid);
	public List<Transaction> queryRefundingTransactions();
	public void updateTypeToRefunded(int tranID, int ticketID, int qty);
}
