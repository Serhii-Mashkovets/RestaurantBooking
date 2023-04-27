package com.reservation.restaurantBooking.entity;


/**
 * The AdminEntity class represents an entity in the database for administrators, with properties that
 * correspond to columns in the "admin" table.
 * It includes methods for setting and getting these properties and overrides the equals() and hashCode() methods
 * for comparing instances based on their properties.
 * The GuestEntity class represents an entity in the database for guests, with a single property corresponding to the "id"
 * column in the "guest" table. It includes methods for setting and getting this property and overrides the equals()
 * and hashCode() methods for comparing instances based on their id property.
 * The ReservationEntity class represents a reservation made by a guest or user at a restaurant,
 * with properties for the guest's name, reservation date and time, number of people, and confirmation status.
 * It also includes a field for the restaurant ID and a one-to-one relationship with the RestaurantEntity class.
 * Example usage includes setting properties and saving to the database using a repository.
 * The RestaurantEntity class represents a restaurant in the system, with properties for its id, name, and cuisine type.
 * It is used to establish a one-to-one relationship with the ReservationEntity class.
 * Example usage includes setting properties and saving to the database using a reservation entity.
 * The UserEntity class represents a user in the system, with properties for their id, name, email, and password.
 * Example usage includes creating, retrieving, and updating user information in the database using the entity manager.
 */