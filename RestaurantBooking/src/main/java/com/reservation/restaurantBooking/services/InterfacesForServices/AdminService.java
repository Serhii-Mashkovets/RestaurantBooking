package com.reservation.restaurantBooking.services.InterfacesForServices;

import com.reservation.restaurantBooking.recordModels.AdminRecord;

import java.util.List;


/**
 * We use multiple service inheritance because Admin has the most functionality.
 * So, to reduce the amount of code, we used this solution here.
 */

public interface AdminService extends GuestService, UserService, ReservationService, RestaurantService {
    /**
     * Retrieves a single admin by ID.
     *
     * @param id admin identifier
     * @return admin found
     */
    AdminRecord getAdminById(Long id);

    /**
     * Retrieves all admins.
     *
     * @return all admins
     */
    List<AdminRecord> getAllAdmins();

    /**
     * Creates and persists a {@link AdminRecord} based on incoming {@link AdminRecord}
     *
     * @param adminRecord admin information to create
     * @return the persisted admin information
     */
    AdminRecord createAdmin(AdminRecord adminRecord);

    /**
     * Updates an admin entity.
     *
     * @param id           existing admin's ID
     * @param adminRecord {@link AdminRecord}
     * @return updated admin information
     */
    AdminRecord updateAdmin(Long id, AdminRecord adminRecord);

    /**
     * Deletes an admin by ID.
     *
     * @param id admin identifier
     */
    void deleteAdmin(Long id);
}
