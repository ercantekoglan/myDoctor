package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	
	@Query("select u from Patient u"
		      + " left join fetch u.authorities"
		      + " where u.username = :username")
	Patient findByUsername(String username);

}
