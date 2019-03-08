package com.vitthal.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitthal.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
