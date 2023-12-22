package com.PMS.test.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Clinical {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clinicalid;
	
	private String height;
	
	private String weight;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="allergy_id")
	@JsonManagedReference
	private Allergies allergy;

	@OneToOne(mappedBy = "clinical")
	@JsonBackReference 
	private Patient patient;

	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public int getClinicalid() {
		return clinicalid;
	}


	public void setClinicalid(int clinicalid) {
		this.clinicalid = clinicalid;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public Allergies getAllergy() {
		return allergy;
	}


	public void setAllergy(Allergies allergy) {
		this.allergy = allergy;
	}


	public Clinical(int clinicalid, String height, String weight, Allergies allergy) {
		super();
		this.clinicalid = clinicalid;
		this.height = height;
		this.weight = weight;
		this.allergy = allergy;
	}


	public Clinical() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Clinical [clinicalid=" + clinicalid + ", height=" + height + ", weight=" + weight + ", allergy="
				+ allergy + "]";
	}
	
	
	
	
	
	
	

}
