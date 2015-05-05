package com.travelit.secure.service.mongo.services;

import com.travelit.secure.entity.Coordinates;
import com.travelit.secure.entity.Place;
import com.travelit.secure.service.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by milinchuk on 4/27/15.
 */
@Service
@Configuration
public class PlaceMongoService implements PlaceService {
    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(@Qualifier("mongoTemplate") MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void save(Place place) {
        mongoTemplate.insert(place);
    }

    @Override
    public void remove(Place place) {
        mongoTemplate.remove(place);
    }

    @Override
    public Place getByCoordinates(Coordinates coordinators) {
        return null;
    }

    @Override
    public Place getByAddress(String address) {
        return null;
    }

    @Override
    public Place getByTags(List<String> tags) {
        return null;
    }


}
