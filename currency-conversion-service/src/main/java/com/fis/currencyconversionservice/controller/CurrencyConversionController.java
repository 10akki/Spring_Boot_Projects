package com.fis.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fis.currencyconversionservice.bean.CurrencyConversion;
import com.fis.currencyconversionservice.proxy.CurrencyConversionServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionServiceProxy proxy;
	
	private Logger LOGGER =LoggerFactory.getLogger(CurrencyConversion.class);
	
	
	@GetMapping("currency-conversion/{from}/to/{to}/quantiy/{quantity}")
	public CurrencyConversion getConversion(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
				.getForEntity("http://localhost:8004/exchange/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion response = responseEntity.getBody();
		
		LOGGER.info("response ::"+ response);
		
		return new CurrencyConversion(1L, from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	
	@GetMapping("currency-conversion-feign-client/{from}/to/{to}/quantiy/{quantity}")
	public CurrencyConversion getFeignConversion(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		
		CurrencyConversion response = proxy.exchangeCurrency(from, to);

		return new CurrencyConversion(1L, from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
