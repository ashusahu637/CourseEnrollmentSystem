package com.courseEnrollmentSystem.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages = "com.courseEnrollmentSystem.crs.classes")
public class CrsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CrsApplication.class, args);
		
		
	}

}
