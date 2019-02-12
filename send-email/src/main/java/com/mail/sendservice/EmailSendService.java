package com.mail.sendservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	
	@Autowired
    private JavaMailSender sender;
	
	public String sendMail() throws MessagingException{
		MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setTo("demo@gmail.com");
            helper.setText("Greetings :)\n Please find the attached docuemnt for your reference.");
            helper.setSubject("Mail From Spring Boot");
            ClassPathResource file = new ClassPathResource("document.PNG");
            helper.addAttachment("document.PNG", file);
            sender.send(message);
            return "Mail Sent Success!";
	}

}
