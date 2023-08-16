package com.stage.eCommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class eCommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(eCommerceApplication.class, args);
}
}