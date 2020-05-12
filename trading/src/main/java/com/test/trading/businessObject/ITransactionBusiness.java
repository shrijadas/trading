package com.test.trading.businessObject;

import com.test.trading.exception.ImproperVersionIDException;
import com.test.trading.exception.InvalidDateException;
import com.test.trading.model.Transaction;


public interface ITransactionBusiness {
	
	public  Long validateVersionID(Transaction transaction) throws ImproperVersionIDException;
	
	
	public  boolean validateMaturity(Transaction transaction) throws InvalidDateException;


}
