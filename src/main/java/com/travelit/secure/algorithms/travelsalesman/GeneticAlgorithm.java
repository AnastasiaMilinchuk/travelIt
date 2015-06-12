package com.travelit.secure.algorithms.travelsalesman;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.travelit.secure.entity.Place;
import sun.management.resources.agent_pt_BR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by milinchuk on 6/11/15.
 */
public class GeneticAlgorithm {
    private List<Place> places;
    private Population currentPopulation;
    private int numberOfElit;
    private double selectionRate;
    private double mutationRate;
    private int populationCount;

    public GeneticAlgorithm(List<Place> places, int numberOfElit, double selectionRate, double mutationRate, int populationCount) {
        this.places = places;
        this.numberOfElit = numberOfElit;
        this.selectionRate = selectionRate;
        this.mutationRate = mutationRate;
        this.populationCount = populationCount;
    }

    private void generatePopulation(){
        currentPopulation = new Population(populationCount);
        List<Route> population = new ArrayList<>(populationCount);
        for(int i = 0; i < populationCount; i++){
            // Create random placed Places
            Collections.shuffle(places);
            // Add route to population
            population.add(i, new Route(places));
        }

        currentPopulation.setRoutes(population);
    }


    private void createNewGeneration(){
        selection();
    }

    private void selection(){
        // select 2 parents
        // otdat` predpotchtenie elite, but rarely include non elite
        int leftParentIndex;
        int rigthParentIndex;
        double randomSelection = Math.random();
        if(randomSelection >= selectionRate){
            // choose from elites
            leftParentIndex = getRandomIndex(1, numberOfElit);
            rigthParentIndex= getRandomIndex(1, numberOfElit);
            while (leftParentIndex == rigthParentIndex){
                rigthParentIndex = getRandomIndex(1, numberOfElit);
            }
        }
        else{
            // choose from not elite
            if(randomSelection > selectionRate / 3){
                leftParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                rigthParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                while (leftParentIndex == rigthParentIndex){
                    rigthParentIndex = getRandomIndex(numberOfElit + 1, currentPopulation.size());
                }
            }
            else {
                // choose from elite and not elite
                leftParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                rigthParentIndex= getRandomIndex(1, numberOfElit);
                while (leftParentIndex == rigthParentIndex){
                    rigthParentIndex = getRandomIndex(0, numberOfElit);
                }
            }
        }

        // crossing over
        crossingover(currentPopulation.getRoute(leftParentIndex),
                currentPopulation.getRoute(rigthParentIndex));
    }

    private void crossingover(Route leftParent, Route rigthParent){
//        int crossoverPoint  = (int)(Math.random() * places.size());
//        if (crossoverPoint + 2 >= rigthParent.size()){
//            crossoverPoint /= 2;
//        }
//
//        List<Place> subRoute1 = leftParent.clone().getAllPlaces().subList(0, crossoverPoint);
//        List<Place> subRoute2 = rigthParent.clone().getAllPlaces().subList(crossoverPoint, rigthParent.size());
//        System.out.println(subRoute1.size() + " " + subRoute2.size());
//        // first child
//        List<Place> route = clonePlaces(subRoute1);
//        route.addAll(subRoute2);
//        Route newRoute = new Route(route);
//        //mutation
//        newRoute = mutation(newRoute);
//        currentPopulation.setRoute(getRandomNotElitePosition(), newRoute);
//
//        assignElitism();
//
//        // second child
//        route = clonePlaces(subRoute2);
//        route.addAll(subRoute1);
//        newRoute = new Route(route);
//        // mutation
//        newRoute = mutation(newRoute);
//        currentPopulation.setRoute(getRandomNotElitePosition(), newRoute);

        List<Place> child = new ArrayList<>();
        for(int i = 0; i < leftParent.size(); i++){
            child.add(null);
        }

        // Get start and end sub tour positions for parent1's tour
        int start = (int) (Math.random() * leftParent.size());
        int end = (int) (Math.random() * leftParent.size());
        if(start >  end){
            int temp = start;
            start = end;
            end = temp;
        }

        for (int i = start; i < end; i++) {
             child.set(i, leftParent.getPlace(i));
        }

        for (int i = 0; i < rigthParent.size(); i++) {
            if (!child.contains(rigthParent.getPlace(i))) {
                for (int ii = 0; ii < child.size(); ii++) {
                    if (child.get(ii) == null) {
                        child.set(ii, rigthParent.getPlace(i));
                        break;
                    }
                }
            }
        }
        System.out.println(child.toString());
        currentPopulation.setRoute(getRandomNotElitePosition(), new Route(child));
        assignElitism();
    }

    private List<Place> clonePlaces(List<Place> pls){
        List<Place> placeList = new ArrayList<>(pls.size());
        for(Place p: pls){
            placeList.add(p);
        }
        return placeList;
    }

    private Route mutation(Route route){
        for(int position = 0; position > route.size(); position++){
            double random = Math.random();
            if(random < mutationRate){
                Place place1 = route.getPlace(position);
                Place place2 = route.getPlace((int)(route.size() * random));
                route.setPlace((int)(route.size() * random), place1);
                route.setPlace(position, place2);
            }
        }
        return route;
    }

    private int getRandomNotElitePosition(){
        List<Integer> notEliteIndexes = new ArrayList<>(currentPopulation.size() - numberOfElit);

        for(int i = 0; i < currentPopulation.size(); i++){
            if(!currentPopulation.getRoutes().get(i).isElite()){
                notEliteIndexes.add(i);
            }
        }

        Collections.shuffle(notEliteIndexes);
        return notEliteIndexes.get(0);
    }

    private void assignElitism(){
        for(int i = 0; i < numberOfElit; i++){
            currentPopulation.getRoute(i).setElite(true);
        }
        for(int i = numberOfElit; i < currentPopulation.size(); i++){
            currentPopulation.getRoute(i).setElite(false);
        }

    }

    private int getRandomIndex(int start, int end){
        double t = Math.random();
        int r;
        if(start <= 1){
            r = (int)(t * end) - 1;
            if(r < 1){
                r = 0;
            }
        }
        else
            r =  Math.abs((int)(end * t) - start);
        return r;
    }


    public Route run(){
        generatePopulation();
        boolean stopCriteria = false;
        for(int i = 0; i < currentPopulation.size(); i++){
            createNewGeneration();
            System.out.println("New generation, best route:" + currentPopulation.getBestRoute().getRating());
        }

        return currentPopulation.getBestRoute();
    }
}
