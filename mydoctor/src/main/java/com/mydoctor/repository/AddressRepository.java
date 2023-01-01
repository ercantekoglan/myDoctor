package com.mydoctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydoctor.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
