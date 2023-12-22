package com.PMS.test.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Insurance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insuranceid;
	
	private String policyHolderFirstName;
	
	private String policyHolderLastName;
	
	private String primaryRxBin;

	@OneToOne(mappedBy = "insurance")
	@JsonBackReference
	private Patient patient;

	public int getInsuranceid() {
		return insuranceid;
	}

	public void setInsuranceid(int insuranceid) {
		this.insuranceid = insuranceid;
	}

	public String getPolicyHolderFirstName() {
		return policyHolderFirstName;
	}

	public void setPolicyHolderFirstName(String policyHolderFirstName) {
		this.policyHolderFirstName = policyHolderFirstName;
	}

	public String getPolicyHolderLastName() {
		return policyHolderLastName;
	}

	public void setPolicyHolderLastName(String policyHolderLastName) {
		this.policyHolderLastName = policyHolderLastName;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	public String getPrimaryRxBin() {
		return primaryRxBin;
	}

	public void setPrimaryRxBin(String primaryRxBin) {
		this.primaryRxBin = primaryRxBin;
	}

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insurance(int insuranceid, String policyHolderFirstName, String policyHolderLastName, Patient patient) {
		super();
		this.insuranceid = insuranceid;
		this.policyHolderFirstName = policyHolderFirstName;
		this.policyHolderLastName = policyHolderLastName;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Insurance [insuranceid=" + insuranceid + ", policyHolderFirstName=" + policyHolderFirstName
				+ ", policyHolderLastName=" + policyHolderLastName + ", patient=" + patient + "]";
	}
	
	
	
}
