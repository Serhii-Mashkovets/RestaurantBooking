package com.reservation.restaurantBooking.models;

/**
 * This class represents a restaurant entity with its name and cuisine type.
 * It contains information about restaurant`s name and cuisine type (there can be Italian, Chinese and Molecular cuisine).
 * The class has three private fields - id, name, cuisineType - with their respective
 * getter and setter methods. The id field is of type Long and represents the unique identifier of the restaurant.
 */

public class Restaurant {


    private Long id;


    private String name;

    private CuisineType cuisineType;

    public Restaurant(Long id, String name, CuisineType cuisineType) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisineType=" + cuisineType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }
}
