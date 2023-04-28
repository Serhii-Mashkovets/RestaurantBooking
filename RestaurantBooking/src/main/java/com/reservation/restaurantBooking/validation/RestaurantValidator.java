package com.reservation.restaurantBooking.validation;

import com.reservation.restaurantBooking.exceptions.InvalidRestaurantRecordException;
import com.reservation.restaurantBooking.recordModels.RestaurantRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**

 Component that helps to validate restaurant related requests.
 */
@Component
public class RestaurantValidator {

    private static final Logger log = LoggerFactory.getLogger(RestaurantValidator.class);

    /**

     Validates the restaurant record and throws an exception if any fields are invalid.

     @param restaurant the restaurant record to validate

     @throws InvalidRestaurantRecordException if the record is invalid
     */
    public void validateRestaurantRecord(RestaurantRecord restaurant) throws InvalidRestaurantRecordException {
        log.info("Validating restaurant record...");

        if (restaurant == null) {
            throw new InvalidRestaurantRecordException("restaurant", "null");
        }

        if (restaurant.name() == null || restaurant.name().isBlank()) {
            throw new InvalidRestaurantRecordException("name", restaurant.name());
        }

        if (restaurant.cuisineType() == null) {
            throw new InvalidRestaurantRecordException("cuisineType", "null");
        }

        log.info("Restaurant record is valid.");
    }
}