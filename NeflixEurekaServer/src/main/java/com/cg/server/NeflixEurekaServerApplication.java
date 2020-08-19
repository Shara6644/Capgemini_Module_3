package com.cg.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class NeflixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeflixEurekaServerApplication.class, args);
	}

}
