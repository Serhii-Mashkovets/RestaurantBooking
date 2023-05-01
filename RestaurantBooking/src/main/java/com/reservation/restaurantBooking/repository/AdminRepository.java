package com.reservation.restaurantBooking.repository;

import com.reservation.restaurantBooking.entity.AdminEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A {@link JpaRepository} providing CRUD operations on {@link AdminEntity}.
 */
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

}