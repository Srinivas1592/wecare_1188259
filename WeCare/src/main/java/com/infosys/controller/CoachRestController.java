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
import com.infosys.dto.CoachDTO;
import com.infosys.dto.LoginDTO;
import com.infosys.exception.WecareException;
import com.infosys.service.CoachService;

@RestController
@Validated
@RequestMapping("/coaches")
public class CoachRestController {

	@Autowired
	private CoachService coachService;
	
	@PostMapping
	public String createCoach(@Valid @RequestBody CoachDTO coachDTO) {
		System.out.println();
		return coachService.createCoach(coachDTO);
	}
	
	@GetMapping(value="/{coachId}")
	public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable("coachId") String coachId){
		System.out.println(coachId+"nasheeer");
		return coachService.getCoachProfile(coachId);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<Boolean> loginCoach(@Valid @RequestBody LoginDTO loginDTO) throws WecareException {
		
		return coachService.loginCoach(loginDTO);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CoachDTO>> showAllCoaches(){	
		
		return coachService.showAllCoaches();
		
	}
	
	@GetMapping(value="/booking/{coachId}")
	public ResponseEntity<List<BookingDTO>> showMySchedule(String coachId){
		
		return coachService.showMySchedule(coachId);
	}
}
