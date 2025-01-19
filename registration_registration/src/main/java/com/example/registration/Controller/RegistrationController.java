package com.example.registration.Controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

import com.example.registration.Model.User;
import com.example.registration.Service.UserService;

	@RestController
	@RequestMapping("/api/registration")
	public class RegistrationController {

	    @Autowired
	    private UserService userService;

	    @PostMapping
	    public String registerUser(@RequestBody User user) {
	        userService.registerUser(user);
	        return "User registered successfully!";
	    }
	}



