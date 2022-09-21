package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

	private MongoProperties mongoProperties;

	public MongoConfig(MongoProperties mongoProperties) {
		this.mongoProperties = mongoProperties;
	}

	@Bean
	@RefreshScope
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString(mongoProperties.getUri());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}

}