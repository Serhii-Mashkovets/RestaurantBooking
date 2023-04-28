package com.reservation.restaurantBooking.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidGuestRequestException extends BaseException {


    private final String property;

    private final String value;

    public InvalidGuestRequestException(String property, String value) {
        super("Invalid guest request: '%s' -> '%s'".formatted(property, value));
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }
}

