package com.openhere.OpenHere;

import main.java.com.openhere.sahibinden.service.InquireKiralikDaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class OpenHereApplication extends SpringBootServletInitializer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(OpenHereApplication.class, args);
		InquireKiralikDaire inquireKiralikDaire =	context.getBean(InquireKiralikDaire.class);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

	}

}
