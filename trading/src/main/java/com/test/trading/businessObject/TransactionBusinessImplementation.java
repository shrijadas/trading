package com.test.trading.businessObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.trading.businessObject.ITransactionBusiness;
import com.test.trading.exception.ImproperVersionIDException;
import com.test.trading.exception.InvalidDateException;
import com.test.trading.model.Transaction;
import com.test.trading.repository.TransactionRepository;
import com.test.trading.repository.TransactionRepositoryCustom;


public class TransactionBusinessImplementation implements ITransactionBusiness {
	
	@Autowired
	private TransactionRepositoryCustom trnCustomRepository;
	
	public  Long validateVersionID(Transaction transaction) throws ImproperVersionIDException{
		Long uniqueTradeID=1L ;
		int prevVersionID;
		
		if( trnCustomRepository.getPrevVersionID(transaction)!=null){
			prevVersionID = trnCustomRepository.getPrevVersionID(transaction).get().getVersionID();
			if(prevVersionID > transaction.getVersionID()) {
				throw new ImproperVersionIDException("Can't accept lower version");
			
			}else {
				uniqueTradeID = trnCustomRepository.getPrevVersionID(transaction).get().getId();
			}
			
		}
		return uniqueTradeID;
		
	}
	
    public  boolean validateMaturity(Transaction transaction) throws InvalidDateException {
    	boolean dateValidity=false;
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate maturityDT = LocalDate.parse(transaction.getMaturityDT(),formatter);
		LocalDate toDT = LocalDate.now();
		if(maturityDT.compareTo(toDT)>0) {
			dateValidity=true;
		}else {	
		throw new InvalidDateException("wrong maturity date");
		}
		return dateValidity;
	}
    
}
