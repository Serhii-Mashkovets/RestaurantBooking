package com.reservation.restaurantBooking.services;

import com.reservation.restaurantBooking.entity.AdminEntity;
import com.reservation.restaurantBooking.exceptions.AdminNotFoundException;
import com.reservation.restaurantBooking.recordModels.*;
import com.reservation.restaurantBooking.repository.AdminRepository;
import com.reservation.restaurantBooking.services.InterfacesForServices.AdminService;
import com.reservation.restaurantBooking.validation.AdminValidator;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**

 The AdminServiceImpl class is responsible for implementing the AdminService interface
 and providing the functionalities for managing admin records.
 */
@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    private AdminRepository adminRepository;
    private  AdminValidator adminValidator;



    public AdminServiceImpl () {}

    /**
     * Constructor for the AdminServiceImpl class.
     *
     * @param adminRepository the repository for accessing admin records
     * @param adminValidator the validator for validating admin requests
     */
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, AdminValidator adminValidator) {
        this.adminRepository = adminRepository;
        this.adminValidator = adminValidator;
    }


    /**
     * Retrieves an admin record by its ID.
     *
     * @param id the ID of the admin to retrieve
     * @return the admin record
     * @throws AdminNotFoundException if no admin with the given ID is found
     */
    @Override
    @Transactional(readOnly = true)
    public AdminRecord getAdminById(Long id) throws AdminNotFoundException {
        log.debug("Getting the admin by id");
        AdminEntity adminEntity = adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException( String.valueOf(id)));
        return new AdminRecord((long) adminEntity.getId(), adminEntity.getPassword());
    }


    /**
     * Retrieves all admin records.
     *
     * @return a list of all admin records
     */
    @Override
    @Transactional(readOnly = true)
    public List<AdminRecord> getAllAdmins() {
        log.debug("Getting all admins");
        return adminRepository.findAll().stream()
                .map(adminEntity -> new AdminRecord((long) adminEntity.getId(), adminEntity.getPassword()))
                .collect(Collectors.toList());
    }


    /**
     * Creates a new admin record.
     *
     * @param adminRecord the admin record to create
     * @return the newly created admin record
     */
    @Override
    @Transactional
    public AdminRecord createAdmin(AdminRecord adminRecord) {
        log.debug("Creating new admin");

        adminValidator.validateAdminRequest(adminRecord);
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(Math.toIntExact(adminRecord.id()));
        adminEntity = adminRepository.save(adminEntity);
        return new AdminRecord((long) adminEntity.getId(), adminEntity.getPassword());
    }


    /**
     * Updates an existing admin record.
     *
     * @param id the ID of the admin record to update
     * @param adminRecord the new admin record data
     * @return the updated admin record
     * @throws AdminNotFoundException if no admin with the given ID is found
     */
    @Override
    @Transactional
    public AdminRecord updateAdmin(Long id, AdminRecord adminRecord) throws AdminNotFoundException {
        log.debug("Updating the admin");
        adminValidator.validateAdminRequest(adminRecord);
        AdminEntity adminEntity = adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException( String.valueOf(id)));
        adminEntity.setId(Math.toIntExact(adminRecord.id()));
        adminEntity = adminRepository.save(adminEntity);
        return new AdminRecord((long) adminEntity.getId(), adminEntity.getPassword());
    }


    /**
     * Deletes an admin record by its ID.
     * @param id admin identifier
     */
    @Override
    @Transactional
    public void deleteAdmin(Long id) {
        log.debug("Deleting the admin by id");
        adminRepository.deleteById(id);
    }


    @Override
    public GuestRecord getGuestById(Long id) {
        return null;
    }

    @Override
    public List<GuestRecord> getAllGuests() {
        return null;
    }

    @Override
    public GuestRecord createGuest(GuestRecord guestRecord) {
        return null;
    }

    @Override
    public GuestRecord updateGuest(Long id, GuestRecord guestRecord) {
        return null;
    }

    @Override
    public void deleteGuest(Long id) {

    }

    @Override
    public ReservationInfo createReservation(ReservationRequest request) {
        return null;
    }

    @Override
    public List<ReservationInfo> getReservations(ReservationQuery query) {
        return null;
    }

    @Override
    public ReservationInfo getById(Long reservationId) {
        return null;
    }

    @Override
    public void deleteById(Long reservationId) {

    }

    @Override
    public ReservationInfo updateReservation(Long reservationId, UpdateReservationRequest editRequest) {
        return null;
    }

    @Override
    public RestaurantRecord getRestaurantById(Long id) {
        return null;
    }

    @Override
    public List<RestaurantRecord> getAllRestaurants() {
        return null;
    }

    @Override
    public RestaurantRecord createRestaurant(RestaurantRecord restaurantRecord) {
        return null;
    }

    @Override
    public RestaurantRecord updateRestaurant(Long id, RestaurantRecord restaurantRecord) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long id) {

    }

    @Override
    public UserRecord getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserRecord> getAllUsers() {
        return null;
    }

    @Override
    public UserRecord createUser(UserRecord userRecord) {
        return null;
    }

    @Override
    public UserRecord updateUser(Long id, UserRecord userRecord) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserRecord findByEmail(String email) {
        return null;
    }

    @Override
    public List<ReservationInfo> getAllReservationsByUserId(Long userId) {
        return null;
    }
}
