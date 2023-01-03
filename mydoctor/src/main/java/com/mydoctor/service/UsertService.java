package com.mydoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mydoctor.domain.Address;
import com.mydoctor.domain.Authority;
import com.mydoctor.domain.User;
import com.mydoctor.dto.UserDto;
import com.mydoctor.repository.UserRepository;

@Service
public class UsertService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(UserDto userDto) {
		
		String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
		
		User user = new User();
		
		user.setName(userDto.getName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(encodedPassword);
		user.setBirthDate(userDto.getBirthDate());
		user.setGender(userDto.getGender());
		user.setPhoneNumber(userDto.getPhoneNumber());
	
		
		Address address = new Address();
		address.setAddressLine1(userDto.getAddressLine1());
		address.setAddressLine2(userDto.getAddressLine2());
		address.setCity(userDto.getCity());
		address.setState(userDto.getState());
		address.setZipcode(userDto.getZipcode());
		address.setUser(user);
		user.setAddress(address);
		
		Authority authority = new Authority();
		authority.setAuthority(userDto.getAuthority());
		authority.setUser(user);
		user.getAuthorities().add(authority);

		
	return userRepo.save(user);
	}

}
