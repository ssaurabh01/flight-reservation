package com.saurabh.flightreservation.services;

import com.saurabh.flightreservation.dto.ReservationRequest;
import com.saurabh.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
