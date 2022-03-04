package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Topic72aApplication {

	public static void main(String[] args) {
		SpringApplication.run(Topic72aApplication.class, args);
	}

}
