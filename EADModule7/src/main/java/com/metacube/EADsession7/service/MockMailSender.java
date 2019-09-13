package com.metacube.EADsession7.service;

import org.springframework.stereotype.Component;

/**
 * MockMailSender implement class MailSender
 *
 */
@Component
public class MockMailSender implements MailSender {

	@Override
	public String sendmail() {
		
		return "This is mock mail";
		
	}

}
