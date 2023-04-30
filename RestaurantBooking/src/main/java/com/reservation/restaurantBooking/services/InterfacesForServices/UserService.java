package com.reservation.restaurantBooking.services.InterfacesForServices;

import com.reservation.restaurantBooking.recordModels.ReservationInfo;
import com.reservation.restaurantBooking.recordModels.UserRecord;

import java.util.List;

public interface UserService extends ReservationService {
    /**
     * Retrieves a single user by ID.
     *
     * @param id user identifier
     * @return user found
     */
    UserRecord getUserById(Long id);

    /**
     * Retrieves all users.
     *
     * @return all users
     */
    List<UserRecord> getAllUsers();

    /**
     * Creates and persists a {@link UserRecord} based on incoming {@link UserRecord}
     *
     * @param userRecord user information to create
     * @return the persisted user information
     */
    UserRecord createUser(UserRecord userRecord);

    /**
     * Updates a user entity.
     *
     * @param id         existing user's ID
     * @param userRecord {@link UserRecord}
     * @return updated user information
     */
    UserRecord updateUser(Long id, UserRecord userRecord);

    /**
     * Deletes a user by ID.
     *
     * @param id user identifier
     */
    void deleteUser(Long id);

    /**
     * Finds a user by email.
     *
     * @param email email address of the user
     * @return user found
     */
    UserRecord findByEmail(String email);


    /**
     * Retrieves all reservations for a specific user.
     *
     * @param userId user identifier
     * @return list of all reservations for the specified user
     */
    List<ReservationInfo> getAllReservationsByUserId(Long userId);
}

