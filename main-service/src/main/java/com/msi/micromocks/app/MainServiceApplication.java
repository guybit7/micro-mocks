package com.msi.micromocks.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.msi.micromocks.controller", "com.msi.micromocks.service", "com.msi.micromocks.infra.encapsulate"})
@EntityScan("com.msi.micromocks.entity")
@EnableJpaRepositories("com.msi.micromocks.repository")
@EnableFeignClients("com.msi.micromocks.feignclients")
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@EnableSwagger2
public class MainServiceApplication {

	
	@Value("${developer.service.url}")
	private String developerServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
	}

	
	@Bean
	public WebClient webClient () {
		WebClient webClient = WebClient.builder()
				.baseUrl(developerServiceUrl).build();
		
		return webClient;
	}
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
