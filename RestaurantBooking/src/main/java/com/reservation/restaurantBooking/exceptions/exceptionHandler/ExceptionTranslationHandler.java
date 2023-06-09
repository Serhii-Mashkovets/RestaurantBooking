package com.reservation.restaurantBooking.exceptions.exceptionHandler;

import com.reservation.restaurantBooking.exceptions.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Contains definitions of {@link ExceptionHandler}s that translate any
 * exceptions occurred during the lifetime of HTTP API request.
 *
 * Містить визначення {@link ExceptionHandler}, які обробляють будь-які винятки,
 * що виникли під час виконання запиту до HTTP API.
 */
@RestControllerAdvice
public class ExceptionTranslationHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionTranslationHandler.class);

    /**
     * Extracts HTTP response status code from exception classes
     * (mostly {@link BaseException} derivatives) annotated with
     * {@link ResponseStatus}.
     *
     *
     * Витягує код статусу HTTP-відповіді з класів винятків (переважно похідних {@link BaseException}),
     * анотованих за допомогою {@link ResponseStatus}.
     *
     * @param e exception instance to extract HttpStatus from
     * @return the extracted {@link HttpStatus} (defaults to {@link HttpStatus#INTERNAL_SERVER_ERROR})
     */
    private static HttpStatus getStatusCode(Exception e) {
        ResponseStatus responseStatus = e.getClass().getDeclaredAnnotation(ResponseStatus.class);
        return responseStatus != null ? responseStatus.value() : INTERNAL_SERVER_ERROR;
    }

    private static GenericErrorResponse toGenericError(Exception e) {
        return new GenericErrorResponse(e.getClass().getSimpleName(), e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handle(Exception e) {
        log.error("Translating error:", e);
        return ResponseEntity.status(getStatusCode(e)).body(toGenericError(e));
    }

    /**
     * Represents generic error data structure returned to API clients with
     * information about the exception that occurred.
     *
     * @param error   exception type (Java simple type name)
     * @param message error message
     */
    private record GenericErrorResponse(String error, String message) {
    }

}
