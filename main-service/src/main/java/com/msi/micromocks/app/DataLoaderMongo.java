package com.msi.micromocks.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

public class DataLoaderMongo implements CommandLineRunner {

	private final MongoTemplate mongoTemplate;

    public DataLoaderMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) {
    	
    }
}
