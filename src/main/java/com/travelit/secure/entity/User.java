package com.travelit.secure.entity;

import com.travelit.secure.validation.annotations.PasswordMatches;
import com.travelit.secure.validation.annotations.ValidEmail;
import com.travelit.secure.validation.annotations.ValidPlace;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Document(collection = "users")
@PasswordMatches
public class User  {

    private String firstName;
    private String lastName;

    @NotNull
    @ValidEmail
    private String email;

    @NotNull
    private String password;
    private String matchingPassword;

    @NotNull
    private int role;
    private Map<String, String> preferences;

    private List<String> places;

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }

    public User() {}

    public User(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email  = email;
        System.out.println("koko setting User Email");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString(){
        return "Login: " + email + " Role: " + role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
