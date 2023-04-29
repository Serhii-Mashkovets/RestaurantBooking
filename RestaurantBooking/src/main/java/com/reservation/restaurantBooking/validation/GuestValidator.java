package com.reservation.restaurantBooking.validation;

import com.reservation.restaurantBooking.exceptions.InvalidGuestRequestException;
import com.reservation.restaurantBooking.recordModels.GuestRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Component that helps to validate guest related requests.
 */
@Component
public class GuestValidator {

    private static final Logger log = LoggerFactory.getLogger(GuestValidator.class);

    /**
     * Asserts that a guest record is valid and has a valid id.
     *
     * @param guestRecord guest record to validate
     */
    public void validateGuestRecord(GuestRecord guestRecord) {
        log.debug("Validating guest record with id {}", guestRecord.id());

        if (guestRecord.id() == null || guestRecord.id() <= 0) {
            throw new InvalidGuestRequestException("id", String.valueOf(guestRecord.id()));
        }
    }
}
