package com.travelit.secure.algorithms.travelsalesman;

import com.travelit.secure.entity.Place;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * Created by milinchuk on 5/6/15.
 */
@Service
@Configuration
public class TravelSalesmanProblem {

    public List<Place> findPath(List<Place> places){
        System.out.println("TRAVELSALESMAN "+ places.size());
        Population pop = evolvePopulation(createPopulation(150, places), places);
        System.out.println(pop.getBestRoute().getAllPlaces().size());
        return pop.getBestRoute().getAllPlaces();
    }

    private Population createPopulation(int populationSize, List<Place> places){
        return new Population(populationSize, places);
    }

    private Population evolvePopulation(Population population, List<Place> places){
        for (int i = 0; i < population.size(); i++) {
            GeneticAlgo algo = new GeneticAlgo(places, 5, 0.015, true);
            population = algo.createNewIndivids(population);
        }
        return population;
    }
}
