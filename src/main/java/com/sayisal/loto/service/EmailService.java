package com.sayisal.loto.service;

import java.util.ArrayList;

import javax.mail.SendFailedException;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	public void sendLotoSonucMail(ArrayList<SimpleMailMessage> message )throws SendFailedException ;
	
	public ArrayList<SimpleMailMessage> getMailMessage(ArrayList<String> to, String subject, String text)throws Exception ;
	
}
