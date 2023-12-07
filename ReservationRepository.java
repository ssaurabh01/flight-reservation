package com.saurabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
