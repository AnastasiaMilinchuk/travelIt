package com.travelit.secure.entity;

import com.travelit.secure.validation.annotations.ValidPlace;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by milinchuk on 4/27/15.
 */

@Document(collection = "places")
@ValidPlace
public class Place {
    private String name;
    private String address;
    private List<String> tags;
    private Coordinates coordinates;
    private String pathMainPhoto;

    public String getPathMainPhoto() {
        return pathMainPhoto;
    }

    public void setPathMainPhoto(String pathPhoto) {
        this.pathMainPhoto = pathPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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
