package com.travelit.secure.config;

import com.travelit.secure.entity.Place;
import com.travelit.secure.entity.User;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by milinchuk on 5/21/15.
 */
public class StaticData {
    public static Place getPlace(){
        Place place = new Place();
        place.setId(new ObjectId("555d8dd10c6d12299f3f99a6"));
        place.setName("Museum of WW of 2");
        place.setDescription("Powerful place with view on the river and the left bank of city");
        place.setDateOfCreation(new Date());
        place.setAddress("Ukraine Kiev Museum");
        place.setCreatorEmail("admin@gmail.com");
        place.setSubscribes(23);
        place.setPhoto("/pages/content/photos/img.png");
        List<String> tags = new LinkedList<>();

        tags.add("museum");
        tags.add("history");
        place.setTags(tags);

        return place;
    }

    public static List<Place> getNinePlacesForUser(String userEmail){
        List<Place> places = new LinkedList<>();
        for(int i = 0; i < 9; i++){
            places.add(getPlace());
        }

        return places;
    }
}

