package com.travelit.secure.algorithms.prefer;

import com.travelit.secure.entity.Place;

/**
 * Created by Sony on 12.05.2015.
 */
public abstract class MCOAlgorithm {
    public MCOAlgorithm(double ratingCoefficient, double lengthCoefficient, double luxuryCoefficient, double avgRatingCoefficient, double eventsCoefficient) {
        this.ratingCoefficient = ratingCoefficient;
        this.lengthCoefficient = lengthCoefficient;
        this.luxuryCoefficient = luxuryCoefficient;
        this.avgRatingCoefficient = avgRatingCoefficient;
        this.eventsCoefficient = eventsCoefficient;
    }
    protected double luxuryCoefficient;
    protected double ratingCoefficient;
    protected double eventsCoefficient;
    protected double lengthCoefficient;
    protected double avgRatingCoefficient;

    protected void calculateFitness(Place place){}
    protected Place[] mergeSort(Place[] places,int begin,int end)
    {
        if(end - begin < 1) { return places;}
        int middle = (begin+end)/2;
        if(end - begin > 1)
        {
            places = mergeSort(places,begin,middle);
            places = mergeSort(places,middle+1,end);
        }
        merge(places,begin,middle,end);
        return places;
    }
    protected void merge(Place[] places,int begin,int middle,int end)
    {

        Place[] temp = new Place[places.length];
        for (int i = begin; i <= end; i++) {
            temp[i] = places[i];
        }
        int i = begin;
        int j = middle + 1;
        int k = begin;

        while (i <= middle && j <= end) {
            if (temp[i].getFitnessIndividual() <= temp[j].getFitnessIndividual()) {
                places[k] = temp[i];
                i++;
            } else {
                places[k] = temp[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            places[k] = temp[i];
            k++;
            i++;
        }


    }


    public double getRatingCoefficient() {
        return ratingCoefficient;
    }

    public void setRatingCoefficient(double ratingCoefficient) {
        this.ratingCoefficient = ratingCoefficient;
    }

    public double getLuxuryCoefficient() {
        return luxuryCoefficient;
    }

    public void setLuxuryCoefficient(double luxuryCoefficient) {
        this.luxuryCoefficient = luxuryCoefficient;
    }

    public double getLengthCoefficient() {
        return lengthCoefficient;
    }

    public void setLengthCoefficient(double lengthCoefficient) {
        this.lengthCoefficient = lengthCoefficient;
    }

    public double getEventsCoefficient() {
        return eventsCoefficient;
    }

    public void setEventsCoefficient(double eventsCoefficient) {
        this.eventsCoefficient = eventsCoefficient;
    }

    public double getAvgRatingCoefficient() {
        return avgRatingCoefficient;
    }

    public void setAvgRatingCoefficient(double avgRatingCoefficient) {
        this.avgRatingCoefficient = avgRatingCoefficient;
    }


}
