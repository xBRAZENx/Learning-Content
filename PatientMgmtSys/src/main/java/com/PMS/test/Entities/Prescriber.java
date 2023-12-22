package com.PMS.test.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Prescriber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriberid;
	
	private String NPI;
	
	private String firstName;
	
	private String lastName;
	
	private String title;
	
	@OneToOne(mappedBy = "prescriber")
	@JsonBackReference
	private Patient patient;

	public int getPrescriberid() {
		return prescriberid;
	}

	public void setPrescriberid(int prescriberid) {
		this.prescriberid = prescriberid;
	}

	public String getNPI() {
		return NPI;
	}

	public void setNPI(String nPI) {
		NPI = nPI;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Prescriber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescriber(int prescriberid, String nPI, String firstName, String lastName, String title, Patient patient) {
		super();
		this.prescriberid = prescriberid;
		NPI = nPI;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Prescriber [prescriberid=" + prescriberid + ", NPI=" + NPI + ", firstName=" + firstName + ", lastName="
				+ lastName + ", title=" + title + ", patient=" + patient + "]";
	}
	
	 
}
