package com.app.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mydoctor.domain.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}
