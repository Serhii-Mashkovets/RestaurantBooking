package com.reservation.restaurantBooking.recordModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Represents a request for changing reservation details.
 */
public record UpdateReservationRequest(
        String name,
        LocalDate date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") LocalTime time,
        Integer numberOfPeople,
        Boolean confirmed,
        Long restaurantId
) {
    public UpdateReservationRequest(String name, LocalDate date, LocalTime time, Integer numberOfPeople, Boolean confirmed,
                                    Long restaurantId) {
        this.name = name;
        this.date = date;
        this.time = time == null ? null : time.truncatedTo(ChronoUnit.MINUTES);
        this.numberOfPeople = numberOfPeople;
        this.confirmed = confirmed;
        this.restaurantId = restaurantId;
    }

    /**
     * @return whether all properties are equal to {@code null}.
     */
    @JsonIgnore
    public boolean isEmpty() {
        return name == null &&
                date == null &&
                time == null &&
                numberOfPeople == null &&
                confirmed == null &&
                restaurantId == null;
    }
}
