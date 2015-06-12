package com.travelit.secure.algorithms.travelsalesman;

import com.travelit.secure.entity.Place;

import java.util.Collections;
import java.util.List;

/**
 * Created by milinchuk on 6/8/15.
 */
public class Route {
    private List<Place> route;
    private double totalLength;
    private double rating;
    private boolean isElite;

    private Route(Route route){
        this.route = route.route;
        this.totalLength = route.totalLength;
        this.rating = route.rating;
        this.isElite = route.isElite;
    }

    public Route clone(){
        return new Route(this);
    }

    public Route(List<Place> route) {
        this.route = route;
        isElite = false;
        calculateTotalLength();
        calculateRating();
        //generateRandomGen();
    }

    public Place getPlace(int index){
        return route.get(index);
    }

    public void setPlace(int index, Place place){
        route.set(index, place);
        calculateTotalLength();
    }

    private void generateRandomGen(){
        Collections.shuffle(route);

    }

    private void calculateTotalLength(){
        Place last = route.get(0);
        totalLength = 0;
        for(Place current: route){
            double dist = last.getDistance(current);
            totalLength += dist;
            last = current;
        }
    }

    private void calculateRating(){
        this.rating = 1 / this.totalLength;
    }

    public double getTotalLength(){
        return this.totalLength;
    }

    public double getRating(){
        return this.rating;
    }

    public boolean isExist(Place place){
        return route.contains(place);
    }

    public int size(){
        return route.size();
    }

    public boolean isElite() {
        return isElite;
    }

    public void setElite(boolean isElite) {
        this.isElite = isElite;
    }

    public void run(){
        generateRandomGen();
    }
    public List<Place> getAllPlaces(){
        return route;
    }

    @Override
    public String toString() {
        String routeString = " Route: ";
        for (Place place: route) {
            routeString += place.getName() + " -> ";
        }
        routeString += route.get(0).getName();
        return routeString;
    }
}
