package com.mailhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.email.controller", "com.mailhelper"})
public class MailhelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailhelperApplication.class, args);
	}

}

