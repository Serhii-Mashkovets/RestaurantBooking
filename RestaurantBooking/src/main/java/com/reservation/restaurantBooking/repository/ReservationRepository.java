package com.reservation.restaurantBooking.repository;

import com.reservation.restaurantBooking.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * A {@link JpaRepository} providing CRUD operations on {@link ReservationEntity}.
 */
@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByUserId(Long userId);
}

