package com.metacube.EADsession7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.EADsession7.service.MailSender;

/**
 * Controller class
 *
 */
@Controller
public class MailController {
	
	MailSender mail;
	
	/**
	 * constructor for MailController 
	 * @param mail the MailSender reference
	 */
	/*
	public MailController(MailSender mail) {
		this.mail = mail;
		mail.sendmail();
	}
	*/
	
	/**
	 * Get mailSender reference
	 * @return
	 */
	public MailSender getMail() {
		return mail;
	}

	/**
	 * set mailSender reference
	 * @param smtpMail
	 */
	//@Qualifier("smtpMail")
	@Autowired
	public void setMail(MailSender smtpMail) {
		this.mail = smtpMail;
	}
	
	/**
	 * @return SMTP mail message to browser
	 */
	@GetMapping("/sendMail")
	@ResponseBody
	public String sendMail() {
		
		return mail.sendmail();
	}

	/**
	 * Print MOCK mail message on console
	 * @param mockMail the MailSender reference
	 */
	@Autowired
	@Qualifier("mockMail")
	public void recievemail(MailSender mockMail) {
		
		String mailMessage = mockMail.sendmail();
		System.out.println(mailMessage);
		
	}
}
