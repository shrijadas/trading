package com.test.trading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.trading.businessObject.ITransactionBusiness;
import com.test.trading.exception.ImproperVersionIDException;
import com.test.trading.exception.InvalidDateException;
import com.test.trading.exception.ResourceNotFoundException;
import com.test.trading.model.Transaction;
import com.test.trading.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private ITransactionBusiness transactionBusinessImplementation;
	@Autowired
	private TransactionRepository tranRepository;
	
	
	public Transaction createTrade(Transaction trade) {
		 Long tradeID;
		 Transaction tradeEntity=null;
		try {
		transactionBusinessImplementation.validateMaturity(trade);
		tradeID = transactionBusinessImplementation.validateVersionID(trade);
		if(tradeID!=1L) {
			try {
				// update
				tradeEntity = tranRepository.save(updateTrade(tradeID,trade));
				
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
		}else {	
			//save
		 tradeEntity =	tranRepository.save(trade);
		}
	    }
		 catch (InvalidDateException | ImproperVersionIDException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	 } 
	return tradeEntity;
	}
	

	public Transaction updateTrade(
			Long tradeID,Transaction trade)throws ResourceNotFoundException {
		  Transaction trn = tranRepository.findById(tradeID)
		 .orElseThrow(() -> new ResourceNotFoundException("Trade not found :: " + tradeID));
		  trn.setTradeID(trade.getTradeID());
		  trn.setVersionID(trade.getVersionID());
		  trn.setBookID(trade.getBookID());
		  trn.setCounter_PartyID(trade.getCounter_PartyID());
		  //trn.setCreatedDT(trade.getCreatedDT());
		  trn.setExpired(false);
		  //trn.setMaturityDT(trade.getMaturityDT());
		  return trn;  
	}
	
	
	public Transaction getTrade(
			Long tradeID)throws ResourceNotFoundException {
		  Transaction trn = tranRepository.findById(tradeID)
		 .orElseThrow(() -> new ResourceNotFoundException("Trade not found :: " + tradeID));
		  return trn;  
	}

}
