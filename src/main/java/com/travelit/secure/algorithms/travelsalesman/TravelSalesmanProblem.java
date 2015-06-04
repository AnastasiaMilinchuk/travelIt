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
        TourManager.setDestinationCities(places);
        System.out.println("tour manager " + TourManager.numberOfCities());
        Population pop = evolvePopulation(createPopulation(150, true));
        System.out.println(pop.getFittest().getPlaces().size());
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
