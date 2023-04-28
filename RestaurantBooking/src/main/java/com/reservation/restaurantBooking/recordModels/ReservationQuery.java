package com.reservation.restaurantBooking.recordModels;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Represents a query for {@link  ReservationInfo}s.
 */
public record ReservationQuery(
        Long id,
        String name,
        LocalDate date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") LocalTime time,

        int numberOfPeople,
        Boolean confirmed,
        Long restaurantId
) {
    public ReservationQuery(Long id, String name, LocalDate date, LocalTime time,int numberOfPeople,
                            Boolean confirmed, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time == null ? null : time.truncatedTo(ChronoUnit.MINUTES);
        this.numberOfPeople = numberOfPeople;
        this.confirmed = confirmed;
        this.restaurantId = restaurantId;
    }
}
