package com.vitthal.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vitthal.flightreservation.dto.ReservationUpdateRequest;
import com.vitthal.flightreservation.entities.Reservation;
import com.vitthal.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationRestController.class);
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping(value="/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		LOGGER.info("inside findReservation() for Id :"+id);
		return reservationRepository.findOne(id);
	}
	
	@RequestMapping(value="/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("inside updateReservation() for  :"+request);
		Reservation reservation = reservationRepository.findOne(request.getId());
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumbeOfBags(request.getNumberOfBags());
		LOGGER.info("saving reservation");
		return  reservationRepository.save(reservation);
		
	}
}
