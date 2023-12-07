package com.saurabh.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.flightreservation.dto.ReservationRequest;
import com.saurabh.flightreservation.entities.Flight;
import com.saurabh.flightreservation.entities.Passenger;
import com.saurabh.flightreservation.entities.Reservation;
import com.saurabh.flightreservation.repos.FlightRepository;
import com.saurabh.flightreservation.repos.PassengerRepository;
import com.saurabh.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	
	@Autowired
	PassengerRepository passengerRepository;
	
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId);
		
		Passenger passenger= new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger= passengerRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation=reservationRepository.save(reservation);
		return savedReservation;
	}

}
