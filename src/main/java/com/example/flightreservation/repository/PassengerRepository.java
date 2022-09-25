package com.example.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
