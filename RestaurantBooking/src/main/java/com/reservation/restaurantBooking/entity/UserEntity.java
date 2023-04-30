package com.reservation.restaurantBooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Objects;


/**
 * UserEntity is a class that represents a user entity in the restaurant booking system.
 * It contains information about the user, such as their id, name, email, and password.
 * An instance of this class can be used to create, update, or retrieve user information in the database.
 * Example usage:
 * // Creating a new user entity
 * UserEntity user = new UserEntity();
 * user.setName("John Smith");
 * user.setEmail("john.smith@example.com");
 * user.setPassword("secret");
 * // Saving the user to the database
 * EntityManager em = EntityManagerFactory.createEntityManager();
 * em.getTransaction().begin();
 * em.persist(user);
 * em.getTransaction().commit();
 * // Retrieving a user from the database
 * UserEntity retrievedUser = em.find(UserEntity.class, 1);
 * // Updating a user's email address
 * retrievedUser.setEmail("new.email@example.com");
 * em.getTransaction().begin();
 * em.merge(retrievedUser);
 * em.getTransaction().commit();
 */
@Entity
@Table(name = "user", schema = "restaurantbooking")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Must be more than 2 characters")
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "userByUserId")
    private List<UserreservationsEntity> userreservationsById;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    public List<UserreservationsEntity> getUserreservationsById() {
        return userreservationsById;
    }

    public void setUserreservationsById(List<UserreservationsEntity> userreservationsById) {
        this.userreservationsById = userreservationsById;
    }
}
