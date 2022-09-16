package org.cyberark.conjur.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConjurK8sMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConjurK8sMongodbApplication.class, args);
	}

}
