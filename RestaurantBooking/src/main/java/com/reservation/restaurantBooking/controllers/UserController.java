package com.reservation.restaurantBooking.controllers;

import com.reservation.restaurantBooking.recordModels.UserRecord;
import com.reservation.restaurantBooking.services.InterfacesForServices.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**

 Controller for managing users
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**

     Constructor for UserController
     @param userService the service for managing users
     */
    @Autowired
    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }
    /**

     Get all users
     @return a list of all users
     */
    @GetMapping
    public List<UserRecord> getAllUsers() {
        return userService.getAllUsers();
    }
    /**

     Create a new user
     @param userRecord the user to create
     @return the created user
     */
    @PostMapping
    public ResponseEntity<UserRecord> createUser(@Valid @RequestBody UserRecord userRecord) {
        UserRecord createdUser = userService.createUser(userRecord);
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId()))
                .body(createdUser);
    }
    /**

     Get a user by id
     @param id the id of the user to retrieve
     @return the user with the specified id
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserRecord> getUserById(@PathVariable Long id) {
        Optional<UserRecord> userRecord = Optional.ofNullable(userService.getUserById(id));
        if (userRecord.isPresent()) {
            return ResponseEntity.ok(userRecord.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**

     Update a user by id
     @param id the id of the user to update
     @param userRecord the updated user information
     @return the updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserRecord> updateUserById(@PathVariable Long id, @Valid @RequestBody UserRecord userRecord) {
        Optional<UserRecord> updatedUser = Optional.ofNullable(userService.updateUser(id, userRecord));
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**

     Delete a user by id
     @param id the id of the user to delete
     @return response entity indicating success or failure of the delete operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

