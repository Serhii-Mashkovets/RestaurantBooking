package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;



/**
 * This class represents a ReservationEntity, which is used to store information
 * about a reservation made by a guest or user in a restaurant.
 * It contains fields for the guest's name, date and time of the reservation, number of people,
 * and whether the reservation has been confirmed or not.
 * It also includes a field for the restaurant ID and a One-to-One relationship with the RestaurantEntity class.
 * Example usage:
 * ReservationEntity reservation = new ReservationEntity();
 * reservation.setId(1);
 * reservation.setName("John Smith");
 * reservation.setDate(Date.valueOf("2023-05-01"));
 * reservation.setTime(Time.valueOf("18:30:00"));
 * reservation.setNumberOfPeople(4);
 * reservation.setConfirmed(Byte.valueOf("1"));
 * reservation.setRestaurantId(2);
 * RestaurantEntity restaurant = new RestaurantEntity();
 * restaurant.setId(2);
 * reservation.setRestaurantByRestaurantId(restaurant);
 * // Save the reservation to the database
 * reservationRepository.save(reservation);
 */
@Entity
@Table(name = "reservation", schema = "restaurantbooking")
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Basic
    @Column(name = "date")
    private Date date;

    @DateTimeFormat(pattern = "HH:mm")
    @Basic
    @Column(name = "time")
    private Time time;
    @Basic
    @Column(name = "numberOfPeople")
    private int numberOfPeople;
    @Basic
    @Column(name = "confirmed")
    private Byte confirmed;
    @Basic
    @Column(name = "restaurantId")
    private int restaurantId;
    @OneToOne
    @JoinColumn(name = "restaurantId", referencedColumnName = "id", nullable = false)
    private RestaurantEntity restaurantByRestaurantId;


    public ReservationEntity(int id, String name, Date date, Time time, int numberOfPeople, Byte confirmed, int restaurantId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.numberOfPeople = numberOfPeople;
        this.confirmed = confirmed;
        this.restaurantId = restaurantId;
    }

    public ReservationEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Byte getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Byte confirmed) {
        this.confirmed = confirmed;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return id == that.id && numberOfPeople == that.numberOfPeople && restaurantId == that.restaurantId && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(confirmed, that.confirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, time, numberOfPeople, confirmed, restaurantId);
    }

    public RestaurantEntity getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(RestaurantEntity restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }
}
