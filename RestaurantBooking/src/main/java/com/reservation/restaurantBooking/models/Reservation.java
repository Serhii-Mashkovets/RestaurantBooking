package com.reservation.restaurantBooking.models;

import java.time.LocalDate;
import java.time.LocalTime;



/**
 * The Reservation class represents a reservation made by a guest or user in the restaurant booking system.
 * It contains information about the reservation such as the name of the person making the reservation,
 * the date and time of the reservation, the number of numberOfPeople, and whether or not the reservation has been confirmed.
 * The class has six private fields - id, name, date, time, numberOfPeople, and confirmed - with their respective
 * getter and setter methods. The id field is of type Long and represents the unique identifier of the reservation.
 * The name field is of type String and represents the name of the person making the reservation. The date field
 * is of type LocalDate and represents the date of the reservation. The time field is of type LocalTime and
 * represents the time of the reservation. The numberOfPeople field is of type Integer and represents the
 * number of numberOfPeople in the reservation. The confirmed field is of type boolean and represents whether or not
 * the reservation has been confirmed.
 * The class also has a constructor that takes in all of the reservation's fields and sets them to their respective
 * private fields. Additionally, it has a toString method that returns a string representation of the reservation.
 * The class is used to create and manage reservations in the restaurant booking system. It can be used to
 * associate reservations with guests and restaurants for reporting and analytics purposes.
 * Example usage:
 * // create a new reservation object
 * Reservation reservation = new Reservation(1L, "John Doe", LocalDate.now(), LocalTime.of(19, 30), 4, true);
 * // retrieve the reservation's information
 * String name = reservation.getName();
 * LocalDate date = reservation.getDate();
 * LocalTime time = reservation.getTime();
 * Integer numberOfPeople = reservation.getNumberOfPeople();
 * boolean confirmed = reservation.isConfirmed();
 * // update the reservation's information
 * reservation.setNumberOfPeople(4);
 * reservation.setConfirmed(true);
 */
public class Reservation {

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private Integer numberOfPeople;
    private boolean confirmed;
    private Long restaurantId;

    public Reservation(Long id, String name, LocalDate date, LocalTime time, Integer numberOfPeople, boolean confirmed, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.numberOfPeople = numberOfPeople;
        this.confirmed = confirmed;
        this.restaurantId = restaurantId;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", numberOfPeople=" + numberOfPeople +
                ", confirmed=" + confirmed +
                ", restaurantId=" + restaurantId +
                '}';
    }
}

