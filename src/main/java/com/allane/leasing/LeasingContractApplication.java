package com.allane.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LeasingContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeasingContractApplication.class, args);
	}

}
