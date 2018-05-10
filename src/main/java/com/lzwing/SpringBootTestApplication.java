package com.lzwing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableMQConfiguration
@EnableConfigurationProperties
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}
