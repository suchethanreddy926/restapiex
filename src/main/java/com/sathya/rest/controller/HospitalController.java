package com.sathya.rest.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.entity.Hospital;
import com.sathya.rest.model.HospitalDetails;
import com.sathya.rest.service.HospitalService;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/save")
	public Hospital createHospital(@RequestBody HospitalDetails hospitalDetails) {
		return hospitalService.createHospital(hospitalDetails);
	}
	
	@GetMapping("/{id}")
	public Optional<Hospital> getHospital(@PathVariable long id) {
		return hospitalService.getHospital(id);
	}
	
	@GetMapping("/getall")
	public List<Hospital> getHospitals() {
		return hospitalService.getHospitals();
	}
	
	@PostMapping("/saveall")
	public List<Hospital> saveHospitals(@RequestBody List<HospitalDetails> hospitalDetails){
		return hospitalService.saveHospitals(hospitalDetails);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteHospital(@PathVariable long id) {
		hospitalService.deleteHospital(id);
	}
	
	@GetMapping("/getallsort")
	public List<Hospital> getAllHospitalSorted(){
		return hospitalService.getAllDataSorted();
	}
	
	@GetMapping("/{pageNumber}/{pageSize}")
	public Page<Hospital> getAllHositalPaging(@PathVariable int pageNumber,
												@PathVariable int pageSize){
		return hospitalService.getAllDataPaging(pageNumber, pageSize);
	}
	
}