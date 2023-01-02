package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
