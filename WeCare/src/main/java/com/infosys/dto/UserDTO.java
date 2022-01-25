package com.infosys.dto;


import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDTO {
	

    String userId;
    
	@NotNull
	@Size(min=3,max=50)
    String name;
    
	@NotNull
	@Size(min=5,max=10)
	@JsonIgnore
    String password;
    char gender;
    LocalDate dateOfBirth;
    
	@NotNull
	@Min(value=1L)
	@Max(value=999999999L)
	/* @Pattern(regexp = "^[0-9]+$", message = "Customer ID must be a number") */
    long mobileNumber;
	
	@Valid
    String email;
	
	@NotNull
	@Min(value=100000)
	@Max(value=9999999)
    int pincode;
	
	@NotNull
	@Size(min=3,max=20)
    String city;
	
	@NotNull
	@Size(min=3,max=20)
    String state;
	
	@NotNull
	@Size(min=3,max=20)
    String country;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId =userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", mobileNumber=" + mobileNumber + ", email=" + email + ", pincode="
				+ pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

}
