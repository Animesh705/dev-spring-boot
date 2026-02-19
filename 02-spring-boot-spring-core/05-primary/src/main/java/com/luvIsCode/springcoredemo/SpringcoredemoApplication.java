package com.luvIsCode.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication
		//add a package for component scanning explicitely
		(scanBasePackages = {"com.luvIsCode.springcoredemo","com.luvIsCode.util"})
*/
@SpringBootApplication
class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
