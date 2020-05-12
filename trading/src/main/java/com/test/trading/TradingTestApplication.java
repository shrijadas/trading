package com.test.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TradingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingTestApplication.class, args);
	}
}
