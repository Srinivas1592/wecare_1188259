package com.infosys.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BookingDTO;

import com.infosys.dto.LoginDTO;
import com.infosys.dto.UserDTO;
import com.infosys.exception.WecareException;
import com.infosys.service.UserService;

@RestController
@Validated
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/hello")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
		System.out.println("User Controller invoked------>");
		return userService.createUser(userDTO);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {
		System.out.println(userId);
		return userService.getUserProfile(userId);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<Boolean> loginUser(@Valid @RequestBody LoginDTO loginDTO) throws WecareException {
		return userService.loginUser(loginDTO);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> showAllCoaches() {
		return userService.showAllUsers();
	}

	@GetMapping("/booking/{userId}")
	public List<BookingDTO> showMyAppointments(String userId) {
		return userService.showMyAppointments(userId);
	}
}
