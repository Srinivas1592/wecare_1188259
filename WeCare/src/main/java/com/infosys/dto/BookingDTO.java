package com.infosys.dto;

import java.time.LocalDate;

public class BookingDTO {
long bookingId;
private String userId;
private String coachId;
private LocalDate appointmentDate;
private String slot;
public long getBookingId() {
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
public LocalDate getAppointmentDate() {
	return appointmentDate;
}
public void setAppointmentDate(LocalDate appointmentDate) {
	this.appointmentDate = appointmentDate;
}
public String getSlot() {
	return slot;
}
public void setSlot(String slot) {
	this.slot = slot;
}
public BookingDTO(int bookingId, String userId, String coachId, LocalDate appointmentDate, String slot) {
	super();
	this.bookingId = bookingId;
	this.userId = userId;
	this.coachId = coachId;
	this.appointmentDate = appointmentDate;
	this.slot = slot;
}
public BookingDTO() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BookingDTO [bookingId=" + bookingId + ", userId=" + userId + ", coachId=" + coachId + ", appointmentDate="
			+ appointmentDate + ", slot=" + slot + "]";
}


}
