package com.app.mydoctor.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.mydoctor.domain.Address;
import com.app.mydoctor.domain.Authority;
import com.app.mydoctor.domain.User;
import com.app.mydoctor.dto.AddressDto;
import com.app.mydoctor.dto.PasswordDto;
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
		if(userDto.getRole().equals("Patient")) {
			authority.setAuthority("ROLE_PATIENT");
		}else if(userDto.getRole().equals("Doctor")) {
			authority.setAuthority("ROLE_DOCTOR");
		}
		
		user.getAuthorities().add(authority);
		authority.setUser(user);

		
	userRepo.save(user);
	}

	public User findById(Long userIdd) {
		Optional<User> findById = userRepo.findById(userIdd);
		return findById.orElse(null);
	}

	public void updatePersonalInfo(User user, PersonalInfoDto personalInfoDto) {

		
		user.setFirstName(personalInfoDto.getFirstName());
		user.setLastName(personalInfoDto.getLastName());
		user.setEmail(personalInfoDto.getEmail());
		user.setPhoneNumber(personalInfoDto.getPhoneNumber());
	
		userRepo.save(user);
		
	}

	public void updateAddress(User user, AddressDto addressDto) {
		
		user.getAddress().setAddressLine1(addressDto.getAaddressLine1());
		user.getAddress().setAddressLine2(addressDto.getAaddressLine1());
		user.getAddress().setCity(addressDto.getAcity());
		user.getAddress().setState(addressDto.getAstate());
		user.getAddress().setZipcode(addressDto.getAzipcode());
		
		userRepo.save(user);
	}

	public void updatePassword(User user, PasswordDto passwordDto) {
	user.setPassword(passwordDto.getNewpasswords());
	userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
		
	}

}
