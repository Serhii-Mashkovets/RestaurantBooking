package com.reservation.restaurantBooking.validation;


import com.reservation.restaurantBooking.exceptions.InvalidAdminRequestException;
import com.reservation.restaurantBooking.recordModels.AdminRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Component that helps to validate admin related requests.
 */
@Component
public class AdminValidator {

    private static final Logger log = LoggerFactory.getLogger(AdminValidator.class);

    /**
     * Asserts that an admin request is valid and has valid properties.
     *
     * @param request admin request to validate
     */
    public void validateAdminRequest(AdminRecord request) {
        log.debug("Getting started in a class AdminValidator in a method validateAdminRequest");

        if (request.id() == null || request.id() <= 0) {
            throw new InvalidAdminRequestException("id", String.valueOf(request.id()));
        }

        if (request.password() == null || request.password().isBlank()) {
            throw new InvalidAdminRequestException("password", request.password());
        }
    }
}
