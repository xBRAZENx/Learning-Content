package com.PMS.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PMS.test.Entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
