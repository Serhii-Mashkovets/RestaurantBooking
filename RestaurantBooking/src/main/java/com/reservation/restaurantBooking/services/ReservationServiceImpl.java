package com.reservation.restaurantBooking.services;

import com.reservation.restaurantBooking.entity.ReservationEntity;
import com.reservation.restaurantBooking.exceptions.ReservationNotFoundException;
import com.reservation.restaurantBooking.recordModels.ReservationInfo;
import com.reservation.restaurantBooking.recordModels.ReservationQuery;
import com.reservation.restaurantBooking.recordModels.ReservationRequest;
import com.reservation.restaurantBooking.recordModels.UpdateReservationRequest;
import com.reservation.restaurantBooking.repository.ReservationRepository;
import com.reservation.restaurantBooking.services.InterfacesForServices.ReservationService;
import com.reservation.restaurantBooking.validation.ReservationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;


/**
 * A service for managing restaurant reservations.
 *
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationValidator reservationValidator;

    /**
     * Creates and persists a {@link ReservationEntity} based on incoming {@link ReservationRequest}
     *
     * @param request request for making a restaurant reservation
     * @return the persisted reservation info
     */
    @Override
    @Transactional
    public ReservationInfo createReservation(ReservationRequest request) {
        log.debug("Creating new reservation: {}", request);
        reservationValidator.validateReservationRequest(request);

        ReservationEntity entity = new ReservationEntity(request.id(), request.name(), request.date(), request.time(),
                request.numberOfPeople(), request.confirmed(), request.restaurantId());

        ReservationEntity reservation = reservationRepository.save(entity);
        return toReservationInfo(reservation);
    }

    /**
     * Looks for reservations based on a {@link ReservationQuery}
     * and performs {@link ExampleMatcher#matchingAll} kind of matching
     * based on the provided property values.
     *
     * @param query {@link ReservationQuery}
     * @return all matching {@link ReservationInfo}s
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReservationInfo> getReservations(ReservationQuery query) {
        // a more advanced approach would involve using JpaSpecificationExecutor,
        // Specification and CriteriaBuilder (e.g. when entities grow complex)
        // or just plain SQL @Query methods in repository interfaces

        ReservationEntity probe = new ReservationEntity(query.id(), query.name(), query.date(), query.time(), query.numberOfPeople(),
                query.confirmed(), query.restaurantId());

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<ReservationEntity> example = Example.of(probe, matcher);

        List<ReservationEntity> allMatching = reservationRepository.findAll(example);
        return allMatching.stream().map(this::toReservationInfo).toList();
    }

    /**
     * Retrieves a single reservation by ID.
     *
     * @param reservationId reservation identifier
     * @return reservation found
     */
    @Override
    @Transactional(readOnly = true)
    public ReservationInfo getById(Long reservationId) {
        return toReservationInfo(getOne(reservationId));
    }

    /**
     * Deletes a reservation by ID.
     *
     * @param reservationId reservation identifier
     */
    @Override
    @Transactional
    public void deleteById(Long reservationId) {
        ReservationEntity reservation = getOne(reservationId);
        log.debug("Deleting reservation: {}", reservation);
        reservationRepository.delete(reservation);
    }

    /**
     * Updates a reservation entity.
     *
     * @param reservationId existing reservation's ID
     * @param updateReq     {@link UpdateReservationRequest}
     * @return updated reservation info
     */
    @Override
    @Transactional
    public ReservationInfo updateReservation(Long reservationId, UpdateReservationRequest updateReq) {
        ReservationEntity reservation = getOne(reservationId);

        if (updateReq.isEmpty()) {
            log.info("Nothing to update...");
            return toReservationInfo(reservation);
        }

        reservationValidator.validateUpdateRequest(updateReq, toReservationInfo(reservation));

        // Update entity with every non-null and new property value:
        updateEntityField(updateReq.name(), reservation.getName(), reservation::setName);
        updateEntityField(updateReq.date(), reservation.getDate(), reservation::setDate);
        updateEntityField(updateReq.time(), reservation.getTime(), reservation::setTime);
        updateEntityField(updateReq.numberOfPeople(), reservation.getNumberOfPeople(), reservation::setNumberOfPeople);
        updateEntityField(updateReq.confirmed(), reservation.getConfirmed(), reservation::setConfirmed);
        updateEntityField(updateReq.restaurantId(), reservation.getRestaurantId(), reservation::setRestaurantId);

        ReservationEntity edited = reservationRepository.save(reservation);
        log.info("Reservation '{}' updated with '{}'", reservation, updateReq);

        return toReservationInfo(edited);
    }

    private ReservationEntity getOne(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("id", String.valueOf(reservationId)));
    }

    private <T> void updateEntityField(T newValue, T oldValue, Consumer<T> entityFieldUpdater) {
        if (newValue != null && !newValue.equals(oldValue)) {
            entityFieldUpdater.accept(newValue);
        }
    }


    // TODO: extract to a mapper component/class when models get more complex
    private ReservationInfo toReservationInfo(ReservationEntity entity) {
        return new ReservationInfo(entity.getId(), entity.getName(), entity.getDate(), entity.getTime(),
                entity.getNumberOfPeople(), entity.getConfirmed(), entity.getRestaurantId());
    }
}
