package com.saurabh.flightreservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.flightreservation.dto.ReservationRequest;
import com.saurabh.flightreservation.entities.Flight;
import com.saurabh.flightreservation.entities.Reservation;
import com.saurabh.flightreservation.repos.FlightRepository;
import com.saurabh.flightreservation.services.ReservationService;



@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Flight flight=flightRepository.findById(flightId);
		modelMap.addAttribute("flight",flight);
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation=reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation craeted successfully and the id is" 
		+reservation.getId());
		return "reservationConfirmation";
	}
}
