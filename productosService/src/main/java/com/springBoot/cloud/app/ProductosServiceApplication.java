package com.springBoot.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
@SpringBootApplication
public class ProductosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosServiceApplication.class, args);
	}

}
