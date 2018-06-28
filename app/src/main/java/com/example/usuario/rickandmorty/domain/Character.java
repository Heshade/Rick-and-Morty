package com.example.usuario.rickandmorty.domain;

import java.util.ArrayList;

/**
 * Created by Usuario on 28/06/2018.
 */

public class Character {
    public enum allGenders { Female, Male, Genderless, unknown};
    private enum allStatus { Alive, Dead, unknown };

    private int id;
    private String name;
    private allGenders gender;
    private String species;
    private String type;
    private allStatus status;
    private Place origin;
    private Place location;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private String created;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public allGenders getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public allStatus getStatus() {
        return status;
    }

    public Place getOrigin() {
        return origin;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }

    public Place getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(allGenders gender) {
        this.gender = gender;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(allStatus status) {
        this.status = status;
    }

    public void setOrigin(Place origin) {
        this.origin = origin;
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setEpisode(ArrayList<String> episode) {
        this.episode = episode;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
