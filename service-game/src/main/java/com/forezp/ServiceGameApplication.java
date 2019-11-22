package com.forezp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan("com.controller")
@MapperScan("com.dao")
public class ServiceGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGameApplication.class, args);
	}


}
