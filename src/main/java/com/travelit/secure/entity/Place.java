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
    private List<String> tags;
    private Coordinates coordinates;
    private String photo;
    private String creatorEmail;
    private Date dateOfCreation;
    private int subscribers;


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
