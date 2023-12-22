package com.PMS.test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PMS.test.DAO.*;
import com.PMS.test.Entities.*;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;


    public List<Patient> getAllPatients()
    {
        List<Patient> patientList = patientRepository.findAll();
        return patientList;
    }
 
    public Patient savePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }

    public Patient getPatient(int id)
    {
        Patient newPatient = null;
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent())
        {
            newPatient = patient.get();
        }
        return newPatient;
    }

    public Patient updatePatient(Patient patient) {
    	return patientRepository.save(patient);
    }
    
    public String deleteById(int id)
    {
        patientRepository.deleteById(id);
        return "Deleted Patient with patient id "+id;
    }
}
