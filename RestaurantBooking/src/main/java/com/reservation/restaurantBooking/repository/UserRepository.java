package com.reservation.restaurantBooking.repository;

import com.reservation.restaurantBooking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A {@link JpaRepository} providing CRUD operations on {@link UserEntity}.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
