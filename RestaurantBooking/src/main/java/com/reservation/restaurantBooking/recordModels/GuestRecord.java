package com.reservation.restaurantBooking.recordModels;


/**
 * Guest representation
 *
 * @param id unique identifier
 */
public record GuestRecord(
        Long id
) {

    public GuestRecord (Long id) {
        this.id = id;
    }
}
