package com.test.trading.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.trading.businessObject.ITransactionBusiness;
import com.test.trading.businessObject.TransactionBusinessImplementation;
import com.test.trading.exception.ImproperVersionIDException;
import com.test.trading.exception.InvalidDateException;
import com.test.trading.exception.ResourceNotFoundException;
import com.test.trading.model.Transaction;
import com.test.trading.repository.TransactionRepository;
import com.test.trading.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
	
	@Autowired
	private TransactionService tranService;
	
	@PostMapping("/createTrade")
	public ResponseEntity<Transaction> createTrade(@Valid @RequestBody Transaction trade) {
		
		Transaction tradeEntity = tranService.createTrade(trade);
		
		return new ResponseEntity<Transaction>(tradeEntity, HttpStatus.OK);

	}

}
