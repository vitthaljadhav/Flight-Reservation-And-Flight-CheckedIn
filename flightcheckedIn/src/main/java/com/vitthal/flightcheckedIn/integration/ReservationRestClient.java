package com.vitthal.flightcheckedIn.integration;

import com.vitthal.flightcheckedIn.integration.dto.Reservation;
import com.vitthal.flightcheckedIn.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
