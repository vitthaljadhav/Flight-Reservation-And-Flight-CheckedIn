package com.vitthal.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitthal.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
