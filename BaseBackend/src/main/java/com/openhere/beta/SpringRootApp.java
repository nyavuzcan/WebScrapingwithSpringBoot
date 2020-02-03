package main.java.com.openhere.beta;

import main.java.com.openhere.sahibinden.service.InquireKiralikDaire;
import main.java.com.openhere.sahibinden.serviceImp.InquireKiralikDaireImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringRootApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringRootApp.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringRootApp.class);
	}

}
