package com.travelit.secure.algorithms.travelsalesman;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.travelit.secure.entity.Place;
import sun.management.resources.agent_pt_BR;

import javax.annotation.processing.RoundEnvironment;
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
        System.out.println("Generate start population");
        currentPopulation = new Population(populationCount);
        List<Route> population = new ArrayList<>(populationCount);
        for(int i = 0; i < populationCount; i++){
            // Create random placed Places
            Collections.shuffle(places);
            System.out.println("Individ #" + i + "  " + places.toString());
            // Add route to population
            population.add(i, new Route(places));
        }

        currentPopulation.setRoutes(population);
    }


    private void createNewGeneration(){
        System.out.println("Creating new generation:");
        selection();
    }

    private void selection(){
        // select 2 parents
        // otdat` predpotchtenie elite, but rarely include non elite
        System.out.println("Selection");
        int leftParentIndex;
        int rigthParentIndex;
        double randomSelection = Math.random();
        if(randomSelection >= selectionRate){
            // choose from elites
            System.out.println("Random > selection rate, choose parents from elites");
            leftParentIndex = getRandomIndex(1, numberOfElit);
            rigthParentIndex= getRandomIndex(1, numberOfElit);
            while (leftParentIndex == rigthParentIndex){
                rigthParentIndex = getRandomIndex(1, numberOfElit);
            }
        }
        else{
            // choose from not elite

            if(randomSelection > selectionRate / 3){
                System.out.println("Random in range selection rate / 3 ... selection rate , choose parents from basic individs");
                leftParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                rigthParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                while (leftParentIndex == rigthParentIndex){
                    rigthParentIndex = getRandomIndex(numberOfElit + 1, currentPopulation.size());
                }
            }
            else {
                // choose from elite and not elite
                System.out.println("Random in range 0 ...  selection rate / 3, choose first parent from basic individs and second elite");
                leftParentIndex= getRandomIndex(numberOfElit + 1, currentPopulation.size());
                rigthParentIndex= getRandomIndex(1, numberOfElit);
                while (leftParentIndex == rigthParentIndex){
                    rigthParentIndex = getRandomIndex(0, numberOfElit);
                }
            }
        }

        System.out.println("Left index parent:" + leftParentIndex + ",  right index parent " + rigthParentIndex);
        // crossing over
        crossingover(currentPopulation.getRoute(leftParentIndex),
                currentPopulation.getRoute(rigthParentIndex));
    }

    private void crossingover(Route leftParent, Route rigthParent){
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

        child = localOptimization(child);
        System.out.println("After crossover" + child.toString());
        currentPopulation.setRoute(getRandomNotElitePosition(), mutation(new Route(child)));
        assignElitism();
    }


    private List<Place> localOptimization(List<Place> places){
        if(places.size() >= 5){
            int start = Math.abs((int) (Math.random() * places.size()) - 1);
            List<Place> sequence = new ArrayList<>();
            if(start == places.size()){
                sequence = getSeq(start - 2, start - 1, 0, 1, 2, places);
                sequence =  getOptSequence(new Route(sequence));
                places.set(start - 2, sequence.get(0));
                places.set(start - 1, sequence.get(1));
                places.set(0, sequence.get(2));
                places.set(1, sequence.get(3));
                places.set(2, sequence.get(4));
            }
            else {
                if(places.size() - start == 2){
                    sequence = getSeq(start - 2, start - 1, start, 0, 1, places);
                    sequence =  getOptSequence(new Route(sequence));
                    places.set(start - 2, sequence.get(0));
                    places.set(start - 1, sequence.get(1));
                    places.set(start, sequence.get(2));
                    places.set(0, sequence.get(3));
                    places.set(1, sequence.get(4));
                }
                else {
                    if(places.size() - start == 3){
                        sequence = getSeq(start - 2, start - 1, start, start + 1, 0, places);
                        sequence =  getOptSequence(new Route(sequence));
                        places.set(start - 2, sequence.get(0));
                        places.set(start - 1, sequence.get(1));
                        places.set(start, sequence.get(2));
                        places.set(start + 1, sequence.get(3));
                        places.set(0, sequence.get(4));
                    }
                    else {
                        if(start == 0){
                            sequence = getSeq(places.size() - 1, 0, 1, 2, 3, places);
                            sequence =  getOptSequence(new Route(sequence));
                            places.set(places.size() - 1, sequence.get(0));
                            places.set(0, sequence.get(1));
                            places.set(1, sequence.get(2));
                            places.set(2, sequence.get(3));
                            places.set(3, sequence.get(4));
                        }
                        else {
                            sequence = getSeq(start - 1, start, start+1, start + 2, start + 3, places);
                            sequence =  getOptSequence(new Route(sequence));
                            places.set(start - 1, sequence.get(0));
                            places.set(start, sequence.get(1));
                            places.set(start + 1 , sequence.get(2));
                            places.set(start + 2, sequence.get(3));
                            places.set(start + 3, sequence.get(4));
                        }
                    }
                }
            }
        }

        return places;
    }

    private List<Place> getSeq(int a, int b, int c, int d, int e, List<Place> places){
        List<Place> sequence = new ArrayList<>();
        sequence.add(places.get(a));
        sequence.add(places.get(b));
        sequence.add(places.get(c));
        sequence.add(places.get(d));
        sequence.add(places.get(e));
        return sequence;
    }

    private List<Place> getOptSequence(Route route){
        Route optimal = route.clone();
        int k = 1;
        double length = route.getTotalLength();
        for(int i = 0; i < 5; i++){
            if(i % 2 == 0){
                Place temp = route.getPlace(1);
                route.setPlace(1, route.getPlace(2));
                route.setPlace(2, temp);
            }
            else {
                Place temp = route.getPlace(2);
                route.setPlace(2, route.getPlace(3));
                route.setPlace(3, temp);
            }
            if(route.getTotalLength() < length){
                optimal = route.clone();
                length = route.getTotalLength();
            }
        }
        return optimal.getAllPlaces();
    }
    private double getLength(List<Place> places){
        Place last = places.get(0);
        double totalLength = 0;
        for(Place current: places){
            double dist = last.getDistance(current);
            totalLength += dist;
            last = current;
        }

        return totalLength;
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
