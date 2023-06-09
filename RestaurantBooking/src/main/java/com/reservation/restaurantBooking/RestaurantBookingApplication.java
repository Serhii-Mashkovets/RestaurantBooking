package com.reservation.restaurantBooking;

import com.reservation.restaurantBooking.configurations.ApplicationConfig;
import com.reservation.restaurantBooking.configurations.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({ ApplicationConfig.class, SecurityConfig.class})
public class RestaurantBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBookingApplication.class, args);
    }

}
