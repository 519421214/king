package com.king.hhczy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HhczyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhczyApplication.class, args);
	}

}
