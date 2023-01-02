package com.mydoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mydoctor.domain.Authority;
import com.mydoctor.domain.Patient;
import com.mydoctor.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	public Patient savePatient(Patient patient) {
		
		String encodedPassword = new BCryptPasswordEncoder().encode(patient.getPassword());
		
		Authority authority = new Authority();
		
		authority.setAuthority("ROLE_PATIENT");
		authority.setPatient(patient);
		
		patient.getAuthorities().add(authority);
		patient.setPassword(encodedPassword);
		
	return patientRepo.save(patient);
	}

}
