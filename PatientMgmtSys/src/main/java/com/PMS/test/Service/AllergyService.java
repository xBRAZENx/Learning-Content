package com.PMS.test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PMS.test.DAO.AllergyRepository;
import com.PMS.test.DAO.PatientRepository;
import com.PMS.test.Entities.Allergies;
import com.PMS.test.Entities.Patient;

@Service
public class AllergyService {


	@Autowired
	private AllergyRepository allergyRepository;


    public List<Allergies> getAllAllergies()
    {
        List<Allergies> AllergyList = allergyRepository.findAll();
        return AllergyList;
    }
 
    public Allergies saveAllergy(Allergies allergy)
    {
        return allergyRepository.save(allergy);
    }

    public Allergies getAllergy(int id)
    {
        Allergies newAllergy = null;
        Optional<Allergies> allergy = allergyRepository.findById(id);
        if(allergy.isPresent())
        {
            newAllergy = allergy.get();
        }
        return newAllergy;
    }

    public Allergies updateAllergy(Allergies allergy) {
    	return allergyRepository.save(allergy);
    }
    
    public String deleteById(int id)
    {
        allergyRepository.deleteById(id);
        return "Deleted Allergy with id "+id;
    }
	
}
