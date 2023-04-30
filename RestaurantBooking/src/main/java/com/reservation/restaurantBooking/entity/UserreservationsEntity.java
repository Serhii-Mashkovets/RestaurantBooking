package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;

import java.util.Objects;


/**
 * UserreservationsEntity is a class that represents a user's reservation entity in the restaurant booking system.
 * It contains information about the user's reservation, such as their user id and reservation id.
 * An instance of this class can be used to create, update, or retrieve user's reservation information in the database.
 * Example usage:
 * // Creating a new user reservation entity
 * UserreservationsEntity userReservation = new UserreservationsEntity();
 * userReservation.setUserId(1);
 * userReservation.setReservationId(1);
 * // Saving the user reservation to the database
 * EntityManager em = EntityManagerFactory.createEntityManager();
 * em.getTransaction().begin();
 * em.persist(userReservation);
 * em.getTransaction().commit();
 * // Retrieving a user's reservation from the database
 * UserreservationsEntity retrievedUserReservation = em.find(UserreservationsEntity.class, 1);
 * // Updating a user's reservation
 * retrievedUserReservation.setReservationId(2);
 * em.getTransaction().begin();
 * em.merge(retrievedUserReservation);
 * em.getTransaction().commit();
 */
@Entity
@Table(name = "userreservations", schema = "restaurantbooking")
public class UserreservationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userID")
    private int userId;
    @Basic
    @Column(name = "reservationID")
    private int reservationId;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "reservationID", referencedColumnName = "id", nullable = false)
    private ReservationEntity reservationByReservationId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserreservationsEntity that = (UserreservationsEntity) o;
        return userId == that.userId && reservationId == that.reservationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, reservationId);
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public ReservationEntity getReservationByReservationId() {
        return reservationByReservationId;
    }

    public void setReservationByReservationId(ReservationEntity reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
    }
}
