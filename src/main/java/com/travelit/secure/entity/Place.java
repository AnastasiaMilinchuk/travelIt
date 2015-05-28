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
    private Coordinates coordinates;
    private String photo;
    private String creatorEmail;
    private Date dateOfCreation;
    private int subscribers;
    private double  x;
    private double  y;

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

    // Gets city's x coordinate
    public double getX(){
        return this.x;
    }

    // Gets city's y coordinate
    public double getY(){
        return this.y;
    }

    // Gets the distance to given city
    public double distanceTo(Place city){
        double xDistance = Math.abs(getX() - city.getX());
        double yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
