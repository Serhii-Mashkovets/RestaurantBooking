package com.reservation.restaurantBooking.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;


/**
 * This class contains the configuration for Spring Security and defines the security rules for the application.
 * The security configuration includes the authentication and authorization rules for various endpoints.
 * It also configures the password encoder to be used and sets up the JdbcUserDetailsManager to handle user management.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * The data source used to authenticate users.
     */
    @Autowired
    private DataSource dataSource;


    /**
     * Configures the authentication provider for the application.
     * <p>
     * The authentication provider uses the configured data source and password encoder.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT name, email, password FROM user WHERE name=?");
    }


    /**
     * Configures the authorization rules for the application.
     * <p>
     * The authorization rules define which roles are required to access various endpoints.
     * It also disables CSRF protection and enables session management to be stateless.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/about").permitAll()
                .antMatchers("/open_api_resources").permitAll()
                .antMatchers("/mysql-console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/reservations").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/reservations").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/reservations/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.PUT, "/reservations/{id}").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.DELETE, "/reservations/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic().realmName("ReservationsRealm")
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


    /**
     * Configures the password encoder to be used for user authentication.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Configures the user details manager for the application.
     * <p>
     * The user details manager is used to create and manage users within the application.
     * In this method, several example users are created for testing purposes.
     */
    @Bean
    public JdbcUserDetailsManager userDetailsManager() {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
        userDetailsManager.setDataSource(dataSource);

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .build();

        UserDetails locked = User.builder()
                .username("locked-user")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .accountLocked(true)
                .build();

        userDetailsManager.createUser(admin);
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(locked);

        return userDetailsManager;
    }
}
