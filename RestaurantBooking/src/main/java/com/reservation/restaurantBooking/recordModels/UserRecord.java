package com.reservation.restaurantBooking.recordModels;


/**
 *  User representation
 *
 * @param id unique identifier
 * @param name user name
 * @param email user email
 * @param password user password for granting/denying access
 */
public record UserRecord(

        Long id,
        String name,
        String email,
        String password
) {

    public UserRecord (Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
}
