package com.sathya.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.rest.entity.Hospital;
import com.sathya.rest.model.HospitalDetails;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
