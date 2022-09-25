package com.example.flightreservation.integration;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightreservation.entities.Flight;
import com.example.flightreservation.entities.Passenger;
import com.example.flightreservation.entities.Reservation;
import com.example.flightreservation.model.CreateReservationRequest;
import com.example.flightreservation.model.UpdateReservationRequest;
import com.example.flightreservation.repository.FlightRepository;
import com.example.flightreservation.repository.PassengerRepository;
import com.example.flightreservation.repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@RequestMapping(value="/flights" , method=RequestMethod.GET)
	public List<Flight> findFlights(
			@RequestParam("from") String from,
			@RequestParam("to") String to ,
			@RequestParam("date") @DateTimeFormat(pattern="MM-dd-yyyy")Date date){
		return flightRepo.findFlightsFrom(from, to, date);
	}
	
	@RequestMapping(value="/reservations" , method=RequestMethod.POST)
	@Transactional
	public Reservation saveResearvations(@RequestBody CreateReservationRequest request){
		Flight flight = flightRepo.findById(request.getFlightId()).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setPhone(request.getPassengerPhone());
		
		Passenger savePassengerId = passengerRepo.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(true);
		reservation.setFlight(flight);
		reservation.setPassenger(savePassengerId);
		
		return reservationRepo.save(reservation);
		
		
	
	}
	
	@RequestMapping(value="/reservations/{id}" , method=RequestMethod.GET)
	public Reservation findReservation(@PathVariable("id") int id){
		return reservationRepo.findById(id).get();
	}
	
	@RequestMapping(value="/flights/{id}" , method=RequestMethod.GET)
	public Flight findFlight(@PathVariable("id") int id){
		return flightRepo.findById(id).get();
	}
	
	
	@RequestMapping(value="/reservations" , method=RequestMethod.PUT)
	public Reservation updateReservation(@RequestBody  UpdateReservationRequest request ){
		Reservation reservation= reservationRepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckIn());
		return reservationRepo.save(reservation);
	
	}
}

 