package au.com.sudeera.microservice.reservationservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.sudeera.microservice.reservationservice.model.Reservation;
import au.com.sudeera.microservice.reservationservice.repository.ReservationRepository;
import au.com.sudeera.microservice.reservationservice.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation createReservation(Reservation reservation) {
		
		if(getReservationByName(reservation.getName()) != null) {
			return null;
		}
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}
	
	public Reservation getReservationByName(String name) {
		return reservationRepository.getByName(name);
	}

	@Override
	public Reservation getReservationById(Long id) {
		return reservationRepository.findOne(id);
	}

}
