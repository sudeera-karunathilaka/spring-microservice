package au.com.sudeera.microservice.reservationservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.sudeera.microservice.reservationservice.model.Reservation;
import au.com.sudeera.microservice.reservationservice.service.ReservationService;

@RestController
public class ReservationResource {

	@Autowired 
	private ReservationService reservationService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
		reservation = reservationService.createReservation(reservation);
		if(reservation == null) {
			return new ResponseEntity<Reservation>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Reservation>(reservation, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reservation>> getAllReservations(){
		return new ResponseEntity<List<Reservation>>(reservationService.getAllReservations(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
		return new ResponseEntity<Reservation>(reservationService.getReservationById(id), HttpStatus.OK);
	}
	
}
