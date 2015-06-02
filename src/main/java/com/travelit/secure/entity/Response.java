package com.travelit.secure.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milinchuk on 6/1/15.
 */
public class Response {
    private List<Place> places;
    private List<Coordinates> coordinates;

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Coordinates> getCoordinates(){
        return coordinates;
    }

    public Response(){}

    public Response(List<Place> places) {
        this.places = places;
        this.coordinates  = new ArrayList<>();
        for(Place place: places){
            coordinates.add(new Coordinates(place.getX(), place.getY(), place.getName()));
        }
    }
}
