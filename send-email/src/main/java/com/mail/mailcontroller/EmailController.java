package com.mail.mailcontroller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.sendservice.EmailSendService;
@RequestMapping("/sendMailService")
@RestController
public class EmailController {
	@Autowired
	private EmailSendService emailSendService;
	
	@GetMapping(value="/sendMailAttachement")
    public String sendMailAttachment()  {
		String response="";
       try{
    	   response=emailSendService.sendMail();
            
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        return response;
    }
	
}
