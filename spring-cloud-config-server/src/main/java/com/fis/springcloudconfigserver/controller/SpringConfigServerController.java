package com.fis.springcloudconfigserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringConfigServerController {
	
	@GetMapping("/getConfigServer")
	public String getConfig() {
		return "Spring config server launched";
	}
}