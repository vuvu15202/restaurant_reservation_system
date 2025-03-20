package com.hcr.swd392g3.project.dto;

import java.util.Date;


import com.hcr.swd392g3.project.entity.Person;

public class WaitlistDTO {

    private com.hcr.swd392g3.project.entity.Table table;

    private String firstName;
	private String lastName;
	private Person person;
	private String phoneNumber;
	private int personID;
    private Date bookingHour;

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public com.hcr.swd392g3.project.entity.Table getTable() {
		return table;
	}

	public void setTable(com.hcr.swd392g3.project.entity.Table table) {
		this.table = table;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBookingHour() {
		return bookingHour;
	}

	public void setBookingHour(Date bookingHour) {
		this.bookingHour = bookingHour;
	}
    
    
}
