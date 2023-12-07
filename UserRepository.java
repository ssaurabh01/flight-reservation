package com.saurabh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurabh.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findAllByEmail(String email);

	

}
