package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


/**
 * The GuestEntity class represents an entity in the database that corresponds to the "guest" table.
 * It contains a property that represents the "id" column of the table, along with getter and setter methods for that property.
 * The class also overrides the equals() and hashCode() methods
 * to provide a way to compare instances of the class based on their id property.
 * Example usage:
 * GuestEntity guest = new GuestEntity();
 * guest.setId(1);
 * // Use the entity manager to persist the entity to the database
 * EntityManager entityManager = ...;
 * EntityTransaction transaction = entityManager.getTransaction();
 * transaction.begin();
 * entityManager.persist(guest);
 * transaction.commit();
 * // Use the entity manager to retrieve the entity from the database
 * int guestId = 1;
 * GuestEntity retrievedGuest = entityManager.find(GuestEntity.class, guestId);
 */
@Entity
@Table(name = "guest", schema = "restaurantbooking")
public class GuestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToMany(mappedBy = "guestByGuestId")
    private List<GuestreservationsEntity> guestreservationsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestEntity that = (GuestEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<GuestreservationsEntity> getGuestreservationsById() {
        return guestreservationsById;
    }

    public void setGuestreservationsById(List<GuestreservationsEntity> guestreservationsById) {
        this.guestreservationsById = guestreservationsById;
    }
}
