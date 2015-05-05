package com.travelit.secure.service.services;

import com.travelit.secure.entity.Coordinates;
import com.travelit.secure.entity.Place;

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

}
