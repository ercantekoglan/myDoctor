package com.app.mydoctor.service;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mydoctor.domain.Address;
import com.app.mydoctor.domain.User;
import com.app.mydoctor.dto.UserDto;
import com.app.mydoctor.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(UserDto userDto) {
		
//		String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
		
		User user = new User();
		
		LocalDate localdate = LocalDate.parse(userDto.getBirthDate());
		
		user.setFirstName(userDto.getName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setBirthDate(localdate);
		user.setGender(userDto.getGender());
		user.setRole(userDto.getAuthority());
		user.setPhoneNumber(userDto.getPhoneNumber());
	
		
		Address address = new Address();
		address.setAddressLine1(userDto.getAddressLine1());
		address.setAddressLine2(userDto.getAddressLine2());
		address.setCity(userDto.getCity());
		address.setState(userDto.getState());
		address.setZipcode(userDto.getZipcode());
		address.setUser(user);
		user.setAddress(address);
		

		
	return userRepo.save(user);
	}

}
