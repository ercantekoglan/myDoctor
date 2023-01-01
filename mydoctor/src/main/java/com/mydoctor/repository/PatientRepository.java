package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
