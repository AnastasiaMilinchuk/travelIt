package com.travelit.secure.algorithms.travelsalesman;

/**
 * Created by milinchuk on 5/27/15.
 */
import com.travelit.secure.entity.Place;

import java.util.ArrayList;

public class TourManager {

    // Holds our cities
    private static ArrayList destinationCities = new ArrayList<Place>();

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
