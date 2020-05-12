package com.test.trading.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.trading.businessObject.TransactionBusinessImplementation;

@Configuration
public class WebConfiguration {

	 
	    @Bean
	    public TransactionBusinessImplementation transactionBusinessImplementation() {

	        return new TransactionBusinessImplementation();

	    }
}
