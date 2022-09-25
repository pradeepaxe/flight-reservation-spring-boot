package com.example.flightreservation.model;

import lombok.Data;

@Data
public class CreateReservationRequest {
	private String passengerFirstName;
	private String passengerMiddleName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhone;
	private String cardNumber;
	private String securityCode;
	private String expirationDate;

	private int flightId;
	
}
