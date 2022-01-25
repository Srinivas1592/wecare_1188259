package com.infosys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
public class BookingEntity {

	/* @GeneratedValue(strategy = GenerationType.AUTO) */
	/* @GeneratedValue(strategy = GenerationType.TABLE) */
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bookingId;
	String userId;
	String coachId;

	@Override
	public String toString() {
		return "BookingEntity [bookingId=" + bookingId + ", userId=" + userId + ", coachId=" + coachId + ", slot="
				+ slot + ", appointmentDate=" + appointmentDate + "]";
	}

	String slot;
	LocalDate appointmentDate;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

}
