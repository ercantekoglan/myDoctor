package com.app.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mydoctor.domain.Address;
	
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
