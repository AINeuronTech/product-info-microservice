package com.commerce.productinfoservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductInfoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInfoServicesApplication.class, args);
	}

}
