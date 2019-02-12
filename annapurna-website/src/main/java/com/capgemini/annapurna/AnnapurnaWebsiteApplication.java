package com.capgemini.annapurna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.client.RestTemplate;
@EnableDiscoveryClient
@SpringBootApplication
@EnableWebSecurity
public class AnnapurnaWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnapurnaWebsiteApplication.class, args);
	}
	
	@Bean
	public RestTemplate passData() {
		return new RestTemplate();
	}

}

