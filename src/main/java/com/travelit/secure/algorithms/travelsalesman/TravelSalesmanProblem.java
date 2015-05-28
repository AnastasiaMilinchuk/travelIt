package com.travelit.secure.algorithms.travelsalesman;

import com.travelit.secure.entity.Place;

import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * Created by milinchuk on 5/6/15.
 */
public class TravelSalesmanProblem {

    public List<Place> findPath(List<Place> places){
        Population pop = evolvePopulation(createPopulation(100, true));
        System.out.println();
        return pop.getFittest().getPlaces();
    }

    private Population createPopulation(int populationSize, boolean initialize){
        return new Population(populationSize, initialize);
    }

    private Population evolvePopulation(Population population){
        for (int i = 0; i < population.populationSize(); i++) {
            population = GeneticAlgo.evolvePopulation(population);
        }
        return population;
    }
}
