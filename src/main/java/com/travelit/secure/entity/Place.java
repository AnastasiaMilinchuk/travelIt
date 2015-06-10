package com.travelit.secure.entity;

import com.travelit.secure.validation.annotations.ValidPlace;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.BufferedOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by milinchuk on 4/27/15.
 */

@Document(collection = "places")
@ValidPlace
public class Place {
    private ObjectId id;
    private String name;
    private String description;
    private String address;
    private String city;
    private List<String> tags;
    private String photo;
    private String creatorEmail;
    private Date dateOfCreation;
    private int subscribers;
    private double  x;
    private double  y;

    private double luxury; // show how expensive this place
    private double length; // distance between user and place
    private double rating; // user rating
    private double eventsNowNumber; // number of current active events
    private double avgRatingForAdditionalCriterias; // average rating of additional criterias
    private double fitnessIndividual; // represent how individual is attractive

    public Place(double avgRatingForAdditionalCriterias, double eventsNowNumber, double length, double luxury, double rating,String name) {
        this.avgRatingForAdditionalCriterias = avgRatingForAdditionalCriterias;
        this.eventsNowNumber = eventsNowNumber;
        this.fitnessIndividual = 0;
        this.length = length;
        this.luxury = luxury;
        this.rating = rating;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLuxury() {
        return luxury;
    }

    public void setLuxury(double luxury) {
        this.luxury = luxury;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getEventsNowNumber() {
        return eventsNowNumber;
    }

    public void setEventsNowNumber(double eventsNowNumber) {
        this.eventsNowNumber = eventsNowNumber;
    }

    public double getAvgRatingForAdditionalCriterias() {
        return avgRatingForAdditionalCriterias;
    }

    public void setAvgRatingForAdditionalCriterias(double avgRatingForAdditionalCriterias) {
        this.avgRatingForAdditionalCriterias = avgRatingForAdditionalCriterias;
    }

    public double getFitnessIndividual() {
        return fitnessIndividual;
    }

    public void setFitnessIndividual(double fitnessIndividual) {
        this.fitnessIndividual = fitnessIndividual;
    }

    @Override
    public String toString(){
        return city + ", " + name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getDistance(Place place){
        double distX = Math.abs(this.x - place.x);
        double distY = Math.abs(this.y - place.y);
        return  Math.sqrt((distX * distX) + ( distY * distY));
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Place() {
        subscribers = 0;
    }

    public int getSubscribes() {
        return subscribers;
    }

    public void setSubscribes(int subscribes) {
        this.subscribers = subscribes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("click setting Name Place");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("click address setting");
        this.address = address;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
