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
    private List<Route> sortRoutes;

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getSortRoutes() {
        return sortRoutes;
    }

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
        sort();
    }

    public void setRoute(int index, Route route){
        routes.set(index, route);
        sort();
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

    public List<Route> sortSequence(){
        if(sortRoutes == null){
            sort();
        }
        return sortRoutes;
    }

    private void sort(){
        sortRoutes = this.routes.subList(0, this.routes.size());
        for(int i = 0; i < sortRoutes.size(); i++){
            for(int j = 1; j < sortRoutes.size(); j++){
                if(sortRoutes.get(i).getRating() < sortRoutes.get(j).getRating()){
                    Route temp = sortRoutes.get(i);
                    sortRoutes.set(i, sortRoutes.get(j));
                    sortRoutes.set(j, temp);
                }
            }
        }
        routes = sortRoutes;
    }
}
