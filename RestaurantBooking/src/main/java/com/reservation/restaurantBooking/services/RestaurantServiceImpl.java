package com.reservation.restaurantBooking.services;

import com.reservation.restaurantBooking.entity.RestaurantEntity;
import com.reservation.restaurantBooking.exceptions.RestaurantNotFoundException;
import com.reservation.restaurantBooking.models.CuisineType;
import com.reservation.restaurantBooking.recordModels.RestaurantRecord;
import com.reservation.restaurantBooking.repository.RestaurantRepository;
import com.reservation.restaurantBooking.services.InterfacesForServices.RestaurantService;
import com.reservation.restaurantBooking.validation.RestaurantValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A service for managing restaurants.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger log = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final RestaurantRepository restaurantRepository;
    private final RestaurantValidator restaurantValidator;


    /**

     Constructor to inject dependencies
     @param restaurantRepository the repository for restaurant entities
     @param restaurantValidator the validator for restaurant records
     */
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantValidator restaurantValidator) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantValidator = restaurantValidator;
    }


    /**

     Retrieves the restaurant record with the specified id
     @param id the id of the restaurant
     @return the restaurant record with the specified id
     @throws RestaurantNotFoundException if no restaurant entity exists with the specified id
     */
    @Override
    public RestaurantRecord getRestaurantById(Long id) throws RestaurantNotFoundException {
        log.info("Getting the restaurant by id");
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("RestaurantEntity", "id", String.valueOf(id)));
        return new RestaurantRecord((long) restaurantEntity.getId(), restaurantEntity.getName(), (CuisineType) restaurantEntity.getCuisineType());
    }


    /**

     Retrieves all restaurant records
     @return a list of all restaurant records
     */
    @Override
    public List<RestaurantRecord> getAllRestaurants() {
        log.info("Getting all restaurants");
        return restaurantRepository.findAll().stream()
                .map(restaurantEntity -> new RestaurantRecord((long) restaurantEntity.getId(), restaurantEntity.getName(), (CuisineType) restaurantEntity.getCuisineType()))
                .collect(Collectors.toList());
    }


    /**

     Creates a new restaurant record

     @param restaurantRecord the restaurant record to create

     @return the created restaurant record
     */
    @Override
    public RestaurantRecord createRestaurant(RestaurantRecord restaurantRecord) {
        log.info("Creating new restaurant");

        restaurantValidator.validateRestaurantRecord(restaurantRecord);
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setId(Math.toIntExact(restaurantRecord.id()));
        restaurantEntity.setName(restaurantRecord.name());
        restaurantEntity.setCuisineType(restaurantRecord.cuisineType());
        restaurantEntity = restaurantRepository.save(restaurantEntity);
        return new RestaurantRecord((long) restaurantEntity.getId(), restaurantEntity.getName(), (CuisineType) restaurantEntity.getCuisineType());
    }



    /**

     Updates the restaurant record with the specified id
     @param id the id of the restaurant to update
     @param restaurantRecord the updated restaurant record
     @return the updated restaurant record
     @throws RestaurantNotFoundException if no restaurant entity exists with the specified id
     */
    @Override
    public RestaurantRecord updateRestaurant(Long id, RestaurantRecord restaurantRecord) throws RestaurantNotFoundException {
        log.info("Updating the restaurant");
        restaurantValidator.validateRestaurantRecord(restaurantRecord);
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("RestaurantEntity", "id", String.valueOf(id)));
        restaurantEntity.setId(Math.toIntExact(restaurantRecord.id()));
        restaurantEntity.setName(restaurantRecord.name());
        restaurantEntity.setCuisineType(restaurantRecord.cuisineType());
        restaurantEntity = restaurantRepository.save(restaurantEntity);
        return new RestaurantRecord((long) restaurantEntity.getId(), restaurantEntity.getName(), (CuisineType) restaurantEntity.getCuisineType());
    }


    /**
     * Deletes the restaurant record with the specified id.
     *
     * @param id the id of the restaurant to delete
     */
    @Override
    public void deleteRestaurant(Long id) {
        log.info("Deleting the restaurant by id: {}", id);
        restaurantRepository.deleteById(id);
    }

}
