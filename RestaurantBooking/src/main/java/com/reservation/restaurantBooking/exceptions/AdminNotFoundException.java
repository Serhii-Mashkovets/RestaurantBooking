package com.reservation.restaurantBooking.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when an admin is not found.
 * Генерується, коли адміна не знайдено.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdminNotFoundException extends  BaseException{

    public AdminNotFoundException(String message) {
        super(message);
    }

    public AdminNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
