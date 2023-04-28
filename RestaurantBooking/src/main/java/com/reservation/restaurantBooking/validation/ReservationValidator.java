package com.reservation.restaurantBooking.validation;



import com.reservation.restaurantBooking.exceptions.InvalidReservationRequestException;
import com.reservation.restaurantBooking.recordModels.ReservationInfo;
import com.reservation.restaurantBooking.recordModels.ReservationRequest;
import com.reservation.restaurantBooking.recordModels.UpdateReservationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Component that helps to validate reservation related requests.
 *
 *
 */
@Component
public class ReservationValidator {

    private static final Logger log = LoggerFactory.getLogger(ReservationValidator.class);

    /**
     * Asserts that a reservation request is valid and has valid properties.
     *
     * @param request request to validate
     */
    public void validateReservationRequest(ReservationRequest request) {
        log.info("Getting started in a class ReservationValidator in a method validateReservationRequest");
        // Creating reservation in the past is not allowed:
        if (request.date() == null || request.date().isBefore(LocalDate.now())) {
            throw new InvalidReservationRequestException("date", String.valueOf(request.date()));
        }

        if (request.name() == null || request.name().isBlank()) {
            throw new InvalidReservationRequestException("name", request.name());
        }

        if (request.numberOfPeople() == null || request.numberOfPeople() <= 0) {
            throw new InvalidReservationRequestException("Number of people ", String.valueOf(request.numberOfPeople()));
        }
    }

    /**
     * Validates whether the reservation update request is valid and
     * can be proceeded to update the existing reservation info.
     *
     * @param editRequest data to update the existing reservation info
     * @param edited      the existing reservation to update
     */
    public void validateUpdateRequest(UpdateReservationRequest editRequest, ReservationInfo edited) {
        log.info("Getting started in a class ReservationValidator in a method validateUpdateRequest");
        if (editRequest == null || edited == null) {
            throw new InvalidReservationRequestException("update request", "either update request or reservation info is null");
        }

        // Check if the name is present and not empty:
        if (editRequest.name() == null || editRequest.name().isBlank()) {
            throw new InvalidReservationRequestException("name", editRequest.name());
        }

        // Check if the date is present and not in the past:
        if (editRequest.date() == null || editRequest.date().isBefore(LocalDate.now())) {
            throw new InvalidReservationRequestException("date", String.valueOf(editRequest.date()));
        }

        // Check if the time is present and in the future:
        if (editRequest.time() != null) {
            LocalTime now = LocalTime.now();
            if (editRequest.date().isEqual(LocalDate.now()) && editRequest.time().isBefore(now)) {
                throw new InvalidReservationRequestException("time", editRequest.time().toString());
            }
        }

        // Check if the number of people is present and greater than zero:
        if (editRequest.numberOfPeople() == null || editRequest.numberOfPeople() <= 0) {
            throw new InvalidReservationRequestException("number of people", String.valueOf(editRequest.numberOfPeople()));
        }

        // Check if the restaurant id is present:
        if (editRequest.restaurantId() == null) {
            throw new InvalidReservationRequestException("restaurant id", String.valueOf(editRequest.restaurantId()));
        }
    }


}
