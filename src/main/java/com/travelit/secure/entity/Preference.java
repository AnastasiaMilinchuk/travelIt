package com.travelit.secure.entity;

import java.util.List;

/**
 * Created by milinchuk on 5/29/15.
 */
public class Preference {
    private String name;
    private List<String> value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public Preference(String name, List<String> value) {
        this.name = name;
        this.value = value;
    }

    public Preference(){}


}
