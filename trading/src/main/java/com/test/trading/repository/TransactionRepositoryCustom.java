package com.test.trading.repository;

import java.util.List;
import java.util.Optional;

import com.test.trading.model.Transaction;

public interface TransactionRepositoryCustom {
	
	
	 public Optional<Transaction> getPrevVersionID(Transaction transaction) ;
	 
}
