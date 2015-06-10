package com.travelit.secure.algorithms.travelsalesman;

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
        return mutateAllPopulation(oldPopulation, createNewIndivids(new Population(oldPopulation.size())));
    }

    public Population createNewIndivids(Population old){
        Population newGeneration = new Population(old.size());
        int koef = 0;
        if(valid){
            newGeneration.setRoute(0, old.getBestRoute());
            koef++;
        }

        for(int i = koef; i < old.size(); i++){
            // create population
            Route firstParent = selection(old);
            Route secondParent = selection(old);
            Route children = createGeneration(firstParent, secondParent);
            newGeneration.setRoute(i, children);
        }

        return newGeneration;
    }

    private Population mutateAllPopulation(Population old, Population newGeneration){
        int koef = 0;
        if(valid){
            koef++;
        }

        for(int i = koef; i < old.size(); i++){
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
        for(int i = 0; i < tourne; i++){
            int index = (int) (Math.random() * population.size());
            newPop.setRoute(i, population.getRoute(index));
        }

        return newPop.getBestRoute();
    }

    public Route createGeneration(Route firstParent, Route secondParent){
        Route child = new Route(places);
        int start  = (int)(Math.random() * firstParent.size());
        int destination = (int) (Math.random() * secondParent.size());

        for(int i = 0; i < child.size(); i++){
            if(start < destination && i > start && i < destination){
                child.setPlace(i, firstParent.getPlace(i));
            }
            else {
                if(start > destination){
                    if(! (i < start && i > destination)){
                        child.setPlace(i, firstParent.getPlace(i));
                    }
                }
            }
        }

        for(int i = 0; i < secondParent.size(); i++){
            if(!child.isExist(secondParent.getPlace(i))){
                for(int j = 0; j < child.size(); j++){
                    if(child.getPlace(j) == null){
                        child.setPlace(j, secondParent.getPlace(i));
                        break;
                    }
                }
            }
        }

        return child;
    }
}