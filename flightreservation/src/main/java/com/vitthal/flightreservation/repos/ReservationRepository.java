package com.vitthal.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitthal.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
