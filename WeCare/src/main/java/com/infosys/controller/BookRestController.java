package com.infosys.controller;

import java.time.LocalDate;

import javax.validation.constraints.PastOrPresent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BookingDTO;
import com.infosys.service.BookService;

@RestController
@Validated
public class BookRestController {
	@Autowired
	private BookService bookService;

	@PostMapping(value = "/users/{userId}/booking/{coachId}")
	public ResponseEntity<Boolean> bookAppointment( @PathVariable(value = "userId") String userId,
			@PathVariable(value = "coachId") String coachId,@RequestBody BookingDTO bookDTO) {
		return bookService.bookAppointment(userId, coachId, bookDTO);
	}
	
	@DeleteMapping(value="/booking/{bookingId}")
	public ResponseEntity<?> cancelAppointment(@PathVariable("bookingId") Integer bookingId){
		return bookService.cancelAppointment(bookingId);
	}
	@PutMapping("/booking/{bookingId}")
	public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable Integer bookingId,@RequestBody BookingDTO bookDTO){
		
		return bookService.rescheduleAppointment(bookingId, bookDTO);
		
	}
}
