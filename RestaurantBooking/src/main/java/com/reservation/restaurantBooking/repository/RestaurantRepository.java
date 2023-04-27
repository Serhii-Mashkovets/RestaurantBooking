package com.reservation.restaurantBooking.repository;

import com.reservation.restaurantBooking.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A {@link JpaRepository} providing CRUD operations on {@link RestaurantEntity}.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}
