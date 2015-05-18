package com.travelit.secure.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by milinchuk on 5/16/15.
 */
public class PlaceData {
    Place place;
    MultipartFile image;

    public String getOlolo() {
        return ololo;
    }

    public void setOlolo(String ololo) {
        System.out.println("click setting ololo "+ ololo);
        this.ololo = ololo;
    }

    String ololo;

    public PlaceData(){
        ololo=new String();
        place = new Place();
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        System.out.println("koko image !!!!!!jfhjkjd!!!!");
        this.image = image;
    }
}
