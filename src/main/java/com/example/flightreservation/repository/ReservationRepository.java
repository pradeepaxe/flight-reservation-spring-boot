package com.example.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
