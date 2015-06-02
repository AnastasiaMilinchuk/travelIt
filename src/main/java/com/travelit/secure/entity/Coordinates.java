package com.travelit.secure.entity;

/**
 * Created by milinchuk on 4/27/15.
 */
public class Coordinates {
    public double x;
    public double y;
    public String name;

    public Coordinates(double x,  double y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
