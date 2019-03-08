package com.vitthal.flightreservation.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitthal.flightreservation.dto.ReservationRequest;
import com.vitthal.flightreservation.entities.Flight;
import com.vitthal.flightreservation.entities.Reservation;
import com.vitthal.flightreservation.repos.FlightRepository;
import com.vitthal.flightreservation.service.ReservationService;

@Controller
public class ReservationController {
private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() invoked with Flight Id : : "+flightId);
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight Is :"+flightId);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() :"+request);
		Reservation reservation = reservationService.bookFlight(request);
		
		modelMap.addAttribute("msg", "Reservation Created Successfully and the Id is :"+reservation.getId());
		return "reservationConformation";
		
	}
}
