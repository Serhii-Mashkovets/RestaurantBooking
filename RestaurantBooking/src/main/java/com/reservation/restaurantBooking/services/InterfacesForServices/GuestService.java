package com.reservation.restaurantBooking.services.InterfacesForServices;

import com.reservation.restaurantBooking.recordModels.GuestRecord;


import java.util.List;

public interface GuestService extends ReservationService{
    /**
     * Retrieves a single guest by ID.
     *
     * @param id guest identifier
     * @return guest found
     */
    GuestRecord getGuestById(Long id);

    /**
     * Retrieves all guests.
     *
     * @return all guests
     */
    List<GuestRecord> getAllGuests();

    /**
     * Creates and persists a {@link GuestRecord} based on incoming {@link GuestRecord}
     *
     * @param guestRecord guest information to create
     * @return the persisted guest information
     */
    GuestRecord createGuest(GuestRecord guestRecord);

    /**
     * Updates a guest entity.
     *
     * @param id          existing guest's ID
     * @param guestRecord {@link GuestRecord}
     * @return updated guest information
     */
    GuestRecord updateGuest(Long id, GuestRecord guestRecord);

    /**
     * Deletes a guest by ID.
     *
     * @param id guest identifier
     */
    void deleteGuest(Long id);
}
