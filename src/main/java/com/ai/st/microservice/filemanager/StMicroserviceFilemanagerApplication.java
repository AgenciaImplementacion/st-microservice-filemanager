package com.ai.st.microservice.filemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.ai.st.microservice.filemanager.entity"})
public class StMicroserviceFilemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StMicroserviceFilemanagerApplication.class, args);
	}

}
