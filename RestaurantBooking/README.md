# RestaurantBooking

This is a web application for booking tables at restaurants. It was developed as a final project by Serhii Mashkovets.


## Features
✨
- Admin can add/delete/edit information about restaurants available for booking.
- User can select a restaurant, date, time of visit, number of people, and request a table reservation.
- After selecting a table, the user can confirm the reservation and make an online payment.
- The user can view the booking history.

✨

## Technologies Used

The application is written in Java, using the following technologies:

- Java 17
- Spring, including Spring Boot (Data JPA, Security, Web, Validation)
- Hibernate
- Maven
- MySQL
- HTML
- CSS
- JavaScript
- JUnit 5 and JaCoCo
- OpenAPI 3 and SwaggerUI (OpenAPI UI)

## How can you use the app?

```sh
Use the Git version control system.
1. Create a folder on your computer where you want to store the application;
2. Open a command prompt and enter "cd -path to folder-";
3. Enter the command "git clone https://github.com/Serhii-Mashkovets/RestaurantBooking.git"
4. Open the project in a development environment convenient for you (for this project I used IntellijIDEA);
```


## Installation and Setup

Since we are using Maven, all necessary dependencies are added in the pom.xml file. However, if you wish to expand or complement the project, you can add dependencies to this file.

To start the application, run the "RestaurantBookingApplication.java" class or execute `./mvnw spring-boot:run` and open SwaggerUI at http://localhost:8080/swagger-ui.html in your browser.

![RestaurantBooking](https://nextrestaurants.com/wp-content/uploads/2018/07/Restaurant-Online-Reservation-Systems.png)