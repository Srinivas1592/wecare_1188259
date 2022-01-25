package com.infosys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.BookingDTO;
import com.infosys.dto.CoachDTO;
import com.infosys.dto.LoginDTO;
import com.infosys.dto.UserDTO;
import com.infosys.entity.BookingEntity;
import com.infosys.entity.CoachEntity;
import com.infosys.entity.UserEntity;
import com.infosys.repository.BookRepository;
import com.infosys.repository.UserRepository;
import com.infosys.utility.UserIdGenerator;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired private ModelMapper modelMapper; 
	

	@Autowired BookRepository bookRepository;

	public ResponseEntity<String> createUser(UserDTO userDTO) {	
		System.out.println("User Data here ---------> "+ userDTO);
		UserEntity userEntity=
				userRepository.save(modelMapper.map(userDTO, UserEntity.class));
		userDTO.setUserId(userEntity.getUserId());
		return new ResponseEntity<String>(userDTO.getUserId(), HttpStatus.OK);
		
	}

	public ResponseEntity<UserDTO> getUserProfile(String userId) {
		Optional<UserEntity> userEntity= userRepository.findById(userId);	
		if(userEntity.isPresent())
		return new ResponseEntity<UserDTO>(modelMapper.map(userEntity.get(), UserDTO.class) ,HttpStatus.OK);	
		
			return new ResponseEntity<UserDTO>( HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Boolean> loginUser(LoginDTO loginDTO) {
		System.out.println("Login DatA "+loginDTO);
		if(userRepository.existsById(loginDTO.getId())) {
			
			Optional<UserEntity> userEntity=userRepository.findById(loginDTO.getId());
			
			if(!userEntity.isEmpty() && userEntity.get().getPassword().equals(loginDTO.getPassword()))	{

				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
		}
             return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<List<UserDTO>> showAllUsers() {
		List<UserEntity> userEntities=new ArrayList<>();
		List<UserDTO> userDTOs=new ArrayList<>();
		userEntities.addAll(0, userRepository.findAll());
		
		for(UserEntity entity:userEntities) {
			userDTOs.add(modelMapper.map( entity, UserDTO.class));
		}
		return new ResponseEntity<List<UserDTO>>(userDTOs,HttpStatus.OK);
	}

	public List<BookingDTO> showMyAppointments(String userId) {
		List<BookingEntity> list=new ArrayList<>();
		List<BookingDTO> bookList=new ArrayList<>();
		list.addAll(bookRepository.findAll());
		for(BookingEntity entity:list) {
			if(userId==entity.getUserId())
				bookList.add(modelMapper.map( entity, BookingDTO.class));
		}		
		return bookList;
	}

}
