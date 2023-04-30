package com.reservation.restaurantBooking.controllers;

import com.reservation.restaurantBooking.exceptions.GuestNotFoundException;
import com.reservation.restaurantBooking.recordModels.GuestRecord;
import com.reservation.restaurantBooking.services.InterfacesForServices.GuestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;



/**

 Rest controller to handle guest requests
 */
@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;

    /**

     Constructor to inject guest service
     @param guestService guest service instance
     */
    @Autowired
    public GuestController(@Qualifier("guestServiceImpl") GuestService guestService) {
        this.guestService = guestService;
    }
    /**

     Get guest by id
     @param id guest id
     @return response entity with guest record
     @throws GuestNotFoundException if guest not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<GuestRecord> getGuestById(@PathVariable("id") Long id) throws GuestNotFoundException {
        GuestRecord guestRecord = guestService.getGuestById(id);
        return ResponseEntity.ok().body(guestRecord);
    }
    /**

     Get all guests
     @return response entity with list of guest records
     */
    @GetMapping("/")
    public ResponseEntity<List<GuestRecord>> getAllGuests() {
        List<GuestRecord> guestRecords = guestService.getAllGuests();
        return ResponseEntity.ok().body(guestRecords);
    }
    /**

     Create a guest
     @param guestRecord guest record to create
     @return response entity with created guest record
     */
    @PostMapping("/")
    public ResponseEntity<GuestRecord> createGuest(@RequestBody GuestRecord guestRecord) {
        GuestRecord createdGuestRecord = guestService.createGuest(guestRecord);
        return ResponseEntity.created(URI.create("/guests/" + createdGuestRecord.id())).body(createdGuestRecord);
    }
    /**

     Update a guest
     @param id guest id
     @param guestRecord guest record to update
     @return response entity with updated guest record
     @throws GuestNotFoundException if guest not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<GuestRecord> updateGuest(@PathVariable("id") Long id, @RequestBody GuestRecord guestRecord)
            throws GuestNotFoundException {
        GuestRecord updatedGuestRecord = guestService.updateGuest(id, guestRecord);
        return ResponseEntity.ok().body(updatedGuestRecord);
    }
    /**

     Delete a guest by id
     @param id guest id to delete
     @return response entity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable("id") Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}