package com.reservation.restaurantBooking.repository;

import com.reservation.restaurantBooking.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * A {@link JpaRepository} providing CRUD operations on {@link GuestEntity}.
 */
@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

}
