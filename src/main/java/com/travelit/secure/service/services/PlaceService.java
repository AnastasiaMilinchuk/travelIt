package com.travelit.secure.service.services;

import com.travelit.secure.entity.Coordinates;
import com.travelit.secure.entity.Place;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by milinchuk on 4/26/15.
 */
public interface PlaceService {
    void save(Place place);
    void remove(Place place);
    Place getByCoordinates(Coordinates coordinators);
    Place getByAddress(String address);
    Place getByTags(List<String> tags);
    Place getById(String id);
    void addSubscriber(ObjectId placeID);
    void deleteSubscriber(ObjectId placeID);
    List<Place> getPlaces(String city);
    List<Place> getAll();
    List<Place> getByUser(String userEmail);
}
