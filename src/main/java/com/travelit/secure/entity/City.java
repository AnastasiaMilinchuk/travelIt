package com.travelit.secure.entity;

/**
 * Created by milinchuk on 6/3/15.
 */
public class City {
    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City() {
    }
}
