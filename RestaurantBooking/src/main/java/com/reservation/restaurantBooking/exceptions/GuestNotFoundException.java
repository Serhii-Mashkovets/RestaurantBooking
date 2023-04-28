package com.reservation.restaurantBooking.exceptions;

public class GuestNotFoundException extends  RuntimeException{

    public GuestNotFoundException(String entityName, String propertyName, String propertyValue) {
        super(entityName + " with " + propertyName + " " + propertyValue + " not found.");
    }
}
