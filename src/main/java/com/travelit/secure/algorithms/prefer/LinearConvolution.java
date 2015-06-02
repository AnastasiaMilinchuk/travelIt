
package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 11.05.2015.
 */
public class LinearConvolution extends MCOAlgorithm implements AlgoStrategy{

    public LinearConvolution(double ratingCoefficient, double lengthCoefficient, double luxuryCoefficient, double avgRatingCoefficient, double eventsCoefficient) {
        super(ratingCoefficient, lengthCoefficient, luxuryCoefficient, avgRatingCoefficient, eventsCoefficient);
    }

    protected void calculateFitness(Place place)
    {
        double newFitness = 0.0D;
        newFitness += place.getLuxury()*this.getLuxuryCoefficient();
        newFitness += place.getRating()*this.getRatingCoefficient();
        newFitness += place.getEventsNowNumber()*this.getEventsCoefficient();
        newFitness += place.getLength()*this.getLengthCoefficient();
        newFitness += place.getAvgRatingForAdditionalCriterias()*this.getAvgRatingCoefficient();

        place.setFitnessIndividual(newFitness);
    }
    public Place[] mcoAlgo(Population pop)
    {
    	Place[] arr$ = pop.getPlaces();
    	int len$ =arr$.length;
    	
        for(int i = 0; i < len$ ; ++i)
        {
        	Place place = arr$[i];
            this.calculateFitness(place);
        }
        pop.setPlaces(mergeSort(pop.getPlaces(), 0, pop.getPlaces().length-1));
    return pop.places;
    }


}
