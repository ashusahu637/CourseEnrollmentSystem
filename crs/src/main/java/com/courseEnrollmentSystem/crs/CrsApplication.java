package com.courseEnrollmentSystem.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.courseEnrollmentSystem.crs.classes")
@EnableJpaRepositories(basePackages = "com.courseEnrollmentSystem.crs.repositories")
public class CrsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CrsApplication.class, args);
		
		
	}

}
