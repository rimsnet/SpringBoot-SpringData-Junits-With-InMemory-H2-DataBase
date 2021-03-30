package com.rimsan.springboot.data.inmemory.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.rimsan.springboot.data.inmemory.repo" })
@ComponentScan(value = "com.rimsan.springboot.data.inmemory.*")
@EntityScan(basePackages = { "com.rimsan.springboot.data.inmemory.entities" })
@EnableSwagger2
public class JunitsInMemoryH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitsInMemoryH2DbApplication.class, args);
	}
	
	@Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.rimsan.springboot.data.inmemory.controller"))
                .build();
    }

}
