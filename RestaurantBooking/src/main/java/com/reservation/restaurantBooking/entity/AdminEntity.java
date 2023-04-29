package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;


/**
 * The AdminEntity class represents an entity in the database that corresponds to the "admin" table.
 * It contains properties that represent the columns of the table, along with getter and setter methods for those properties.
 * The class also overrides the equals() and hashCode() methods
 * to provide a way to compare instances of the class based on their properties.
 * Example usage:
 * AdminEntity admin = new AdminEntity();
 * admin.setId(1);
 * admin.setPassword("password123");
 * // Use the entity manager to persist the entity to the database
 * EntityManager entityManager = ...;
 * EntityTransaction transaction = entityManager.getTransaction();
 * transaction.begin();
 * entityManager.persist(admin);
 * transaction.commit();
 * // Use the entity manager to retrieve the entity from the database
 * int adminId = 1;
 * AdminEntity retrievedAdmin = entityManager.find(AdminEntity.class, adminId);
 */

@Entity
@Table(name = "admin", schema = "restaurantbooking")
public class AdminEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;


    @NotBlank(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return id == that.id && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password);
    }
}
