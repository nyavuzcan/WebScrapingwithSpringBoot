package com.openhere.OpenHere;

import main.java.com.openhere.sahibinden.service.InquireSatilikDaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@ComponentScan("main.java.com.openhere")
@EntityScan("main.java.com.openhere.sahibinden.entity")
public class OpenHereApplication extends SpringBootServletInitializer {

	@Autowired
	private InquireSatilikDaire inquireSatilikDaire;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OpenHereApplication.class);
	}

	//RUN AFTER SPRING BOOT START
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws Exception {


		inquireSatilikDaire.inquireDaireler();

	}

	//RUN METHOD BEFORE SPRING BOOT START
	/*@PostConstruct
	public void listen() throws Exception {

	}*/

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OpenHereApplication.class, args);
		//LogService.info(Application.class.getName(), "Service Started...");
	}
}