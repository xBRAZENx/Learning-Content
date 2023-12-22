package com.PMS.test.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Prescriptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriptionid;
	
	private String NDC;
	
	private String rxNumber;
	
	private String drugName;
	
	private String strength;
	
	private String strengthUnits;
	
	private String supply;
	
	private String refills;
	
	@OneToOne(mappedBy = "prescription")
	@JsonBackReference
	private Patient patient;

	public int getPrescriptionid() {
		return prescriptionid;
	}

	public void setPrescriptionid(int prescriptionid) {
		this.prescriptionid = prescriptionid;
	}

	public String getNDC() {
		return NDC;
	}

	public void setNDC(String nDC) {
		NDC = nDC;
	}

	public String getRxNumber() {
		return rxNumber;
	}

	public void setRxNumber(String rxNumber) {
		this.rxNumber = rxNumber;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getStrengthUnits() {
		return strengthUnits;
	}

	public void setStrengthUnits(String strengthUnits) {
		this.strengthUnits = strengthUnits;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public String getRefills() {
		return refills;
	}

	public void setRefills(String refills) {
		this.refills = refills;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Prescriptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prescriptions(int prescriptionid, String nDC, String rxNumber, String drugName, String strength,
			String strengthUnits, String supply, String refills, Patient patient) {
		super();
		this.prescriptionid = prescriptionid;
		NDC = nDC;
		this.rxNumber = rxNumber;
		this.drugName = drugName;
		this.strength = strength;
		this.strengthUnits = strengthUnits;
		this.supply = supply;
		this.refills = refills;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Prescriptions [prescriptionid=" + prescriptionid + ", NDC=" + NDC + ", rxNumber=" + rxNumber
				+ ", drugName=" + drugName + ", strength=" + strength + ", strengthUnits=" + strengthUnits + ", supply="
				+ supply + ", refills=" + refills + ", patient=" + patient + "]";
	}
	
	
}
