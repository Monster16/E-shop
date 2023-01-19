package com.shoppingcartsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication

public class ApiGatewayEShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayEShopApplication.class, args);
	}

}
