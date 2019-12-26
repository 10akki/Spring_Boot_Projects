package com.fis.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fis.currencyexchangeservice.bean.CurrencyExchange;
import com.fis.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	
	private Logger LOGGER =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment env;
	
	@Autowired 
	CurrencyExchangeRepository repository;
	
	@GetMapping("/exchange/{from}/to/{to}")
	public CurrencyExchange exchangeCurrency(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		CurrencyExchange currencyExchange= repository.findByFromAndTo(from, to);	
		currencyExchange.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		LOGGER.info("{}",currencyExchange);
		
		return currencyExchange;
	}
}
