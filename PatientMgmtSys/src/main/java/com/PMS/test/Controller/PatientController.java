package com.PMS.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PMS.test.Entities.Patient;
import com.PMS.test.Service.PatientService;


@RestController
public class PatientController {
	
	@Autowired
	private PatientService pService;
	
	@GetMapping("/patients")
	 List<Patient> getPatients(){
		return pService.getAllPatients();
	}
	
	@GetMapping("/patients/{id}")
	Patient getPatient(@PathVariable("id") int id) {
		return pService.getPatient(id);
	}
	
	@PostMapping("/patients")
	Patient savePatient(@RequestBody Patient patient) {
		return pService.savePatient(patient);
	}
	
	@PutMapping("/patients/{id}")
	Patient updatePatient(@RequestBody Patient patient,@PathVariable("id")int id) {
		patient.setId(id);
		return pService.updatePatient(patient);
	}
	
	@DeleteMapping("/patients/{id}")
	String deletePatient(@PathVariable("id") int id)
	{
		pService.deleteById(id);
		return "Patient removed for id "+id;
	}
}
