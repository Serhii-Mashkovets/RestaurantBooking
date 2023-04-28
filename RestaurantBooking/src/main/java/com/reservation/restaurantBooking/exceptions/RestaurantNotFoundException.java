package com.reservation.restaurantBooking.exceptions;


public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(String entityType, String idFieldName, String idValue) {
        super(entityType + " with " + idFieldName + " " + idValue + " not found.");
    }
}
