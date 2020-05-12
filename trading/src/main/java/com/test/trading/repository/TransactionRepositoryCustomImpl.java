package com.test.trading.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.trading.model.Transaction;
import com.test.trading.repository.TransactionRepositoryCustom;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import javax.persistence.Query;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class TransactionRepositoryCustomImpl implements   TransactionRepositoryCustom{
    @PersistenceContext

    EntityManager entityManager;

    @Override

    public Optional<Transaction> getPrevVersionID(Transaction transaction) {
    	Optional<Transaction> trans = null;
        Query query = entityManager.createQuery
        		(" FROM Transaction as trn where trn.tradeID = ?1",Transaction.class);
        query.setParameter(1, transaction.getTradeID()); 
        int rowNum = query.getResultList().size();
        if(rowNum>0) {
        	
        	List<Transaction> transactionList = query.getResultList();
        	 trans = Optional.of(transactionList.get(0));
        }

		return trans;

    }
	
	

}
