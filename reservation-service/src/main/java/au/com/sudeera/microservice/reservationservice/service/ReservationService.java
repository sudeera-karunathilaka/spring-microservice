package au.com.sudeera.microservice.reservationservice.service;

import java.util.List;

import au.com.sudeera.microservice.reservationservice.model.Reservation;

public interface ReservationService {

	Reservation createReservation(Reservation reservation);

	List<Reservation> getAllReservations();

	Reservation getReservationById(Long id);
}
