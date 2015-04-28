package com.travelit.secure.service.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by milinchuk on 4/26/15.
 */

@Service
@Configuration
public class MongoRepository {
    protected MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    protected void create(Object obj){
        mongoTemplate.insert(obj);
    }

    protected void delete(Object obj){
        mongoTemplate.remove(obj);
    }


}
