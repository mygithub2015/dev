package com.notice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ApartmentNoticeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartmentNoticeServiceApplication.class, args);
	}

}
