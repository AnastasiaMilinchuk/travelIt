package com.travelit.secure.algorithms.travelsalesman;

/**
 * Created by milinchuk on 5/27/15.
 */
import com.travelit.secure.entity.Place;

import java.util.ArrayList;
import java.util.List;

public class TourManager {

    // Holds our cities
    private static List<Place> destinationCities = new ArrayList<Place>();

    public static List<Place> getDestinationCities() {
        return destinationCities;
    }

    public static void setDestinationCities(List<Place> destinationCities) {
        TourManager.destinationCities = destinationCities;
    }

    // Adds a destination city
    public static void addCity(Place city) {
        destinationCities.add(city);
    }

    // Get a city
    public static Place getCity(int index){
        return (Place)destinationCities.get(index);
    }

    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }
}
