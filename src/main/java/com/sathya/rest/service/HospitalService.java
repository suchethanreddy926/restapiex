package com.sathya.rest.service;

import java.time.LocalDateTime;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sathya.rest.entity.Hospital;
import com.sathya.rest.model.HospitalDetails;
import com.sathya.rest.repository.HospitalRepository;


@Service
public class HospitalService {

	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital createHospital(@RequestBody HospitalDetails hospitalDetails) {
		Hospital hospital = new Hospital();
		hospital.setName(hospitalDetails.getName());
		hospital.setLocation(hospitalDetails.getLocation());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setCreateBy(System.getProperty("user.name"));
		hospital.setCreateAt(LocalDateTime.now());
		
		Hospital savedHospital =  hospitalRepository.save(hospital);
		
		return savedHospital;
	}
	
	public Optional<Hospital> getHospital(@PathVariable long id) {

		Optional<Hospital> idHospital = hospitalRepository.findById(id);
		return idHospital;
	}
	
	public List<Hospital> getHospitals(){
		List<Hospital> hospitals = hospitalRepository.findAll();
		return hospitals;
	}
	
	public List<Hospital> saveHospitals(@RequestBody List<HospitalDetails> hospitalDetails){
		
		List<Hospital> hospitals = new ArrayList<>();
		
		for(HospitalDetails hospitalDetails2: hospitalDetails)
		{
			Hospital hospital = new Hospital();
			hospital.setName(hospitalDetails2.getName());
			hospital.setLocation(hospitalDetails2.getLocation());
			hospital.setRating(hospitalDetails2.getRating());
			hospital.setCreateBy(System.getProperty("user.name"));
			hospital.setCreateAt(LocalDateTime.now());
			
			hospitals.add(hospital);
		}
		return hospitalRepository.saveAll(hospitals);
	}

	public void deleteHospital(@PathVariable long id) {
		
		hospitalRepository.deleteById(id);;
	}

	public List<Hospital> getAllDataSorted() {
		Sort sort = Sort.by(Direction.DESC,"name");
		return hospitalRepository.findAll(sort);
	}

	public Page<Hospital> getAllDataPaging(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return hospitalRepository.findAll(pageable);
		
	}
}
