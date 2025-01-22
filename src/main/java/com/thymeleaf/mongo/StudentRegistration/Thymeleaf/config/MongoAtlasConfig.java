package com.thymeleaf.mongo.StudentRegistration.Thymeleaf.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoAtlasConfig {

    @Value("${spring.data.mongodb.uri}")
    private String atlasMongoUri;


    @Bean(name="mongoTemplate")
    public MongoTemplate mongoTemplate() {
        String atlasUri = "mongodb+srv://office:kaungzaw162006@developement.2qlsf.mongodb.net/StudentRegistration?retryWrites=true&w=majority&appName=developement";
        MongoClient mongoClient = MongoClients.create(atlasUri);
        return new MongoTemplate(mongoClient, "students");
    }
}
