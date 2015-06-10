package com.travelit.secure.algorithms.travelsalesman;

import com.travelit.secure.entity.Place;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by milinchuk on 5/28/15.
 */
public class Population {
    private List<Route> routes;

    public Population(int sizeOfPopulation, List<Place> places){
        // generate new population
        routes = new LinkedList<>();
        generatePopulation(sizeOfPopulation, places);
    }

    public Population(int size){
        routes = new LinkedList<>();
        for(int i = 0; i < size; i++){
            routes.add(null);
        }
    }

    private void generatePopulation(int size, List<Place> places){
        for(int i = 0; i < size; i++){
            routes.add(new Route(places));
        }
    }

    public void setRoute(int index, Route route){
        routes.set(index, route);
    }

    public Route getRoute(int index){
        return routes.get(index);
    }

    public List<Route> getRoutes(){
        return routes;
    }

    public Route getBestRoute(){
        Route best = routes.get(0);
        for(Route route: routes){
            if(route.getRating() > best.getRating()){
                best = route;
            }
        }
        return best;
    }

    public int size(){
        return routes.size();
    }
}
