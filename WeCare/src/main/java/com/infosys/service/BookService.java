package com.infosys.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.PastOrPresent;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosys.dto.BookingDTO;
import com.infosys.entity.BookingEntity;
import com.infosys.entity.UserEntity;
import com.infosys.repository.BookRepository;
import com.infosys.utility.MailUtility;

@Service
public class BookService {
	boolean flag = true;
	@Autowired
	private BookRepository bookRepositry;
	@Autowired
	private MailUtility mail;

	@Autowired
	private ModelMapper modelMapper;

	public ResponseEntity<Boolean> bookAppointment(String userId, String coachId, BookingDTO bookDTO) {
		bookRepositry.findAll().stream().forEach(entity -> {
			if (entity.getAppointmentDate().equals(bookDTO.getAppointmentDate())
					&& entity.getSlot().equals(bookDTO.getSlot())) {
				flag = false;
			}
		});

		System.out.println(flag);
		if (flag) {
			BookingDTO bookingDTO = new BookingDTO();
			bookingDTO.setAppointmentDate(bookDTO.getAppointmentDate());
			// bookingEntity.setBookingId();// pass generator;
			bookingDTO.setCoachId(coachId);
			bookingDTO.setUserId(userId);
			bookingDTO.setSlot(bookDTO.getSlot());
			BookingEntity bookEntity = modelMapper.map(bookingDTO, BookingEntity.class);
			System.out.println("DATA generater for appointment " + bookEntity);
			BookingEntity mail=bookRepositry.save(bookEntity);
			LocalDate today = LocalDate.parse(bookingDTO.getAppointmentDate());
			Optional<UserEntity> entity=bookRepositry.findById(bookingDTO.getSlot());
			
			mail.sendSchedulingEmail(bookingDTO.getUserId(),
					                 bookingDTO.getCoachId(),
					                 entity.get().getEmail(), 
					                 bookingDTO.getBookingId(),
					                 bookingDTO.getSlot(), today
					                 );
			                         
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> cancelAppointment(Integer bookingId) {
		bookRepositry.deleteById(bookingId);
		Optional<BookingEntity> entity=bookRepositry.findById(bookingId);
		LocalDate today = LocalDate.parse(entity.get().getAppointmentDate());
		
		mail.sendCancellingEmail(entity.get().getUserId(), entity.get().getCoachId(), entity.get().getEmail(),  entity.get().getBookingId(), entity.get().getSlot(), today);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

	public ResponseEntity<Boolean> rescheduleAppointment(Integer bookingId,
			@RequestBody BookingDTO bookDTO) {

		Optional<BookingEntity> bookingEntity =bookRepositry.findById(bookingId);
				
		if (!bookingEntity.get().getAppointmentDate().equals(bookDTO.getAppointmentDate())
				&& !bookingEntity.get().getSlot().equals(bookDTO.getSlot())) {

			BookingEntity bookingEntity1 = modelMapper.map(bookDTO, BookingEntity.class);
			bookRepositry.save(bookingEntity1);
			Optional<BookingEntity> entity=bookRepositry.findById(bookingId);
			LocalDate today = LocalDate.parse(entity.get().getAppointmentDate());
			mail.endReschedulingEmail(bookingEntity.get().getUserId(),bookingEntity.get().getCoachId(), entity.get().getEmail() ,bookingEntity.get().getBookingId(),
					bookingEntity.get().getSlot(), bookingEntity.get().getAppointmentDate() )
			
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
	}

}
