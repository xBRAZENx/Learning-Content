package com.PMS.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PMS.test.DAO.ClinicalRepository;
import com.PMS.test.Entities.Allergies;
import com.PMS.test.Entities.Clinical;


@SpringBootApplication
public class PatientMgmtSysApplication {
	
//	@Autowired
//	private static ClinicalRepository clinicalrepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PatientMgmtSysApplication.class, args);
		
//		Clinical clinical = new Clinical();
//		clinical.setHeight("6ft");
//		clinical.setWeight("62kg");
//		clinical.setClinicalid(11);
//		
//		Allergies allergy = new Allergies();
//		allergy.setCategory("Food");
//		allergy.setClinical_status("active");
//		allergy.setSeverity("Mild");
//		allergy.setAllergyid(11);
//		
//		
//		allergy.setClinical(clinical);
//		clinical.setAllergy(allergy);
//		
//		Clinical savec = clinicalrepo.save(clinical);
		
		
	}

}
