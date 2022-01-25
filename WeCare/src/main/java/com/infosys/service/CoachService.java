package com.infosys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.BookingDTO;
import com.infosys.dto.CoachDTO;
import com.infosys.dto.LoginDTO;
import com.infosys.entity.BookingEntity;
import com.infosys.entity.CoachEntity;
import com.infosys.exception.ExceptionConstants;
import com.infosys.exception.WecareException;
import com.infosys.repository.BookRepository;
import com.infosys.repository.CoachRepository;
import com.infosys.utility.Constants;

@Service
@PropertySource("classpath:messages.properties")
public class CoachService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CoachRepository coachRepositry;

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private Environment environment;

	public String createCoach(CoachDTO coachDTO) {

		CoachEntity entity=coachRepositry.save(modelMapper.map(coachDTO, CoachEntity.class));
		return "Created Successfully and Coach ID : "+entity.getCoachId();
	}

	public ResponseEntity<CoachDTO> getCoachProfile(String coachId) {
		Optional<CoachEntity> coachEntity = coachRepositry.findById(coachId);
		if(coachEntity.isPresent()) {
			System.out.println("findbyidcoach" + coachEntity);
			return new ResponseEntity<CoachDTO>(modelMapper.map(coachEntity.get(), CoachDTO.class), HttpStatus.OK);
		}
		
		else return new ResponseEntity<CoachDTO>(modelMapper.map(null, CoachDTO.class), HttpStatus.NOT_FOUND);
			
	}

	public ResponseEntity<Boolean> loginCoach(LoginDTO loginDTO) throws WecareException {
		if (coachRepositry.existsById(loginDTO.getId())) {
			Optional<CoachEntity> coachEntity = coachRepositry.findById(loginDTO.getId());
			if (coachEntity.get().getPassword().equals(loginDTO.getPassword()))
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			else
				return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		} else
			throw new WecareException(environment.getProperty((Constants.COACH_NOT_FOUND.toString())));

	}

	public ResponseEntity<List<CoachDTO>> showAllCoaches() {

		List<CoachEntity> coachEntities = new ArrayList<>();
		List<CoachDTO> coachDTOs = new ArrayList<>();
		coachEntities.addAll(0, coachRepositry.findAll());

		for (CoachEntity entity : coachEntities) {
			coachDTOs.add(modelMapper.map(entity, CoachDTO.class));
		}
		return new ResponseEntity<List<CoachDTO>>(coachDTOs, HttpStatus.OK);

	}

	public ResponseEntity<List<BookingDTO>> showMySchedule(String coachId) {
		List<BookingEntity> bookEntities = new ArrayList<>();
		bookEntities.addAll(0,bookRepository.findAll());
		List<BookingDTO> bookDTOs = new ArrayList<>();
		for (BookingEntity entity : bookEntities) {
			System.out.println(entity);
			bookDTOs.add(modelMapper.map(entity, BookingDTO.class));
		}
		return new ResponseEntity<List<BookingDTO>>(bookDTOs, HttpStatus.OK);
	}
}
