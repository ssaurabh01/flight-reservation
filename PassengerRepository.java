package com.saurabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
