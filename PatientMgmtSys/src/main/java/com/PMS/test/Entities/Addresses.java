package com.PMS.test.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Addresses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressid;
	
	private String type;
	
	private String line1;
	
	private String line2;
	
	private String city;
	
	private String zipCode;
	
	private String stateCode;

	@OneToOne(mappedBy = "address")
	@JsonBackReference
	private Patient patient;

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Addresses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Addresses(int addressid, String type, String line1, String line2, String city, String zipCode,
			String stateCode, Patient patient) {
		super();
		this.addressid = addressid;
		this.type = type;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.zipCode = zipCode;
		this.stateCode = stateCode;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Addresses [addressid=" + addressid + ", type=" + type + ", line1=" + line1 + ", line2=" + line2
				+ ", city=" + city + ", zipCode=" + zipCode + ", stateCode=" + stateCode + ", patient=" + patient + "]";
	}
	
	
}
