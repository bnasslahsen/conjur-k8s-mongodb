package org.cyberark.conjur.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ConjurK8sMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConjurK8sMongodbApplication.class, args);
	}

}
