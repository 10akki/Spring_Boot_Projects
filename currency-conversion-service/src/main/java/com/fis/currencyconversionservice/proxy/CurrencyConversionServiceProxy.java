package com.fis.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fis.currencyconversionservice.bean.CurrencyConversion;


//@FeignClient(name = "currency-exchange-service",url="localhost:8002") //to call exchange service using particular instance
//@FeignClient(name = "currency-exchange-service") //use feign client to call currency exchange service using ribbon client
@FeignClient(name = "netflix-zuul-api-gateway") //use zuul gateway to call currency exchange service using feign client
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionServiceProxy {

	//@GetMapping("/exchange/{from}/to/{to}") // when using only feign client to call exchange service
	@GetMapping("/currency-exchange-service/exchange/{from}/to/{to}") //when using zuul gateway to call exchange service
	public CurrencyConversion exchangeCurrency(@PathVariable("from") String from,
			@PathVariable("to") String to);
}
