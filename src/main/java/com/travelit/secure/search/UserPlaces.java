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

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public List<Place> getNinePlacesForUser(String userEmail){
        return StaticData.getNinePlacesForUser(userEmail);
    }
}
