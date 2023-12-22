package com.PMS.test.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactid;
	
	private String type;
	
	private String value;
	
	@OneToOne(mappedBy = "contact")
	@JsonBackReference
	private Patient patient;

	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contactid, String type, String value, Patient patient) {
		super();
		this.contactid = contactid;
		this.type = type;
		this.value = value;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Contact [contactid=" + contactid + ", type=" + type + ", value=" + value + ", patient=" + patient + "]";
	}
	
	
}
