package com.travelit.secure.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by milinchuk on 5/27/15.
 */
public class Prefer {
    private List<String> books;
    private List<String> hobbies;
    private List<String> films;
    private List<String> sport;
    private List<String> music;

    public Prefer() {
        books = new LinkedList<>();
        hobbies = new LinkedList<>();
        films = new LinkedList<>();
        sport = new LinkedList<>();
        music = new LinkedList<>();
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getSport() {
        return sport;
    }

    public void setSport(List<String> sport) {
        this.sport = sport;
    }

    public List<String> getMusic() {
        return music;
    }

    public void setMusic(List<String> music) {
        this.music = music;
    }

    public boolean equals(Prefer prefer){
       return books.equals(prefer.books) &&
                hobbies.equals(prefer.hobbies) &&
                films.equals(prefer.films) &&
                sport.equals(prefer.sport) &&
                music.equals(prefer.music);

    }
}
