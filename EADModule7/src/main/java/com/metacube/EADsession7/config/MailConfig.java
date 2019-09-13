package com.metacube.EADsession7.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.EADsession7.service.MockMailSender;
import com.metacube.EADsession7.service.SmtpMailSender;

/**
 * configuration class
 *
 */
@Configuration
public class MailConfig {
	
	/**
	 * bean for SmtpMailSender object
	 * @return SmtpMailSender object
	 */
	//@Primary
	@Bean(name="smtpMail")
	public SmtpMailSender smtpMailBean() {
		return new SmtpMailSender();
	}
	
	/**
	 * bean for MockMailSender object
	 * @return MockMailSender object
	 */
	@Bean(name="mockMail")
	public MockMailSender mockMailBean() {
		return new MockMailSender();
	}
	

}

