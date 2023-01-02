package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Sickness;

@Repository
public interface SicknessRepository extends JpaRepository<Sickness, Long> {

}
