package com.example.flightreservation.model;

import lombok.Data;

@Data
public class UpdateReservationRequest {
	
	private int id;
	private boolean checkIn;
	private int numberOfBags;

}
