package com.vitthal.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitthal.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
