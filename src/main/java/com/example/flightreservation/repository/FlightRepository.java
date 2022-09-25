package com.example.flightreservation.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	
	
	@Query(" from Flight where departureCity=:departureCity and "
			+ "  arrivalCity=:arrivalCity and "
			+ " dateOfDeparture=:dateOfDeparture ")
	List<Flight> findFlightsFrom(@Param("departureCity") String from, @Param("arrivalCity")String to , @Param("dateOfDeparture") Date departureDate);
}
