package com.reservation.restaurantBooking.models;



/**
 * The Admin class represents an administrator for the restaurant booking system.
 * It contains the administrator's ID and password information for authentication purposes.
 * The class has two private fields, id and password, with their respective getter and setter methods.
 * The id field is of type Long and represents the unique identifier of the administrator.
 * The password field is of type String and represents the administrator's password for authentication.
 * The class also overrides the toString() method to return a string representation of the Admin object.
 * The returned string includes the id and password fields for easy debugging and logging purposes.
 * Example usage:
 * // create a new admin object
 * Admin admin = new Admin();
 * // set the admin's id and password
 * admin.setId(1L);
 * admin.setPassword("password123");
 * // retrieve the admin's id and password
 * Long id = admin.getId();
 * String password = admin.getPassword();
 * // print the admin object
 * System.out.println(admin.toString());
 *
 *
 *
 * Клас Admin представляє адміністратора системи бронювання ресторанів.
 * Він містить інформацію про ідентифікатор адміністратора та пароль для цілей автентифікації.
 * Клас має два приватні поля, id та password, з відповідними методами отримання та встановлення.
 * Поле id має тип Long і представляє унікальний ідентифікатор адміністратора.
 * Поле password має тип String і представляє пароль адміністратора для автентифікації.
 * Клас також перевизначає метод toString() для повернення рядкового представлення об'єкта Admin.
 * Рядок, що повертається, містить поля ідентифікатора і пароля для полегшення налагодження і ведення журналу.
 * Приклад використання:
 * // створити новий об'єкт admin
 * Admin admin = new Admin();
 * // встановити ідентифікатор та пароль адміністратора
 * admin.setId(1L);
 * admin.setPassword("password123");
 * // отримати ідентифікатор та пароль адміністратора
 * Рядок id = admin.getId();
 * Рядок password = admin.getPassword();
 * // вивести об'єкт admin
 * System.out.println(admin.toString());
 */
public class Admin {

    private Long id;

    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
