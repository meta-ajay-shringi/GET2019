package com.metacube.EADsession12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EaDsession12Application {

	public static void main(String[] args) {
		SpringApplication.run(EaDsession12Application.class, args);
	}

}
