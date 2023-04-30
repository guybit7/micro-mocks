package com.msi.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
@ComponentScan({"com.msi.developer.controller", "com.msi.developer.service"})
@EntityScan("com.msi.developer.entity")
@EnableJpaRepositories("com.msi.developer.repository")
public class DeveloperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeveloperServiceApplication.class, args);
	}
}
