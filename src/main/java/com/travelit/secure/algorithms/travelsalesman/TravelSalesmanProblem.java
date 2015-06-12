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
//        Population pop = evolvePopulation(createPopulation(100, places), places);
        int numberOfElite = 10;
        double selectionRate = 0.1;
        double mutationRate = 0.015;
        int populationCount = 100;
        GeneticAlgorithm algo = new GeneticAlgorithm(places, numberOfElite,
                selectionRate, mutationRate, populationCount);
        Route best = algo.run();
        System.out.println("best " + best);
        return best.getAllPlaces();
//        System.out.println(pop.getBestRoute().getAllPlaces().size());
//        return pop.getBestRoute().getAllPlaces();
    }

    private Population createPopulation(int populationSize, List<Place> places){
        return new Population(populationSize, places);
    }

    private Population evolvePopulation(Population population, List<Place> places){
        GeneticAlgo algo = new GeneticAlgo(places, 50, 0.15, true);
        for (int i = 0; i < population.size(); i++) {
            population = algo.generate(population);
        }
        return population;
    }
}
