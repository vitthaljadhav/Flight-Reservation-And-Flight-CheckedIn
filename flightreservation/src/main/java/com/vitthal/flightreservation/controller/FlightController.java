package com.vitthal.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitthal.flightreservation.entities.Flight;
import com.vitthal.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	private final static  Logger LOGGER=LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightRepository flightRepository;

	@RequestMapping(value = "/findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date deparetureDate,
			ModelMap modelMap) {

		LOGGER.info("inside findFlights"+"From:"+from+" TO"+to+" Departure Date :"+deparetureDate);
		List<Flight> flights = flightRepository.findFlights(from, to, deparetureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flight Found are :"+flights);
		return "displayFlights";
	}
	
	@RequestMapping(value="/admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
