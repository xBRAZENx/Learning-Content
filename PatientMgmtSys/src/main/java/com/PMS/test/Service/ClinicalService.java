package com.PMS.test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PMS.test.DAO.ClinicalRepository;

import com.PMS.test.Entities.Clinical;

@Service
public class ClinicalService {


	@Autowired
	private ClinicalRepository clinicalRepository;


    public List<Clinical> getAllClinical()
    {
        List<Clinical> ClinicalList = clinicalRepository.findAll();
        return ClinicalList;
    }
 
    public Clinical saveClinical(Clinical clinical)
    {
        return clinicalRepository.save(clinical);
    }

    public Clinical getClinical(int id)
    {
        Clinical newClinical = null;
        Optional<Clinical> clinical = clinicalRepository.findById(id);
        if(clinical.isPresent())
        {
            newClinical = clinical.get();
        }
        return newClinical;
    }

    public Clinical updateClinical(Clinical clinical) {
    	return clinicalRepository.save(clinical);
    }
    
    public String deleteById(int id)
    {
        clinicalRepository.deleteById(id);
        return "Deleted Clinical Information with id "+id;
    }
	
}
