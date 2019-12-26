package com.fis.netflixnamingeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NetflixNamingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixNamingEurekaServerApplication.class, args);
	}

}
