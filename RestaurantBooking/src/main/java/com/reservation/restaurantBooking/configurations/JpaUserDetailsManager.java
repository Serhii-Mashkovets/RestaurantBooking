package com.reservation.restaurantBooking.configurations;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

public class JpaUserDetailsManager implements UserDetailsManager {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    @Transactional
    public void createUser(UserDetails userDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional
    public void updateUser(UserDetails userDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(userDetails);
        entityManager.getTransaction().commit();
    }

    @Override
    @Transactional
    public void deleteUser(String s) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDetails userDetails = entityManager.find(UserDetails.class, s);
        entityManager.getTransaction().begin();
        entityManager.remove(userDetails);
        entityManager.getTransaction().commit();
    }

    @Override
    public void changePassword(String s, String s1) {
        // Not implemented
    }

    @Override
    @Transactional
    public boolean userExists(String s) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDetails userDetails = entityManager.find(UserDetails.class, s);
        return userDetails != null;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<UserDetails> resultList = entityManager.createQuery(
                        "SELECT u FROM UserEntity u WHERE u.name = :username", UserDetails.class)
                .setParameter("username", s)
                .getResultList();
        if (resultList.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
        return resultList.get(0);
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
