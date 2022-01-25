package com.infosys.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = { "password" }, allowSetters = true)
public class CoachDTO {

	String coachId;

	/*
	 * @NotNull
	 * 
	 * @Min(value=3)
	 * 
	 * @Max(value=50)
	 */
	@Size(max = 50, min = 3)
	String name;
	/*
	 * @NotNull
	 * 
	 * @Min(value=5)
	 * 
	 * @Max(value=10)
	 */
	@Size(max = 10, min = 5)
	String password;
	char gender;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate dateOfBirth;

	@NotNull
	
	  @Min(value=1L)
	  
	  @Max(value=9999999999L)
	 
	/* @Pattern(regexp = "^[0-9]{10}$", message = "Customer ID must be a number") */
	long mobileNumber;
	/*
	 * @NotNull
	 * 
	 * @Min(3)
	 * 
	 * @Max(50)
	 */
	@Size(max = 50, min = 3, message = "specialty field min 3 maz 50")
	String speciality;

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
