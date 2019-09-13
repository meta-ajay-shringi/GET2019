package com.metacube.EADsession7.service;

import org.springframework.stereotype.Component;

/**
 * SmtpMailSender implement class MailSender
 */
@Component 
public class SmtpMailSender implements MailSender {

	@Override
	public String sendmail() {
		
		return " this is smtp mail";
		
	}

}
