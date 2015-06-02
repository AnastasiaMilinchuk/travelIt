
package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 12.05.2015.
 */
public class MinMaxGeneralCriteria extends MCOAlgorithm implements AlgoStrategy {

private Place minMaxCoefficientPlace;

    public MinMaxGeneralCriteria(double ratingCoefficient, double lengthCoefficient, double luxuryCoefficient, double avgRatingCoefficient, double eventsCoefficient) {
        super(ratingCoefficient, lengthCoefficient, luxuryCoefficient, avgRatingCoefficient, eventsCoefficient);

        this.minMaxCoefficientPlace = new Place(0,0,0,0,0,"lucas");
    }

    public Place getMinMaxCoefficientPlace() {
        return minMaxCoefficientPlace;
    }

    public void setMinMaxCoefficientPlace(Place minMaxCoefficientPlace) {
        this.minMaxCoefficientPlace = minMaxCoefficientPlace;
    }
    private void calculateMinMaxPlace(Place[] places)
    {
        double tempLuxury = places[0].getLuxury();
        double tempRating = places[0].getRating();
        double tempEvents = places[0].getEventsNowNumber();
        double tempLength = places[0].getLength();
        double tempAvgRating = places[0].getAvgRatingForAdditionalCriterias();
        for(Place place : places)
        {
            if (place.getRating() > tempRating)
                tempRating = place.getRating();
            if (place.getLuxury() > tempLuxury)
                tempLuxury = place.getLuxury();
            if (place.getEventsNowNumber() > tempEvents)
                tempEvents = place.getEventsNowNumber();
            if (place.getLength() > tempLength)
                tempLength = place.getLength();
            if (place.getAvgRatingForAdditionalCriterias() > tempAvgRating)
                tempAvgRating = place.getAvgRatingForAdditionalCriterias();
        }
        this.minMaxCoefficientPlace = new Place(1/tempAvgRating,1/tempEvents,1/tempLength,1/tempLuxury,1/tempRating,"MinMaxCoefficientPlace");


    }
    protected void calculateFitness(Place place)
    {
        double newFitness = 0;

        double avgRating = place.getAvgRatingForAdditionalCriterias() * this.getMinMaxCoefficientPlace().getAvgRatingForAdditionalCriterias();
        double eventsNowNumber = place.getEventsNowNumber() * this.getMinMaxCoefficientPlace().getEventsNowNumber();
        double length =  place.getLength() * this.getMinMaxCoefficientPlace().getLength();
        double luxury = place.getLuxury() * this.getMinMaxCoefficientPlace().getLuxury();
        double rating = place.getRating() * this.getMinMaxCoefficientPlace().getRating();

        newFitness = Math.max(Math.max(avgRating,eventsNowNumber), Math.max( Math.max(length,luxury), rating));
        place.setFitnessIndividual(newFitness);
    }
    public Place[] mcoAlgo(Population pop)
    {
        calculateMinMaxPlace(pop.getPlaces());
        for(Place place : pop.getPlaces())
        {
            calculateFitness(place);
        }

        mergeSort(pop.getPlaces(), 0, pop.getPlaces().length - 1);
        return pop.getPlaces();
    }



}
