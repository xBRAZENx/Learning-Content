package com.PMS.test.Entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="gender")
    private String gender;
    @Column(name="date_of_birth")
    //@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="clinical_id")
	@JsonManagedReference
	private Clinical clinical;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="insurance_id")
	@JsonManagedReference
	private Insurance insurance;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	@JsonManagedReference
	private Addresses address;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id")
	@JsonManagedReference
	private Contact contact;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="prescriber_id")
	@JsonManagedReference
	private Prescriber prescriber;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="prescription_id")
	@JsonManagedReference
	private Prescriptions prescription;
    
    
    
	public Prescriber getPrescriber() {
		return prescriber;
	}
	public void setPrescriber(Prescriber prescriber) {
		this.prescriber = prescriber;
	}
	public Prescriptions getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescriptions prescription) {
		this.prescription = prescription;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Addresses getAddress() {
		return address;
	}
	public void setAddress(Addresses address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Clinical getClinical() {
		return clinical;
	}
	public void setClinical(Clinical clinical) {
		this.clinical = clinical;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Patient(int id, String firstName, String lastName, String gender, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
