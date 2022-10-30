package org.cyberark.conjur.demo;

import java.util.List;

import com.mongodb.ClientSessionOptions;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.ChangeStreamIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.connection.ClusterDescription;
import org.bson.Document;
import org.bson.conversions.Bson;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

/**
 * The type Mongo client config.
 * @author bnasslahsen
 */
@Component
@RefreshScope
@EnableMongoRepositories
public class MongoConfig implements MongoClient {

	/**
	 * The Mongo client.
	 */
	private MongoClient mongoClient;

	/**
	 * Instantiates a new Mongo client config.
	 *
	 * @param mongoProperties the mongo properties
	 */
	public MongoConfig(MongoProperties mongoProperties) {
		ConnectionString connectionString = new ConnectionString(mongoProperties.getUri());
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();
		this.mongoClient = MongoClients.create(mongoClientSettings);
	}


	@Override
	public MongoDatabase getDatabase(String s) {
		return mongoClient.getDatabase(s);
	}

	@Override
	public ClientSession startSession() {
		return mongoClient.startSession();
	}

	@Override
	public ClientSession startSession(ClientSessionOptions clientSessionOptions) {
		return mongoClient.startSession(clientSessionOptions);
	}

	@Override
	public void close() {
		mongoClient.close();
	}

	@Override
	public MongoIterable<String> listDatabaseNames() {
		return mongoClient.listDatabaseNames();
	}

	@Override
	public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
		return mongoClient.listDatabaseNames(clientSession);
	}

	@Override
	public ListDatabasesIterable<Document> listDatabases() {
		return mongoClient.listDatabases();
	}

	@Override
	public ListDatabasesIterable<Document> listDatabases(ClientSession clientSession) {
		return mongoClient.listDatabases(clientSession);
	}

	@Override
	public <TResult> ListDatabasesIterable<TResult> listDatabases(Class<TResult> aClass) {
		return mongoClient.listDatabases(aClass);
	}

	@Override
	public <TResult> ListDatabasesIterable<TResult> listDatabases(ClientSession clientSession, Class<TResult> aClass) {
		return mongoClient.listDatabases(clientSession,aClass);
	}

	@Override
	public ChangeStreamIterable<Document> watch() {
		return mongoClient.watch();
	}

	@Override
	public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> aClass) {
		return mongoClient.watch(aClass);
	}

	@Override
	public ChangeStreamIterable<Document> watch(List<? extends Bson> list) {
		return mongoClient.watch(list);
	}

	@Override
	public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> list, Class<TResult> aClass) {
		return mongoClient.watch(list,aClass);
	}

	@Override
	public ChangeStreamIterable<Document> watch(ClientSession clientSession) {
		return mongoClient.watch(clientSession);
	}

	@Override
	public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> aClass) {
		return mongoClient.watch(clientSession,aClass);
	}

	@Override
	public ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> list) {
		return mongoClient.watch(clientSession,list);
	}

	@Override
	public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> list, Class<TResult> aClass) {
		return mongoClient.watch(clientSession,list,aClass);
	}

	@Override
	public ClusterDescription getClusterDescription() {
		return mongoClient.getClusterDescription();
	}
}
