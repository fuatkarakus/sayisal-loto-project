package com.sayisal.loto.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

	public static final Logger LOGGER= LoggerFactory.getLogger(LotoService.class);
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Override
	public void sendLotoSonucMail(ArrayList<SimpleMailMessage> messageList) {
		try {
			for(SimpleMailMessage message : messageList) {
				emailSender.send(message);
			}
		}catch(MailSendException e) {
			LOGGER.error("Email gonderilirken hata olustu: " + e);
		}
	}

	@Override
	public ArrayList<SimpleMailMessage> getMailMessage(ArrayList<String> toList, String subject, String text) throws Exception {
		ArrayList<SimpleMailMessage> mailList = new ArrayList<>();
		for(String to : toList) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
		}
		return mailList;
	}
	

}
