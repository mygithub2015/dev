package com.mail.sendemail;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.mail.mailcontroller", "com.mail.sendmail", "com.mail.sendservice" })
public class SendEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);

		
		}

	}


