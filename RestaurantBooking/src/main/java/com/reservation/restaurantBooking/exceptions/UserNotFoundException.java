package com.reservation.restaurantBooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Thrown when a user is not found.
 * Генерується, коли користувача не знайдено.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super("The user was not found", cause);
    }
}
