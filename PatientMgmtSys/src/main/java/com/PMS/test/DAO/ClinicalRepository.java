package com.PMS.test.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PMS.test.Entities.Clinical;

public interface ClinicalRepository extends JpaRepository<Clinical, Integer> {

}
