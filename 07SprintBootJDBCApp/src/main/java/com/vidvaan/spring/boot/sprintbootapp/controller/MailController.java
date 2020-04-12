package com.vidvaan.spring.boot.sprintbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping(value = "/sendemail")
	public String SendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("amarlapudichandrakanth@gmail.com");
		message.setSubject("TestMail");
		message.setText("Test Mail From Java");
		mailSender.send(message);
		return "successfull sent email";
	}
}
