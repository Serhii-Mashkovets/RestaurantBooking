package com.reservation.restaurantBooking.exceptions;

/**
 * Intended to be subclassed by application specific exceptions.
 * Призначено для поділу на підкласи за винятками для конкретних застосувань.
 */
public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super (message, cause);
    }

}
