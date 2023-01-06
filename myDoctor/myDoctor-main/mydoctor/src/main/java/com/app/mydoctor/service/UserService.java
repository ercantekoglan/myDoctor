package com.app.mydoctor.service;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.mydoctor.domain.Address;
import com.app.mydoctor.domain.Authority;
import com.app.mydoctor.domain.User;
import com.app.mydoctor.dto.PersonalInfoDto;
import com.app.mydoctor.dto.UserDto;
import com.app.mydoctor.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void saveUser(UserDto userDto) {

		String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
		
		User user = new User();
		
		LocalDate localdate = LocalDate.parse(userDto.getDateBirth());
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(encodedPassword);
		user.setBirthDate(localdate);
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
		authority.setAuthority("ROLE_PATIENT");
		user.getAuthorities().add(authority);
		authority.setUser(user);

		
	userRepo.save(user);
	}

	public User findById(Long userIdd) {
		Optional<User> findById = userRepo.findById(userIdd);
		return findById.orElse(null);
	}

	public void updateUser(User user, PersonalInfoDto personalInfoDto) {

		
		user.setFirstName(personalInfoDto.getFirstName());
		user.setLastName(personalInfoDto.getLastName());
		user.setEmail(personalInfoDto.getEmail());
		user.setPhoneNumber(personalInfoDto.getPhoneNumber());
	
		userRepo.save(user);
		
	}

}
