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

    public Preference() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Preference that = (Preference) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
