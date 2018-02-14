package au.com.sudeera.microservice.reservationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import au.com.sudeera.microservice.reservationservice.model.Reservation;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	Reservation getByName(String name);

}
