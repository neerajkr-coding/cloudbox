package com.application.cloudbox.Client;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


@Configuration
public class mongodbClient {

    @Value("${mongodb.endpoint}")
    private String uri;

    public static MongoTemplate mongoTemplate;

    @PostConstruct
    public void buildMongoTemplate() {
        SimpleMongoClientDatabaseFactory simpleMongoClientDatabaseFactory = new SimpleMongoClientDatabaseFactory(mongoClient(), "cloudBox");
        mongoTemplate = new MongoTemplate(simpleMongoClientDatabaseFactory);
        System.out.println("MongoTemplate Build Successfully !!!!!!!!!!!!!!!");
    }

    private MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}
