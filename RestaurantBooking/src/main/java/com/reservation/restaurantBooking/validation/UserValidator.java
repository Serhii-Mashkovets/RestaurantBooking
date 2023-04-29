package com.reservation.restaurantBooking.validation;


import com.reservation.restaurantBooking.exceptions.InvalidUserRequestException;
import com.reservation.restaurantBooking.recordModels.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Component that helps to validate user related requests.
 */
@Component
public class UserValidator {

    private static final Logger log = LoggerFactory.getLogger(GuestValidator.class);

    /**
     * Validates the user record and throws an exception if any fields are invalid.
     *
     * @param user the user record to validate
     * @throws InvalidUserRequestException if the record is invalid
     */
    public void validateUserRecord(UserRecord user) throws InvalidUserRequestException {
        log.debug("Validating user record...");

        if (user == null) {
            throw new InvalidUserRequestException("User record cannot be null.", "null");
        }

        if (user.name() == null || user.name().isBlank()) {
            throw new InvalidUserRequestException("User name cannot be null or blank.", user.name());
        }

        if (user.email() == null || user.email().isBlank()) {
            throw new InvalidUserRequestException("User email cannot be null or blank.", user.email());
        }

        if (user.password() == null || user.password().isBlank()) {
            throw new InvalidUserRequestException("User password cannot be null or blank.", user.password());
        }

        log.debug("User record is valid.");
    }
}
