package com.reservation.restaurantBooking.controllers;

import com.reservation.restaurantBooking.recordModels.RestaurantRecord;
import com.reservation.restaurantBooking.services.InterfacesForServices.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**

 REST controller for managing restaurants.
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    /**

     Constructs a new RestaurantController with the given RestaurantService.
     @param restaurantService the RestaurantService to be used
     */
    @Autowired
    public RestaurantController(@Qualifier("restaurantServiceImpl") RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    /**

     Retrieves all the restaurants in the system.
     @return a list of RestaurantRecords
     */
    @GetMapping
    public List<RestaurantRecord> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    /**

     Creates a new restaurant in the system.
     @param restaurantRecord the RestaurantRecord object to be created
     @return the created RestaurantRecord object wrapped in a ResponseEntity
     */
    @PostMapping
    public ResponseEntity<RestaurantRecord> createRestaurant(@Valid @RequestBody RestaurantRecord restaurantRecord) {
        RestaurantRecord createdRestaurant = restaurantService.createRestaurant(restaurantRecord);
        return ResponseEntity.created(URI.create("/restaurants/" + createdRestaurant.id()))
                .body(createdRestaurant);
    }
    /**

     Retrieves the restaurant with the given id.
     @param id the id of the restaurant to be retrieved
     @return the RestaurantRecord object with the given id wrapped in a ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantRecord> getRestaurantById(@PathVariable Long id) {
        Optional<RestaurantRecord> restaurantRecord = Optional.ofNullable(restaurantService.getRestaurantById(id));
        if (restaurantRecord.isPresent()) {
            return ResponseEntity.ok(restaurantRecord.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**

     Updates the restaurant with the given id.
     @param id the id of the restaurant to be updated
     @param restaurantRecord the updated RestaurantRecord object
     @return the updated RestaurantRecord object wrapped in a ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantRecord> updateRestaurantById(@PathVariable Long id, @Valid @RequestBody RestaurantRecord restaurantRecord) {
        Optional<RestaurantRecord> updatedRestaurant = Optional.ofNullable(restaurantService.updateRestaurant(id, restaurantRecord));
        if (updatedRestaurant.isPresent()) {
            return ResponseEntity.ok(updatedRestaurant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**

     Deletes the restaurant with the given id.

     @param id the id of the restaurant to be deleted

     @return a ResponseEntity indicating that the deletion was successful
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();

    }
}