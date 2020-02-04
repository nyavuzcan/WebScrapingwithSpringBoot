package com.openhere.OpenHere;

import main.java.com.openhere.sahibinden.service.InquireKiralikDaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("main.java.com.openhere")
@EnableJms
public class OpenHereApplication extends SpringBootServletInitializer {

	@Autowired
	private InquireKiralikDaire inquireKiralikDaire;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OpenHereApplication.class);
	}

	@PostConstruct
	public void listen() throws Exception {
		inquireKiralikDaire.inquireDaireler();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OpenHereApplication.class, args);
		//LogService.info(Application.class.getName(), "Service Started...");
	}
}