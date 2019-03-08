package com.vitthal.flightcheckedIn.integration.dto;

import java.util.Date;

public class Reservation{

	private Long id;
	private Boolean checkedIn;	
	private int numbeOfBags;
	private Passenger passenger;
	private Flight flight;

	//private Date created;
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumbeOfBags() {
		return numbeOfBags;
	}

	public void setNumbeOfBags(int numbeOfBags) {
		this.numbeOfBags = numbeOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
