package com.example.usuario.rickandmorty.domain;

import java.util.ArrayList;

/**
 * Created by Usuario on 28/06/2018.
 */

public class Character {
    public enum allGenders { Female, Male, Genderless, unknown};
    public enum allStatus { Alive, Dead, unknown };

    private int id;
    private String name;
    private allGenders gender;
    private String species;
    private String type;
    private allStatus status;
    private String origin;
    private String location;
    private String image;
    private String url;
    private String created;

    public static ArrayList<Character> ITEMS = new ArrayList<>();
    public static ArrayList<Integer> favourites = new ArrayList<>();
    public static int pages;
    public static Character getItem(int id) {
        for (Character item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Character(int id, String name, allGenders gender, String species, String type, allStatus status, String origin, String location, String image, String url, String created) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.species = species;
        this.type = type;
        this.status = status;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.url = url;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public allGenders getGender() {
        return gender;
    }

    public String getGenderString() {
        switch (gender) {
            case Female:
                return "Female";
            case Male:
                return "Male";
            case Genderless:
                return "Male";
            default:
                return "unknown";
        }
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

    public String getStatusString() {
        switch (status) {
            case Alive:
                return "Alive";
            case Dead:
                return "Dead";
            default:
                return "unknown";
        }
    }

    public String getOrigin() {
        return origin;
    }

    public String getImage() {
        return image;
    }


    public String getUrl() {
        return url;
    }

    public String getCreated() {
        return created;
    }

    public String getLocation() {
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

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
