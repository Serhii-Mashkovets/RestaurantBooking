package com.reservation.restaurantBooking.models;


/**
 * The Guest class represents a guest in the restaurant booking system.
 * It contains the guest's ID information for tracking and identification purposes.
 * The class has one private field, id, with its respective getter and setter methods.
 * The id field is of type Long and represents the unique identifier of the guest.
 * The class is a simple data model for tracking guests in the system. It can be used to associate reservations,
 * orders, or reviews with a specific guest ID for analytics and reporting purposes.
 * Example usage:
 * // create a new guest object
 * Guest guest = new Guest();
 * // set the guest's id
 * guest.setId(1L);
 * // retrieve the guest's id
 * Long id = guest.getId();
 */
public class Guest {

    private Long id;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
