package com.reservation.restaurantBooking.recordModels;

import com.reservation.restaurantBooking.models.CuisineType;


/**
 * Restaurant representation
 *
 * @param id unique identifier
 * @param name restaurant name
 * @param cuisineType the type of cuisine (could be Italian, Chinese, Molecular)
 */
public record RestaurantRecord(

        Long id,

        String name,

        CuisineType cuisineType
) {

    public RestaurantRecord (Long id, String name, CuisineType cuisineType) {
        this.id = id;
        this.name = name;
        this.cuisineType = cuisineType;
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public CuisineType cuisineType() {
        return cuisineType;
    }
}
