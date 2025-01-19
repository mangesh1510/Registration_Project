package com.example.registration.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registration.Model.User;

	public interface UserRepository extends JpaRepository<User, Long> {
	    User findByEmail(String email);
	
	
	}



