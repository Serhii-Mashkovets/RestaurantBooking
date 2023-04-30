package com.reservation.restaurantBooking.recordModels;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Restaurant reservation representation.
 *
 * @param id     unique identifier
 * @param name   reservation name
 * @param date   date for the reservation
 * @param time   time for the reservation
 * @param numberOfPeople number of People
 * @param confirmed is booking confirmed
 * @param restaurantId unique restaurant identifier
 */
public record ReservationInfo(
        int id,
        String name,
        LocalDate date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm") LocalTime time,
        Integer numberOfPeople,
        Boolean confirmed,
        int restaurantId
) {
    public ReservationInfo(int id, String name, LocalDate date, LocalTime time, Integer numberOfPeople, Boolean confirmed,
                           int restaurantId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time == null ? null : time.truncatedTo(ChronoUnit.MINUTES);
        this.numberOfPeople = numberOfPeople;
        this.confirmed = confirmed;
        this.restaurantId = restaurantId;
    }

    public int getId() {
        return  id;
    }
}

