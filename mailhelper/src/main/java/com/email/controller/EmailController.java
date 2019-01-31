package com.email.controller;


import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	@Autowired
    EmailService emailService;
	
	@GetMapping(value= "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException
	{
	    emailService.sendEmail();	
		return "Email Sent Successfully";
	}

}
