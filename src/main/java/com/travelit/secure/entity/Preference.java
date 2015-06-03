package com.travelit.secure.entity;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by milinchuk on 5/29/15.
 */
public class Preference {
    private String name;
    private Set<String> value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getValue() {
        return value;
    }

    public void setValue(Set<String> value) {
        this.value = value;
    }

    public Preference(String name, Set<String> value) {
        this.name = name;
        this.value = value;
    }

    public Preference() {
    }

    public static List<Preference> fromMap(Map<String,String> map) {
        List<Preference> list = new ArrayList<>(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Preference p = new Preference();
            p.setName(p.getName());
            p.setValue(Sets.newHashSet(entry.getValue().split("\\s+")));
        }
        return list;
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
