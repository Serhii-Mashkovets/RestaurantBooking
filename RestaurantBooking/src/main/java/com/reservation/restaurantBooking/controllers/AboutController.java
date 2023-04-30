package com.reservation.restaurantBooking.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.reservation.restaurantBooking.apiConstant.ApiConstants.ABOUT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Provides general/about info for reservation API server
 *
 */
@RestController
public class AboutController {

    @Value("${server.port}")
    private int serverPort;

    @Operation(summary = "Provides brief info about the reservation API server.")
    @RequestMapping(method = GET, path = ABOUT)
    public ResponseEntity<Object> aboutInfo() {
        return ResponseEntity.ok(new Object() {
            public final String description = "RESTaurant reservation API server.";
            public final String version = "v0.0.1";
            public final String author = "Serhii Mashkovets";
            public final String apiDocsUrl = "http://localhost:" + serverPort + "/api-docs";
            public final String swaggerUiUrl = "http://localhost:" + serverPort + "/swagger-ui.html";
        });
    }

}

/*
            "RESTaurant reservation API server."
            "v0.0.1"
            "Serhii Mashkovets"
            "http://localhost:8080/api-docs"
            "http://localhost:8080/swagger-ui.html"

 */