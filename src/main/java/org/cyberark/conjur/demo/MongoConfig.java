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
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * The type Mongo config.
 */
@EnableMongoRepositories
@Configuration(proxyBeanMethods = false)
public class MongoConfig {

	/**
	 * The Mongo properties.
	 */
	private MongoProperties mongoProperties;

	/**
	 * Instantiates a new Mongo config.
	 *
	 * @param mongoProperties the mongo properties
	 */
	public MongoConfig(MongoProperties mongoProperties) {
		this.mongoProperties = mongoProperties;
	}

	/**
	 * Mongo mongo client.
	 *
	 * @return the mongo client
	 */
	@Bean
	@RefreshScope(proxyMode = ScopedProxyMode.NO)
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString(mongoProperties.getUri());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		return MongoClients.create(mongoClientSettings);
	}

}