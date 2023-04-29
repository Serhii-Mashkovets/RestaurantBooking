package com.reservation.restaurantBooking.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;


import java.util.Collections;


/**
 * Configuration class for Swagger API documentation generation.
 * This class is responsible for configuring and enabling the Swagger API documentation plugin
 * in the Spring application context. It defines a Docket bean that specifies the API endpoints
 * to be included in the documentation and sets up the basic information to be displayed on the
 * documentation page, such as the API title and a brief description.
 * Additionally, this class defines an ApiInfo bean that provides more detailed information about
 * the API, such as the terms of service, author information, and license information.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * Creates and returns a new Docket object that configures the Swagger API documentation plugin.
     * <p>
     * The Docket object specifies which endpoints to include in the documentation, among other settings.
     * In this implementation, all endpoints under the "com.reservation.restaurantBooking" base package
     * are included in the documentation.
     *
     * @return a new Docket object that configures the Swagger API documentation plugin
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.reservation.restaurantBooking"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    /**
     * Creates and returns a new ApiInfo object that provides more detailed information about the API
     * to be displayed on the Swagger documentation page.
     * <p>
     * The ApiInfo object includes information such as the API title, a brief description, terms of service,
     * author information, and license information.
     *
     * @return a new ApiInfo object that provides more detailed information about the API
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("Serhii Mashkovets", "https://www.linkedin.com/in/serhii-mashkovets/",
                        "smshserhiimashkovets@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
