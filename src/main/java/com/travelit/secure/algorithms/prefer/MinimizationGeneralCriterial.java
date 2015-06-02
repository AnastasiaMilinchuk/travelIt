
package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 12.05.2015.
 */
public class MinimizationGeneralCriterial extends MCOAlgorithm implements AlgoStrategy {

    private Place minPlace;


    public Place getMinPlace() {
        return minPlace;
    }

    public void setMinPlace(Place minPlace) {
        this.minPlace = minPlace;
    }

    public MinimizationGeneralCriterial(double ratingCoefficient, double lengthCoefficient, double luxuryCoefficient, double avgRatingCoefficient, double eventsCoefficient) {
        super(ratingCoefficient, lengthCoefficient, luxuryCoefficient, avgRatingCoefficient, eventsCoefficient);
        this.minPlace = new Place(0,0,0,0,0,"lucas");
    }

    public Place[] mcoAlgo(Population pop)
    {
        calculateMinPlace(pop.getPlaces());
        for(Place place : pop.getPlaces())
        {
            calculateFitness(place);
        }

        mergeSort(pop.getPlaces(),0,pop.getPlaces().length-1);
    return pop.getPlaces();
    }
    protected void calculateFitness(Place place)
    {
        double newFitness = 0.0;
        newFitness += this.getLuxuryCoefficient()*(place.getLuxury() - this.minPlace.getLuxury()) / this.minPlace.getLuxury();
        newFitness += this.getRatingCoefficient()*(place.getRating() - this.minPlace.getRating()) / this.minPlace.getRating();
        newFitness += this.getEventsCoefficient()*(place.getEventsNowNumber() - this.minPlace.getEventsNowNumber())/ this.minPlace.getEventsNowNumber();
        newFitness += this.getLengthCoefficient()*(place.getLength() - this.minPlace.getLength()) / this.minPlace.getLength();
        newFitness += this.getAvgRatingCoefficient() *(place.getAvgRatingForAdditionalCriterias() - this.minPlace.getAvgRatingForAdditionalCriterias()) / this.minPlace.getAvgRatingForAdditionalCriterias();

        place.setFitnessIndividual(newFitness);
    }
    protected  void calculateMinPlace(Place[] places)
    {
        double tempLuxury = places[0].getLuxury();
        double tempRating = places[0].getRating();
       double tempEvents = places[0].getEventsNowNumber();
        double tempLength = places[0].getLength();
        double tempAvgRating = places[0].getAvgRatingForAdditionalCriterias();
        for(Place place : places)
        {
            if (place.getRating() < tempRating)
                tempRating = place.getRating();
            if (place.getLuxury() < tempLuxury)
                tempLuxury = place.getLuxury();
            if (place.getEventsNowNumber() < tempEvents)
                tempEvents = place.getEventsNowNumber();
            if (place.getLength() < tempLength)
                tempLength = place.getLength();
            if (place.getAvgRatingForAdditionalCriterias() < tempAvgRating)
                tempAvgRating = place.getAvgRatingForAdditionalCriterias();
        }
        this.minPlace = new Place(tempAvgRating,tempEvents,tempLength,tempLuxury,tempRating,"Temp");
    }



}
