package com.vitthal.flightcheckedIn.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.vitthal.flightcheckedIn.integration.dto.Reservation;
import com.vitthal.flightcheckedIn.integration.dto.ReservationUpdateRequest;
@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
	   // System.out.println("-------------Flight Number-------"+reservation.getFlight().getFlightNumber());
		return reservation;
	}

}
