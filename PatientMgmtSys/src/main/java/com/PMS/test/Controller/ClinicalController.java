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

import com.PMS.test.Entities.Clinical;
import com.PMS.test.Service.ClinicalService;


@RestController
public class ClinicalController {

	@Autowired
	private ClinicalService cService;
	
	@GetMapping("/clinical")
	 List<Clinical> getClinical(){
		return cService.getAllClinical();
	}
	
	@GetMapping("/clinical/{clinicalid}")
	Clinical getClinical(@PathVariable("clinicalid") int clinicalid) {
		return cService.getClinical(clinicalid);
	}
	
	@PostMapping("/clinical")
	Clinical saveClinical(@RequestBody Clinical clinical) {
		return cService.saveClinical(clinical);
	}
	
	@PutMapping("/clinical/{clinicalid}")
	Clinical updateClinical(@RequestBody Clinical clinical,@PathVariable("clinicalid")int clinicalid) {
		clinical.setClinicalid(clinicalid);
		return cService.updateClinical(clinical);
	}
	
	@DeleteMapping("/clinical")
	String deleteClinical(@PathVariable("clinicalid") int clinicalid)
	{
		cService.deleteById(clinicalid);
		return "Patient removed for id "+clinicalid;
	}
}
