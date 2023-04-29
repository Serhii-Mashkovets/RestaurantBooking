package com.reservation.restaurantBooking.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


/**
 * This class provides configuration for the database connection.
 * It sets up a {@link DriverManagerDataSource} object as a Spring bean,
 * using the values specified in the application.properties file.
 */
@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    /**
     * Creates and returns a {@link DriverManagerDataSource} object as a Spring bean.
     * The object is configured with the values specified in the application.properties file.
     *
     * @return a DriverManagerDataSource object configured with the properties specified in the application.properties file
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
