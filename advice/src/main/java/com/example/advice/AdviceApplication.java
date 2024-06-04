package com.example.advice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Run run, Marathon marathon) {
		return runner -> {
//			run.addJog();
//			run.addSprint();
//			marathon.addMarathon(10);
//          marathon.setKms(10);
//			marathon.isWinner(1);

			marathon.runMarathon();
		};
	}
}
