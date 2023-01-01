package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mydoctor.domain.Avatar;

@Repository
public interface AvatartRepository extends JpaRepository<Avatar, Long>{

}
