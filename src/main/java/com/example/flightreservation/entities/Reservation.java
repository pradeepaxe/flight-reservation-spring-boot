package com.example.flightreservation.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="reservation")
@Data
public class Reservation extends AbstractEntity {

	  private boolean checkedIn;
	  private int NumberOfBags;
	  @OneToOne
	  private Flight flight;
	  @OneToOne
	  private Passenger passenger;
	  
	
}
