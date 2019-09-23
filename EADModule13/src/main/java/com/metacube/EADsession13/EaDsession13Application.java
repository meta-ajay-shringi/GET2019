package com.metacube.EADsession13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EaDsession13Application {

	public static void main(String[] args) {
		SpringApplication.run(EaDsession13Application.class, args);
	}

}
