package com.fis.LimitService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.LimitService.bean.Configuration;
import com.fis.LimitService.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitServiceController {
	
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/getLimit")
	public LimitsConfiguration getLimits() {
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	
	
	  @GetMapping("/fault-limit")
	  
	  @HystrixCommand(fallbackMethod = "handleFault") public LimitsConfiguration
	  getFalult() { throw new RuntimeException("runtime exception"); }
	  
	  public LimitsConfiguration handleFault() { return new
	  LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	  }
	 
}
