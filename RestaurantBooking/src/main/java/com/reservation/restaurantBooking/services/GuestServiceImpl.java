package com.reservation.restaurantBooking.services;

import com.reservation.restaurantBooking.entity.GuestEntity;
import com.reservation.restaurantBooking.exceptions.GuestNotFoundException;
import com.reservation.restaurantBooking.repository.GuestRepository;
import com.reservation.restaurantBooking.recordModels.GuestRecord;
import com.reservation.restaurantBooking.services.InterfacesForServices.GuestService;
import com.reservation.restaurantBooking.validation.GuestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * A service for managing guests.
 *
 */
@Service
public abstract class GuestServiceImpl implements GuestService {

    private static final Logger log = LoggerFactory.getLogger(GuestServiceImpl.class);

    private final GuestRepository guestRepository;
    private final GuestValidator guestValidator;

    /**

     Constructor to inject dependencies
     @param guestRepository the repository for guest entities
     @param guestValidator the validator for guest records
     */
    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository, GuestValidator guestValidator) {
        this.guestRepository = guestRepository;
        this.guestValidator = guestValidator;
    }
    /**

     Retrieves the guest record with the specified id
     @param id the id of the guest
     @return the guest record with the specified id
     @throws GuestNotFoundException if no guest entity exists with the specified id
     */
    @Override
    public GuestRecord getGuestById(Long id) throws GuestNotFoundException {
        log.info("Getting the guest by id");
        GuestEntity guestEntity = guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("GuestEntity", "id", String.valueOf(id)));
        return new GuestRecord((long) guestEntity.getId());
    }
    /**

     Retrieves all guest records
     @return a list of all guest records
     */
    @Override
    public List<GuestRecord> getAllGuests() {
        log.info("Getting all guests");
        return guestRepository.findAll().stream()
                .map(guestEntity -> new GuestRecord((long) guestEntity.getId()))
                .collect(Collectors.toList());
    }
    /**

     Creates a new guest record

     @param guestRecord the guest record to create

     @return the created guest record
     */
    @Override
    public GuestRecord createGuest(GuestRecord guestRecord) {
        log.info("Creating new guest");

        guestValidator.validateGuestRecord(guestRecord);
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setId(Math.toIntExact(guestRecord.id()));
        guestEntity = guestRepository.save(guestEntity);
        return new GuestRecord((long) guestEntity.getId());
    }

    /**

     Updates the guest record with the specified id
     @param id the id of the guest to update
     @param guestRecord the updated guest record
     @return the updated guest record
     @throws GuestNotFoundException if no guest entity exists with the specified id
     */
    @Override
    public GuestRecord updateGuest(Long id, GuestRecord guestRecord) throws GuestNotFoundException {
        log.info("Updating the guest");
        guestValidator.validateGuestRecord(guestRecord);
        GuestEntity guestEntity = guestRepository.findById(id)
                .orElseThrow(() -> new GuestNotFoundException("GuestEntity", "id", String.valueOf(id)));
        guestEntity.setId(Math.toIntExact(guestRecord.id()));
        guestEntity = guestRepository.save(guestEntity);
        return new GuestRecord((long) guestEntity.getId());
    }


    /**

     Deletes the guest record with the specified id
     @param id the id of the guest to delete
     */
    @Override
    public void deleteGuest(Long id) {
        log.info("Deleting the guest by id");
        guestRepository.deleteById(id);
    }
}