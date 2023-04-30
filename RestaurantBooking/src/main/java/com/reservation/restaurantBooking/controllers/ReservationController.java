package com.reservation.restaurantBooking.controllers;


import com.reservation.restaurantBooking.recordModels.ReservationInfo;
import com.reservation.restaurantBooking.recordModels.ReservationQuery;
import com.reservation.restaurantBooking.recordModels.ReservationRequest;
import com.reservation.restaurantBooking.recordModels.UpdateReservationRequest;
import com.reservation.restaurantBooking.services.InterfacesForServices.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


import static com.reservation.restaurantBooking.apiConstant.ApiConstants.RESERVATIONS;
import static com.reservation.restaurantBooking.apiConstant.ApiConstants.RESERVATION_BY_ID;
import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Defines REST APIs request handlers for managing {@link ReservationInfo}s.
 */
@RestController
public class ReservationController {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private ReservationService reservationService;

    @Operation(summary = "Query for reservations.",
            description = "Retrieves all persisted reservations. Optionally search for reservations matching by name, date and time.")
    @RequestMapping(method = GET, path = RESERVATIONS)
    public ResponseEntity<List<ReservationInfo>> getReservations(
            @RequestParam Optional<Long> id,
            @RequestParam Optional<String> name,
            @RequestParam Optional<LocalDate> date,
            @RequestParam Optional<LocalTime> time,
            @RequestParam Optional<Integer> numberOfPeople,
            @RequestParam Optional<Boolean> confirmed,
            @RequestParam Optional<Long> restaurantId) {
        ReservationQuery query = new ReservationQuery(id.orElse(null), name.orElse(null),
                date.orElse(null), time.orElse(null),  numberOfPeople.orElse(null),
                confirmed.orElse(null), restaurantId.orElse(null));

        List<ReservationInfo> reservations = reservationService.getReservations(query);

        return ResponseEntity.ok(reservations);
    }

    @Operation(summary = "Request new reservation to be created.",
            description = "The newly created resource URI location will be returned in 'Location' header.")
    @RequestMapping(method = POST, path = RESERVATIONS)
    public ResponseEntity<ReservationInfo> createReservation(@NotNull @RequestBody ReservationRequest request) {
        ReservationInfo reservation = reservationService.createReservation(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{reservation-id}")
                .buildAndExpand(reservation.id())
                .toUri();

        return ResponseEntity.created(location).body(reservation);
    }

    @Operation(summary = "Retrieve existing reservation details by reservation ID.")
    @RequestMapping(method = GET, path = RESERVATION_BY_ID)
    public ResponseEntity<ReservationInfo> getReservationById(@PathVariable Long reservationId) {
        ReservationInfo reservation = reservationService.getById(reservationId);
        return ResponseEntity.ok(reservation);
    }

    @Operation(summary = "Update existing reservation details.",
            description = "Only non-null values will be taken into account when updating the reservation model")
    @RequestMapping(method = PUT, path = RESERVATION_BY_ID)
    public ResponseEntity<ReservationInfo> updateReservation(@PathVariable Long reservationId,
                                                             @RequestBody UpdateReservationRequest request) {
        ReservationInfo edited = reservationService.updateReservation(reservationId, request);
        return ResponseEntity.ok(edited);
    }

    @Operation(summary = "Deletes a reservation by ID.")
    @RequestMapping(method = DELETE, path = RESERVATION_BY_ID)
    public ResponseEntity<Void> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteById(reservationId);
        return ResponseEntity.noContent().build();
    }
}

