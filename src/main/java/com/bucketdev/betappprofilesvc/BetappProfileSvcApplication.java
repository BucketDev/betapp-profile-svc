package com.bucketdev.betappprofilesvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BetappProfileSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetappProfileSvcApplication.class, args);
	}

}
