package com.example.registration.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.Model.User;
import com.example.registration.Repo.UserRepository;

	@Service
public class UserService {

	    @Autowired
	    private UserRepository userRepository;

	    public User registerUser(User user) {
	        if (userRepository.findByEmail(user.getEmail()) != null) {
	            throw new RuntimeException("Email already exists");
	        }
	        return userRepository.save(user);
	    }
	}



