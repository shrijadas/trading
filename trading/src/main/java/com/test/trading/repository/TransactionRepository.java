package com.test.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.trading.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	
}
