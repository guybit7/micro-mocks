package com.msi.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.msi.developer.controller", "com.msi.developer.service", "com.msi.developer.config"})
@EntityScan({"com.msi.developer.entity", "com.msi.developer.model"})
@EnableJpaRepositories("com.msi.developer.repository")
@EnableMongoRepositories
public class DeveloperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperServiceApplication.class, args);
	}
}
