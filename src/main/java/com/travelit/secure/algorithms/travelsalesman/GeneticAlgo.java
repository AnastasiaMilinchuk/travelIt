package com.travelit.secure.algorithms.travelsalesman;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.travelit.secure.entity.Place;

import java.util.List;

/**
 * Created by milinchuk on 5/28/15.
 */
public class GeneticAlgo {
    List<Place> places;
    private int tourne;
    private double mutation;
    private boolean valid;

    public GeneticAlgo(List<Place> places, int tourne, double mutation, boolean valid) {
        this.places = places;
        this.tourne = tourne;
        this.mutation = mutation;
        this.valid = valid;
    }

    public Population generate(Population oldPopulation){
        return mutateAllPopulation(oldPopulation, createNewIndivids(oldPopulation));
    }

    public Population createNewIndivids(Population old){
        Population newGeneration = new Population(old.size());
        newGeneration.setRoute(0, old.getBestRoute());

        for(int i = 0; i < old.size(); i++){
            // create population
            Route firstParent = selection(old);
            Route secondParent = selection(old);
            Route children = createGeneration(firstParent, secondParent);
            newGeneration.setRoute(i, children);
        }

        return newGeneration;
    }

    private Population mutateAllPopulation(Population old, Population newGeneration){
        for(int i = 0; i < old.size(); i++){
            // mutate
            mutate(newGeneration.getRoute(i));
        }

        return newGeneration;
    }

    private void mutate(Route route){
        for(int position = 0; position > route.size(); position++){
            double random = Math.random();
            if(mutation > random){
                Place place1 = route.getPlace(position);
                Place place2 = route.getPlace(getRandomPosition(route.size(), random));
                route.setPlace(getRandomPosition(position, getRandomPosition(route.size(), random)), place1);
                route.setPlace(position, place2);
            }
        }
    }

    private int getRandomPosition(int size, double random){
        return (int)(size * random);
    }

    private Route selection(Population population){
        Population newPop = new Population(tourne);
        List<Route> sort = population.sortSequence();
        for(int i = 0; i < tourne; i++){
            newPop.setRoute(i, sort.get(i));
        }
        return newPop.getBestRoute();
    }

    // crossover
    public Route createGeneration(Route firstParent, Route secondParent){
        Route child = new Route(places);
        int start  = (int)(Math.random() * firstParent.size());
        int destination = secondParent.size() - start;
//        if(start > destination){
//            int temp = start;
//            start = destination;
//            destination = temp;
//        }
        if(start < firstParent.size() / 2){
            for(int i = 0; i < firstParent.size() / 2; i++){
                    child.setPlace(i, firstParent.getPlace(i));
            }

            for(int i = firstParent.size(); i < secondParent.size(); i++){
                child.setPlace(i, secondParent.getPlace(i));
            }

        }
        else {
            for(int i = 0; i < firstParent.size() / 2; i++){
                child.setPlace(i, secondParent.getPlace(i));
            }

            for(int i = firstParent.size(); i < secondParent.size(); i++){
                child.setPlace(i, firstParent.getPlace(i));
            }
        }
        return child;
    }
}