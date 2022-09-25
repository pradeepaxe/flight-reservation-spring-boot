package com.example.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="passenger")
@Data
public class Passenger extends AbstractEntity{

	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phone;
	
	
	
	
}	
