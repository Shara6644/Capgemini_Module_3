package com.cg.oepms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class OnlineECommerceProductManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineECommerceProductManagementSystemApplication.class, args);
	}

}
