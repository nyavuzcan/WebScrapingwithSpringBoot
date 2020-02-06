package main.java.com.openhere.beta;

import com.openhere.OpenHere.OpenHereApplication;
import main.java.com.openhere.sahibinden.repository.SatilikDaireRepo;
import main.java.com.openhere.sahibinden.service.InquireKiralikDaire;
import main.java.com.openhere.sahibinden.serviceImp.InquireKiralikDaireImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan("main.java.com.openhere.sahibinden.entity")
@ComponentScan("main.java.com.openhere")
@EnableMongoRepositories("main.java.com.openhere.sahibinden.repository")
public class SpringRootApp extends SpringBootServletInitializer {

	@Autowired
	private InquireKiralikDaire inquireKiralikDaire;


	@PostConstruct
	public void listen() throws Exception {



	}
		//RUN AFTER SPRING BOOT START
		@EventListener(ApplicationReadyEvent.class)
		public void doSomethingAfterStartup() throws Exception {


			inquireKiralikDaire.inquireDaireler();
		}

		//RUN METHOD BEFORE SPRING BOOT START
	/*@PostConstruct
	public void listen() throws Exception {
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringRootApp.class, args);
	}

}

