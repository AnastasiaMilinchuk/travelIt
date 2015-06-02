package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 11.05.2015.
 */
public class Population {
    Place[] places;

    public Population(Place[] places) {
        this.places = places;
    }

    public Place[] getPlaces() {
        return places;
    }

    public void setPlaces(Place[] places) {
        this.places = places;
    }
}
