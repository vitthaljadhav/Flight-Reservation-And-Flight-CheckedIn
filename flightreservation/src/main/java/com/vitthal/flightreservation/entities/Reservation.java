package com.vitthal.flightreservation.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Reservation  extends AbstractEntity{

	private Boolean checkedIn;
	
	private int numbeOfBags;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
