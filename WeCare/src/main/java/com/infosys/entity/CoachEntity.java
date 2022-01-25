package com.infosys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CoachEntity {

	@Id
    @GeneratedValue(generator = "coachId-generator")
    @GenericGenerator(name = "coachId-generator", 
      strategy = "com.infosys.utility.CoachIdGenerator")
	String coachId;
	String name;
	String password;
	char gender;
	LocalDate dateOfBirth;
	long mobileNumber;
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
	
	public CoachEntity() {
		super();
	}
	@Override
	public String toString() {
		return "CoachEntity [coachId=" + coachId + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", speciality=" + speciality
				+ "]";
	}
	public CoachEntity(String coachId, String name, String password, char gender, LocalDate dateOfBirth,
			long mobileNumber, String speciality) {
		super();
		this.coachId = coachId;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.speciality = speciality;
	}
}
