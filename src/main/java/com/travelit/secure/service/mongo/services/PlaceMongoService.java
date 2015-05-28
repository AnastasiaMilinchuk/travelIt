package com.travelit.secure.service.mongo.services;

import com.travelit.secure.entity.Coordinates;
import com.travelit.secure.entity.Place;
import com.travelit.secure.service.services.PlaceService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    @Override
    public Place getById(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("_id").is(new ObjectId(id))), Place.class);
    }

    @Override
    public void addSubscriber(ObjectId placeID) {
        updateSubscribers(placeID, 1);
    }

    @Override
    public void deleteSubscriber(ObjectId placeID) {
        updateSubscribers(placeID, -1);
    }

    @Override
    public List<Place> getPlaces(int number) {
       return mongoTemplate.find(new Query(Criteria.where("")).limit(number), Place.class);
    }

    private void updateSubscribers(ObjectId placeID, int inc){
        mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(placeID)), new Update().inc("subscribers", inc), Place.class);
    }



}
