package com.vilaruel.rafael.iaycha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class IaychaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IaychaSpringApplication.class, args);	
	}

	
}
