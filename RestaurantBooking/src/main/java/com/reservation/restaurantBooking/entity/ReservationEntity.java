package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;


/**
 * This class represents a ReservationEntity, which is used to store information
 * about a reservation made by a guest or user in a restaurant.
 * It contains fields for the guest's name, date and time of the reservation, number of numberOfPeople,
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

    @NotBlank(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date")
    private LocalDate date;
    @Basic
    @Column(name = "time")
    private LocalTime time;
    @Basic
    @Column(name = "numberOfPeople")
    private int numberOfPeople;
    @Basic
    @Column(name = "confirmed")
    private Boolean confirmed;

    @NotNull(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "restaurantId")
    private int restaurantId;
    @OneToMany(mappedBy = "reservationByReservationId")
    private Collection<GuestreservationsEntity> guestreservationsById;
    @ManyToOne
    @JoinColumn(name = "restaurantId", referencedColumnName = "id", nullable = false)
    private RestaurantEntity restaurantByRestaurantId;
    @OneToMany(mappedBy = "reservationByReservationId")
    private Collection<UserreservationsEntity> userreservationsById;


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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
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

    public Collection<GuestreservationsEntity> getGuestreservationsById() {
        return guestreservationsById;
    }

    public void setGuestreservationsById(Collection<GuestreservationsEntity> guestreservationsById) {
        this.guestreservationsById = guestreservationsById;
    }

    public RestaurantEntity getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(RestaurantEntity restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Collection<UserreservationsEntity> getUserreservationsById() {
        return userreservationsById;
    }

    public void setUserreservationsById(Collection<UserreservationsEntity> userreservationsById) {
        this.userreservationsById = userreservationsById;
    }
}
