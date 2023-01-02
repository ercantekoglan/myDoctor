package com.mydoctor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mydoctor.domain.Patient;
import com.mydoctor.repository.PatientRepository;


@Service
public class PatientDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private PatientRepository patientRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Patient patient= patientRepo.findByUsername(username);
		if(patient == null)
			throw new UsernameNotFoundException("Username or password was incorrect!");
		
		return new SecurityPatient(patient);
	}

}