package com.reservation.restaurantBooking.services;

import com.reservation.restaurantBooking.entity.UserEntity;
import com.reservation.restaurantBooking.exceptions.UserNotFoundException;
import com.reservation.restaurantBooking.recordModels.UserRecord;
import com.reservation.restaurantBooking.repository.UserRepository;
import com.reservation.restaurantBooking.services.InterfacesForServices.UserService;
import com.reservation.restaurantBooking.validation.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**

 The UserServiceImpl class is responsible for providing various user-related services
 including creating, retrieving, updating and deleting user records, and finding a user by email.
 This class implements the UserService interface.
 */
@Service
public abstract class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserValidator userValidator;

    /**
     * Constructor to inject dependencies
     *
     * @param userRepository the repository for user entities
     * @param userValidator  the validator for user records
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    /**
     * Retrieves the user record with the specified id
     *
     * @param id the id of the user
     * @return the user record with the specified id
     * @throws UserNotFoundException if no user entity exists with the specified id
     */
    @Override
    @Transactional(readOnly = true)
    public UserRecord getUserById(Long id) throws UserNotFoundException {
        log.debug("Getting the user by id");
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
        return new UserRecord((long) userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

    /**
     * Retrieves all user records
     *
     * @return a list of all user records
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserRecord> getAllUsers() {
        log.debug("Getting all users");
        return userRepository.findAll().stream()
                .map(userEntity -> new UserRecord((long) userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword()))
                .collect(Collectors.toList());
    }

    /**
     * Creates a new user record
     *
     * @param userRecord the user record to create
     * @return the created user record
     */
    @Override
    @Transactional
    public UserRecord createUser(UserRecord userRecord) {
        log.debug("Creating new user");

        userValidator.validateUserRecord(userRecord);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Math.toIntExact(userRecord.id()));
        userEntity.setName(userRecord.name());
        userEntity.setEmail(userRecord.email());
        userEntity.setPassword(userRecord.password());
        userEntity = userRepository.save(userEntity);
        return new UserRecord((long) userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

    /**
     * Updates the user record with the specified id
     *
     * @param id         the id of the user to update
     * @param userRecord the updated user record
     * @return the updated user record
     * @throws UserNotFoundException if no user entity exists with the specified id
     */
    @Override
    @Transactional
    public UserRecord updateUser(Long id, UserRecord userRecord) throws UserNotFoundException {
        log.debug("Updating the user");
        userValidator.validateUserRecord(userRecord);
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.valueOf(id)));
        userEntity.setId(Math.toIntExact(userRecord.id()));
        userEntity.setName(userRecord.name());
        userEntity.setEmail(userRecord.email());
        userEntity.setPassword(userRecord.password());
        userEntity = userRepository.save(userEntity);
        return new UserRecord((long) userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

    /**
     * Deletes the user record with the specified id
     *
     * @param id the id of the user to delete
     */
    @Override
    @Transactional
    public void deleteUser(Long id) {
        log.debug("Deleting the guest by id");
        userRepository.deleteById(id);
    }


    /**
     * @param email email address of the user
     * @return the user found by his email
     */
    @Override
    @Transactional(readOnly = true)
    public UserRecord findByEmail(String email) {

        log.debug("Finding the guest by email");
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity == null) {
            return null;
        }

        return new UserRecord((long) userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
    }

}
