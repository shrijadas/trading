package com.test.trading;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.trading.configuration.WebConfiguration;
import com.test.trading.exception.ImproperVersionIDException;
import com.test.trading.exception.InvalidDateException;
import com.test.trading.exception.ResourceNotFoundException;
import com.test.trading.TradingTestApplication;
import com.test.trading.businessObject.ITransactionBusiness;
import com.test.trading.businessObject.TransactionBusinessImplementation;
import com.test.trading.configuration.WebConfiguration;
import com.test.trading.model.Transaction;
import com.test.trading.repository.TransactionRepository;
import com.test.trading.service.TransactionService;



@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)

@SpringBootTest
@ComponentScan
@DataJpaTest
public class TradingTestApplicationJunit {
	  @Autowired 
	  private TransactionService transactionService;
	  
	  @Autowired 
	  private ITransactionBusiness transactionBusinessImplementation =
	  new TransactionBusinessImplementation();
		 
	  @Autowired private TransactionRepository tranMockRepository;
	 
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(transactionService);
	    MockitoAnnotations.initMocks(tranMockRepository);
	 }
  
	  //@Test 
	  public void testValidateVersionID() throws
	  ResourceNotFoundException,Exception {
	  
	  Transaction trade1 = new Transaction(); 
	  trade1.setTradeID("T5");
	  trade1.setVersionID(2); 
	  trade1.setMaturityDT("15-05-20");
	  trade1.setBookID("B1"); 
	  trade1.setCounter_PartyID("CP-1"); 
	  // Transaction  object with same TradeId but lower version 
	  Transaction trade2 = new Transaction(); 
	  trade2.setTradeID("T5"); 
	  trade2.setVersionID(1);
	  trade2.setMaturityDT("15-05-20"); trade2.setBookID("B1");
	  trade2.setCounter_PartyID("CP-1");
	  Transaction tradeEntity = tranMockRepository.save(trade1);
	  assertThrows(ImproperVersionIDException.class, () -> transactionBusinessImplementation.validateVersionID(trade2));
	  }
		
	 // @Test 
	  public void testValidMaturityDT() throws InvalidDateException,Exception
	  { 
      Transaction trade = new Transaction(); 
	  trade.setTradeID("T1"); 
	  trade.setVersionID(1);
	  trade.setMaturityDT("16-05-20");
	  trade.setBookID("B1");
	  trade.setCounter_PartyID("CP-1");
	  boolean expected = true;
	  boolean actual = transactionBusinessImplementation.validateMaturity(trade);
	  assertEquals(expected, actual);
	  }
	 
}
