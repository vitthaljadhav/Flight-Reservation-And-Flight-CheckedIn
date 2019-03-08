package com.vitthal.flightreservation.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vitthal.flightreservation.dto.ReservationRequest;
import com.vitthal.flightreservation.entities.Flight;
import com.vitthal.flightreservation.entities.Passenger;
import com.vitthal.flightreservation.entities.Reservation;
import com.vitthal.flightreservation.repos.FlightRepository;
import com.vitthal.flightreservation.repos.PassengerRepository;
import com.vitthal.flightreservation.repos.ReservationRepository;
import com.vitthal.flightreservation.util.EmailUtil;
import com.vitthal.flightreservation.util.PDFGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.vitthal.flightreservation.itinerary.dirpath}")
	private  String ITINERARY_DIR;
	
	//private  String ITINERARY_DIR = "C:/Users/INTEL/Documents/reservations/reservation";

	private final static  Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("inside bookFlight()");
		//make payment
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for the flight id :"+flightId);
		Flight flight = flightRepository.findOne(flightId);
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("saving the passenger :"+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCreated(new Date());
		reservation.setCheckedIn(false);
		
		LOGGER.info("saving the reservation :"+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
		LOGGER.info("generating itinerary");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		LOGGER.info("emailing the itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		return savedReservation;
	}

}
