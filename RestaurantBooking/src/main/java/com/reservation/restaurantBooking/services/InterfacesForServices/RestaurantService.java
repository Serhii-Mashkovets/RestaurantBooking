package com.reservation.restaurantBooking.services.InterfacesForServices;

import com.reservation.restaurantBooking.recordModels.RestaurantRecord;

import java.util.List;

public interface RestaurantService {

    /**
     * Retrieves a single restaurant by ID.
     *
     * @param id restaurant identifier
     * @return restaurant found
     */
    RestaurantRecord getRestaurantById(Long id);

    /**
     * Retrieves all restaurants.
     *
     * @return all restaurants
     */
    List<RestaurantRecord> getAllRestaurants();

    /**
     * Creates and persists a {@link RestaurantRecord} based on incoming {@link RestaurantRecord}
     *
     * @param restaurantRecord restaurant information to create
     * @return the persisted restaurant information
     */
    RestaurantRecord createRestaurant(RestaurantRecord restaurantRecord);

    /**
     * Updates a restaurant entity.
     *
     * @param id               existing restaurant's ID
     * @param restaurantRecord {@link RestaurantRecord}
     * @return updated restaurant information
     */
    RestaurantRecord updateRestaurant(Long id, RestaurantRecord restaurantRecord);

    /**
     * Deletes a restaurant by ID.
     *
     * @param id restaurant identifier
     */
    void deleteRestaurant(Long id);
}
