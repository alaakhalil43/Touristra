package com.Touristra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Touristra.repositories")
@EntityScan(basePackages = "com.Touristra.model")
@ComponentScan(basePackages = "com.Touristra")
public class TouristraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TouristraApplication.class, args);
	}

}
