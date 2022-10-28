package org.cyberark.conjur.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Conjur k 8 s mongodb application.
 */
@SpringBootApplication
public class ConjurK8sMongodbApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConjurK8sMongodbApplication.class, args);
	}

}
