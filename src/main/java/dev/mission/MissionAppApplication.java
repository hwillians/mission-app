package dev.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MissionAppApplication {

	public static void main(String[] args) {

		// Récupération du contexte Spring créé par Spring Boot
		// La classe de configuration initiale de Spring est MissionAppApplication
		ConfigurableApplicationContext context = SpringApplication.run(MissionAppApplication.class, args);

		// Récupération d'un bean de type Runnable
		Runnable exec = context.getBean(Runnable.class);

		// exécution
		exec.run();

	}

}
