package com.travelit.secure.search;

import com.travelit.secure.config.StaticData;
import com.travelit.secure.entity.Place;
import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.PlaceService;
import com.travelit.secure.service.services.UserService;
import org.apache.maven.plugins.annotations.Component;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by milinchuk on 5/6/15.
 */
@Service
@ComponentScan("com.travelit")
public class UserPlaces {
    @Autowired
    private PlaceService placeService;
    @Autowired
    private UserService userService;

    public void setService(PlaceService service) {
        this.placeService = service;
    }


    public void subscribePlace(String userEmail, String placeID){
        System.out.println("Add Place to user");
        userService.addPlace(userEmail, new ObjectId(placeID));
        placeService.addSubscriber(new ObjectId(placeID));
    }

    public void unsubscribePlace(String userEmail, String placeID){
        System.out.println("Delete Place from user");
        userService.deletePlace(userEmail, new ObjectId(placeID));
        placeService.deleteSubscriber(new ObjectId(placeID));

    }

    public boolean isSubscribe(String userEmail, ObjectId placeID){
        return userService.isSubscribeToPlace(userEmail, placeID);
    }

    public Place getPlaceById(String id){
        return placeService.getById(id);
    }

    public List<Place> getPlacesForUser(String userEmail){
        return StaticData.getNinePlacesForUser(userEmail);
    }

    public List<Place> getAllPlaces(){
        return placeService.getAll();
    }

    public List<Place> getPlacesByCity(String city){
        return placeService.getPlaces(city);
    }

    public List<Place> getSubscribePlaces(String userEmail){
        List<String> placesID =  userService.getSubscribePlaceByUser(userEmail);
        List<Place> places = new LinkedList<>();
        for(String place: placesID){
           places.add(placeService.getById(place));
        }

        return places;
    }
    public List<Place> getAddedByUserPlaces(String userEmail){
        return placeService.getByUser(userEmail);
    }
}
