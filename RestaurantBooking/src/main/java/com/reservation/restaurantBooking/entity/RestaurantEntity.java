package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;

import java.util.Objects;



/**
 * This class represents a Restaurant Entity and maps to a table named "restaurant" in the "restaurantbooking" schema.
 * It contains information about the restaurant such as its id, name, and cuisine type.
 * This class is also used to establish a one-to-one relationship with the ReservationEntity class.
 * Example Usage:
 * RestaurantEntity restaurant = new RestaurantEntity();
 * restaurant.setId(1);
 * restaurant.setName("La Piazza");
 * restaurant.setCuisineType("Italian");
 * ReservationEntity reservation = new ReservationEntity();
 * reservation.setId(1);
 * reservation.setName("John Smith");
 * reservation.setDate(new Date(System.currentTimeMillis()));
 * reservation.setTime(new Time(System.currentTimeMillis()));
 * reservation.setNumberOfPeople(4);
 * reservation.setConfirmed(Byte.valueOf("1"));
 * reservation.setRestaurantId(restaurant.getId());
 * reservation.setRestaurantByRestaurantId(restaurant);
 */
@Entity
@Table(name = "restaurant", schema = "restaurantbooking")
public class RestaurantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "cuisineType")
    private Object cuisineType;
    @OneToOne(mappedBy = "restaurantByRestaurantId")
    private ReservationEntity reservationsById;

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

    public Object getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(Object cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantEntity that = (RestaurantEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(cuisineType, that.cuisineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cuisineType);
    }

    public ReservationEntity getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(ReservationEntity reservationsById) {
        this.reservationsById = reservationsById;
    }
}
