package com.reservation.restaurantBooking.models;

/**
 * The User class represents a user in the restaurant booking system.
 * It contains information about the user such as their unique identifier, name, email, and password.
 * The class has four private fields - id, name, email, and password - with their respective
 * getter and setter methods. The id field is of type Long and represents the unique identifier of the user.
 * The name field is of type String and represents the name of the user. The email field
 * is of type String and represents the email address of the user. The password field is of type String
 * and represents the password of the user.
 * The class has two constructors. The first constructor takes in a name and password and sets them to the
 * respective private fields. The second constructor takes in all of the user's fields and sets them to their
 * respective private fields.
 * Additionally, the class has a toString method that returns a string representation of the user.
 * The class is used to create and manage users in the restaurant booking system. It can be used to
 * associate reservations and bookings with users for reporting and analytics purposes.
 * Example usage:
 * // create a new user object
 * User user = new User(1L, "John Doe", "johndoe@example.com", "password");
 * // retrieve the user's information
 * Long id = user.getId();
 * String name = user.getName();
 * String email = user.getEmail();
 * String password = user.getPassword();
 * // update the user's information
 * user.setName("Jane Doe");
 * user.setEmail("janedoe@example.com");
 * user.setPassword("password");
 */
public class User {

    private Long id;
    private String name;

    private String email;

    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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
}
