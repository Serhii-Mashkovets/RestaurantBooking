package com.reservation.restaurantBooking.controllers;


import com.reservation.restaurantBooking.exceptions.*;
import com.reservation.restaurantBooking.recordModels.*;
import com.reservation.restaurantBooking.services.*;
import com.reservation.restaurantBooking.services.InterfacesForServices.*;
import com.reservation.restaurantBooking.validation.AdminValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


/**
 * This class serves as a REST controller for administrative functions, with the base URL /api/admin.
 * It handles HTTP requests for operations such as managing guests, users, reservations, and administrators.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminServiceImpl adminService;
    private final AdminValidator adminValidator;
    private final GuestServiceImpl guestService;

    private final UserService userService;

    private final RestaurantServiceImpl restaurantService;


    private final ReservationServiceImpl reservationService;


    /**
     * Constructor for AdminController class that initializes its dependencies.
     *
     * @param adminService       - The service that provides admin-related operations.
     * @param adminValidator     - The validator for admin-related input.
     * @param guestService       - The service that provides guest-related operations.
     * @param userService        - The service that provides user-related operations.
     * @param restaurantService  - The service that provides restaurant-related operations.
     * @param reservationService - The service that provides reservation-related operations.
     */
    @Autowired
    public AdminController(AdminServiceImpl adminService, AdminValidator adminValidator,
                           @Qualifier("GuestServiceImpl") GuestServiceImpl guestService,
                           @Qualifier("UserServiceImpl") UserServiceImpl userService,
                           @Qualifier("RestaurantServiceImpl") RestaurantServiceImpl restaurantService,
                           ReservationServiceImpl reservationService) {
        this.adminService = adminService;
        this.adminValidator = adminValidator;
        this.guestService = guestService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.reservationService = reservationService;
    }

    /**
     * Handles GET requests to the URL /api/admin/reservations.
     * Returns a list of ReservationInfo objects that satisfy the specified reservation query parameters.
     *
     * @param reservationQuery - The object containing the parameters used to filter reservations.
     * @return ResponseEntity<List < ReservationInfo>> - The list of reservations that satisfy the query parameters.
     */
    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationInfo>> getAllReservations(ReservationQuery reservationQuery) {
        List<ReservationInfo> reservations = reservationService.getReservations(reservationQuery);
        return ResponseEntity.ok().body(reservations);
    }


    /**
     * Handles GET requests to the URL /api/admin/reservations/{id}.
     * Returns the ReservationInfo object with the specified ID.
     *
     * @param id - The ID of the reservation to retrieve.
     * @return ResponseEntity<ReservationInfo> - The reservation with the specified ID.
     * @throws ReservationNotFoundException - If no reservation with the specified ID exists.
     */
    @GetMapping("/reservations/{id}")
    public ResponseEntity<ReservationInfo> getReservationById(@PathVariable Long id) throws ReservationNotFoundException {
        ReservationInfo reservation = reservationService.getById(id);
        return ResponseEntity.ok().body(reservation);
    }


    /**
     * Handles POST requests to the URL /api/admin/reservations.
     * Creates a new reservation with the specified ReservationRequest object.
     *
     * @param reservation - The object containing the details of the reservation to be created.
     * @return ResponseEntity<ReservationInfo> - The newly created reservation.
     */
    @PostMapping("/reservations")
    public ResponseEntity<ReservationInfo> createReservation(@RequestBody ReservationRequest reservation) {
        ReservationInfo createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.created(URI.create("/api/reservations/" + createdReservation.getId())).body(createdReservation);
    }


    /**
     * Handles PUT requests to the URL /api/admin/reservations/{id}.
     * Updates an existing reservation with the specified ID and UpdateReservationRequest object.
     *
     * @param id        - The ID of the reservation to be updated.
     * @param updateReq - The object containing the updated details of the reservation.
     * @return ResponseEntity<ReservationInfo> The updated reservation by admin.
     */
    @PutMapping("/reservations/{id}")
    public ResponseEntity<ReservationInfo> updateReservation(@PathVariable Long id, @RequestBody UpdateReservationRequest updateReq) throws ReservationNotFoundException {
        ReservationInfo updatedReservation = reservationService.updateReservation(id, updateReq);
        return ResponseEntity.ok().body(updatedReservation);
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/guests/{id}")
    public ResponseEntity<GuestRecord> getGuestById(@PathVariable("id") Long id) throws GuestNotFoundException {
        GuestRecord guestRecord = guestService.getGuestById(id);
        return ResponseEntity.ok().body(guestRecord);
    }

    @GetMapping("/guests")
    public ResponseEntity<List<GuestRecord>> getAllGuests() {
        List<GuestRecord> guestRecords = guestService.getAllGuests();
        return ResponseEntity.ok().body(guestRecords);
    }

    @PostMapping("/guests")
    public ResponseEntity<GuestRecord> createGuest(@RequestBody GuestRecord guestRecord) {
        GuestRecord createdGuestRecord = guestService.createGuest(guestRecord);
        return ResponseEntity.created(URI.create("/api/admin/guests/" + createdGuestRecord.id())).body(createdGuestRecord);
    }

    @PutMapping("/guests/{id}")
    public ResponseEntity<GuestRecord> updateGuest(@PathVariable("id") Long id, @RequestBody GuestRecord guestRecord)
            throws GuestNotFoundException {
        GuestRecord updatedGuestRecord = guestService.updateGuest(id, guestRecord);
        return ResponseEntity.ok().body(updatedGuestRecord);
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable("id") Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdminRecord>> getAllAdmins() {
        List<AdminRecord> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminRecord> getAdminById(@PathVariable Long id) {
        AdminRecord admin = adminService.getAdminById(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AdminRecord> createAdmin(@Validated @RequestBody AdminRecord adminRecord) {
        AdminRecord createdAdmin = adminService.createAdmin(adminRecord);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminRecord> updateAdmin(@PathVariable Long id, @Validated @RequestBody AdminRecord adminRecord)
            throws AdminNotFoundException {
        AdminRecord updatedAdmin = adminService.updateAdmin(id, adminRecord);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserRecord>> getAllUsers() {
        List<UserRecord> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserRecord> createUser(@Validated @RequestBody UserRecord userRecord) {
        UserRecord createdUser = userService.createUser(userRecord);
        return ResponseEntity.created(URI.create("/api/admin/users/" + createdUser.getId())).body(createdUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserRecord> getUserById(@PathVariable Long id) {
        UserRecord user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserRecord> updateUser(@PathVariable Long id, @Validated @RequestBody UserRecord userRecord)
            throws UserNotFoundException {
        UserRecord updatedUser = userService.updateUser(id, userRecord);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantRecord>> getAllRestaurants() {
        List<RestaurantRecord> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<RestaurantRecord> createRestaurant(@Validated @RequestBody RestaurantRecord restaurantRecord) {
        RestaurantRecord createdRestaurant = restaurantService.createRestaurant(restaurantRecord);
        return ResponseEntity.created(URI.create("/restaurants/" + createdRestaurant.id()))
                .body(createdRestaurant);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<RestaurantRecord> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantRecord restaurantRecord)
            throws RestaurantNotFoundException {
        RestaurantRecord updatedRestaurant = restaurantService.updateRestaurant(id, restaurantRecord);
        return ResponseEntity.ok().body(updatedRestaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

}
