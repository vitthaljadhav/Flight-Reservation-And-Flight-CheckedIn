package com.vitthal.flightreservation.service;

import com.vitthal.flightreservation.dto.ReservationRequest;
import com.vitthal.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
