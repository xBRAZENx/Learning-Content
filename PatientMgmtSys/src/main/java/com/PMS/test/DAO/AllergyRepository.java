package com.PMS.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PMS.test.Entities.Allergies;

public interface AllergyRepository extends JpaRepository<Allergies, Integer> {

}
