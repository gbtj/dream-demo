package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.api.dao")
public class DreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamDemoApplication.class, args);
	}

}
