package com.saurabh.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.flightreservation.entities.User;
import com.saurabh.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user") User user) {
		if(user.getId()!=null) {
		userRepository.save(user);
		}
		return "login/login";
	}
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,
			@RequestParam String password,ModelMap modelmap) {
		User user = userRepository.findAllByEmail(email);
		if(user.getPassword().equals(password)) {
			return "findFlights";
		}else {
			modelmap.addAttribute("msg","Invalid user or password please try again.");
		}
		return "login/login";
	}

}
