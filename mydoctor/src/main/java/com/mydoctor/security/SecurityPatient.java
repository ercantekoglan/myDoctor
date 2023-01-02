package com.mydoctor.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.mydoctor.domain.Patient;

public class SecurityPatient extends Patient implements UserDetails {
	private static final long serialVersionUID = -768590123482494682L;

	

	public SecurityPatient(Patient patient) {
		this.setAuthorities(patient.getAuthorities());
		this.setId(patient.getId());
		this.setPassword(patient.getPassword());
		this.setUsername(patient.getUsername());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
