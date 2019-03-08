package com.vitthal.flightcheckedIn.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitthal.flightcheckedIn.integration.ReservationRestClient;
import com.vitthal.flightcheckedIn.integration.dto.Reservation;
import com.vitthal.flightcheckedIn.integration.dto.ReservationUpdateRequest;
@Controller
public class CheckInController {

	@Autowired
	private ReservationRestClient restClient;
	
	@RequestMapping(value="/showStartCheckIn")
	public String showStartCheckIn() {
		return "startCheckIn";
	}
	@RequestMapping(value="/startCheckIn", method=RequestMethod.POST)
	public String startCheckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";	
	}
	
	@RequestMapping(value="/completeCheckIn",method=RequestMethod.POST)
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags){
		
		System.out.println("Id---------------- :"+reservationId);
		System.out.println("Number Of Bags  :--------------"+numberOfBags);
		
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		Reservation reservation = restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}
}
