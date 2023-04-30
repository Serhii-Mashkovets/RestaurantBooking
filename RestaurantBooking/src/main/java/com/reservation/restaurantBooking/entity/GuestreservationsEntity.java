package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;

import java.util.Objects;


/**
 * The GuestreservationsEntity class represents an entity in the database that corresponds to the "guestreservations" table.
 * It contains properties that represent the "guestID" and "reservationID" columns of the table,
 * along with getter and setter methods for those properties.
 * The class also includes two properties of type GuestEntity and ReservationEntity,
 * representing the entities that are referenced by the foreign keys in the "guestreservations" table.
 * Example usage:
 * GuestreservationsEntity guestReservation = new GuestreservationsEntity();
 * guestReservation.setGuestId(1);
 * guestReservation.setReservationId(2);
 * GuestEntity guest = new GuestEntity();
 * ReservationEntity reservation = new ReservationEntity();
 * // Set the properties of guest and reservation
 * guestReservation.setGuestByGuestId(guest);
 * guestReservation.setReservationByReservationId(reservation);
 * // Use the entity manager to persist the entity to the database
 * EntityManager entityManager = ...;
 * EntityTransaction transaction = entityManager.getTransaction();
 * transaction.begin();
 * entityManager.persist(guestReservation);
 * transaction.commit();
 * // Use the entity manager to retrieve the entity from the database
 * int guestReservationId = 1;
 * GuestreservationsEntity retrievedGuestReservation = entityManager.find(GuestreservationsEntity.class, guestReservationId);
 */
@Entity
@Table(name = "guestreservations", schema = "restaurantbooking")
public class GuestreservationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "guestID")
    private int guestId;
    @Basic
    @Column(name = "reservationID")
    private int reservationId;
    @ManyToOne
    @JoinColumn(name = "guestID", referencedColumnName = "id", nullable = false)
    private GuestEntity guestByGuestId;
    @ManyToOne
    @JoinColumn(name = "reservationID", referencedColumnName = "id", nullable = false)
    private ReservationEntity reservationByReservationId;

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
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
        GuestreservationsEntity that = (GuestreservationsEntity) o;
        return guestId == that.guestId && reservationId == that.reservationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId, reservationId);
    }

    public GuestEntity getGuestByGuestId() {
        return guestByGuestId;
    }

    public void setGuestByGuestId(GuestEntity guestByGuestId) {
        this.guestByGuestId = guestByGuestId;
    }

    public ReservationEntity getReservationByReservationId() {
        return reservationByReservationId;
    }

    public void setReservationByReservationId(ReservationEntity reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
    }
}
