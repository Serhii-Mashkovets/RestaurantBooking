package com.reservation.restaurantBooking.recordModels;


/**
 *   Admin representation
 *
 * @param id unique Admin identifier
 * @param password password for granting/denying access
 */
public record AdminRecord(

        Long id,

        String password
) {


    public AdminRecord (Long id, String password) {
        this.id = id;
        this.password = password;
    }


}
